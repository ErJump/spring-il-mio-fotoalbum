<template>
  <div class="mt-4 ms_container">
    <div class="row pb-5">
      <div class="col-12 d-flex justify-content-between">
        <h1 class="text-primary mb-2">Le mie foto</h1>
        <div class="d-flex align-items-center">
          <input type="text" class="form-control" placeholder="Cerca" v-model="searchValue">
          <button class="btn btn-success" @click="getFilteredPhotos()"><i class="fa-solid fa-magnifying-glass"></i></button>
        </div>
      </div>
      <div class="p-3 col-12" v-for="photo in photos"  :key="photo.id" 
      :class="(photo.visible ? ' ' : 'd-none')" 
      @click="setActivePhotoIndex(getIndexFromPhotoId(photo.id)), getPhotoCategories(photo.id)">
        <div  class="card px-0 ms_bg_light_dark text-white h-100" >
          <div v-if="photo.visible">
            <img class="card-img-top img-fluid" :src="photo.url" alt="Card image cap ">
            <div class="card-body">
              <div class="d-flex justify-content-between">
                <h5 class="card-title text-primary">{{photo.title}}</h5>
                <span class="bg-primary rounded text-white p-2 mb-3 d-inline-block"> {{photo.tag}}</span>
              </div>
              <p class="card-text"><strong>Descrizione: </strong> {{photo.description}}</p>
            </div>
            <div v-if="activePhotoIndex === getIndexFromPhotoId(photo.id)" class="pb-3">
              <div v-if="photo.categories != null" class="w-100 text-white px-3 mb-3">
                <strong>Categorie: </strong>
                <span class="d-inline-block me-1 text-primary" v-for="category in photo.categories" :key="category.id">#{{category.name}} </span>
              </div>
              <div v-if="photo.comments != null" class="w-100 text-white px-3">
                <strong class="d-inline-block mb-2">({{getArrayLength(photo.comments)}}) Commenti:</strong>
                <div class="d-flex align-items-center mb-2">
                  <input type="text" class="form-control" placeholder="Inserisci un commento" v-model="userComment">
                  <button class="btn btn-success" @click="postComment(photo.id)"><i class="fa-solid fa-paper-plane"></i></button>
                </div>
                <ul>
                  <li v-for="comment in photo.comments" :key="comment.id">
                    <span>{{comment.text}}</span>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

const API_URL = 'http://localhost:8080/api/1/';
const ACTIVE_PICTURE_INDEX = -1;


export default {
  name: 'Main',
  data() {
    return {
      photos: [],
      activePhotoIndex: ACTIVE_PICTURE_INDEX,
      searchValue: '',
      userComment: '',
      newComment: { text: '', photo: ''},
    }
  },
  methods: {
    getPhotos() {
      axios.get(API_URL + 'pictures')
        .then(response => {
          this.photos = response.data;
        })
        .catch(error => {
          console.log(error);
        });
    },
    getPhotoCategories(photoId) {
      axios.get(API_URL + 'class/by/picture/' + photoId)
        .then(response => {
          const photoCategories = response.data;
          if (photoCategories == null) return

          const index = this.getIndexFromPhotoId(photoId);
          this.photos[index].categories = photoCategories;
        })
        .catch(error => {
          console.log(error);
        });
    },
    getPhotoComments(photoId) {
      axios.get(API_URL + 'comments/by/picture/' + photoId)
        .then(response => {
          const photoComments = response.data;
          if (photoComments == null) return

          const index = this.getIndexFromPhotoId(photoId);
          this.photos[index].comments = photoComments;
        })
        .catch(error => {
          console.log(error);
        });
    },
    getFilteredPhotos(){
      if(this.searchValue === '') return this.getPhotos();

      axios.get(API_URL + 'pictures/search/' + this.searchValue)
        .then(response => {
          this.photos = response.data;
        })
        .catch(error => {
          console.log(error);
        });
    },
    postComment(photoId){
      this.newComment.photo = photoId;
      this.newComment.text = this.userComment;

      axios.post(API_URL + 'comments/add/' + photoId , this.newComment)
        .then(response => {
          this.getPhotoComments(photoId);
          this.userComment = '';
        })
        .catch(error => {
          console.log(error);
        });
    },
    setActivePhotoIndex(index){
      this.activePhotoIndex = index;
    },
    getIndexFromPhotoId(id){
      return this.photos.findIndex(photo => photo.id === id);
    },
    isActiveIndexNotActive(){
      return this.activePhotoIndex !== ACTIVE_PICTURE_INDEX;
    },
    getArrayLength(array){
      return array.length;
    }
  },
  mounted() {
    this.getPhotos();
  }

}
</script>

<style scoped>
  div.col-12.p-3 div.card{
    cursor: pointer;
    transition: .5s;
  }
  div.col-12.p-3:hover div.card{
    border: 3px solid white;
  }

  .ms_container{
    max-width: 600px;
    min-height: 100vh;
    margin: auto;
    padding-left: 100px;
    overflow: hidden;
  }
</style>

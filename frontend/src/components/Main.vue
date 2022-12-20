<template>
  <div class="mt-4 container-lg">
    <div class="row pb-5">
      <div class="col-12 d-flex justify-content-between">
        <h1 class="text-primary mb-2">Le mie foto</h1>
        <div class="d-flex align-items-center">
          <input type="text" class="form-control" placeholder="Cerca" v-model="searchValue">
          <button class="btn btn-success" @click="getFilteredPhotos()">Cerca</button>
        </div>
      </div>
      <div class="col-12 col-md-6 p-3" v-for="photo in photos"  :key="photo.id" :class="photo.visible ? ' ' : 'd-none'" @click="setActivePhotoIndex(getIndexFromPhotoId(photo.id)), getPhotoCategories(photo.id)">
        <div  class="card px-0 ms_bg_light_dark text-white h-100" :class="photo.visible ? ' ' : 'd-none'">
          <div v-if="photo.visible">
            <img class="card-img-top" :src="photo.url" alt="Card image cap img-fluid">
            <div class="card-body">
              <div class="d-flex justify-content-between">
                <h5 class="card-title">{{photo.title}}</h5>
                <span class="bg-primary rounded text-white p-2 mb-3 d-inline-block"> {{photo.tag}}</span>
              </div>
              <p class="card-text">{{photo.description}}</p>
            </div>
            <div v-if="activePhotoIndex === getIndexFromPhotoId(photo.id)" class="pb-3">
              <div v-if="photo.categories != null" class="w-100 text-white px-3">
                <strong>Categorie: </strong>
                <span class="d-inline-block me-1 text-primary" v-for="category in photo.categories" :key="category.id">#{{category.name}} </span>
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
    getPhotoCategories(photoId){
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
    setActivePhotoIndex(index){
      this.activePhotoIndex = index;
    },
    getIndexFromPhotoId(id){
      return this.photos.findIndex(photo => photo.id === id);
    },
  },
  mounted() {
    this.getPhotos();
  }

}
</script>

<style scoped>
  div.col-12.col-md-6.p-3{
    cursor: pointer;
    transition: 1s;
  }
  div.col-12.col-md-6.p-3:hover{
    transform: scale(1.05);
  }
</style>

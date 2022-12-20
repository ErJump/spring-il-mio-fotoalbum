<template>
  <div class="mt-4 container-lg">
    <div class="row pb-5">
      <div class="col-12">
        <h1 class="text-center text-white mb-2">Le mie foto</h1>
      </div>
      <div class="col-12 col-md-6 p-3" v-for="photo in photos"  :key="photo.id" :class="photo.visible ? ' ' : 'd-none'">
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
      photos: []

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
    }
  },
  mounted() {
    this.getPhotos();
  }

}
</script>

<style scoped>

</style>

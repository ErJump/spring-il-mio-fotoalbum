<template>
  <div class="ms_bg_dark">
    <Header />
    <Main />
  </div>
</template>

<script>
import Main from './components/Main.vue';
import Header from './components/partials/Header.vue';

export default {
  name: 'App',
  components: {
    Main,
    Header
  }
}
</script>

<style>  
  .ms_bg_dark{
    background-color: #212529;
  }

  .ms_bg_light_dark{
    background-color: #313131;
  }
</style>

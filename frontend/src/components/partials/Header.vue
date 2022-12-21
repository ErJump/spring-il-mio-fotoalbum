<template>
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark px-3 d-flex flex-column align-items-start ms_bg_darker h-100 position-fixed">
            <a class="navbar-brand text-primary my-4" href="#">Jump's Gallery</a>
            <div class="navbar-nav d-flex flex-column">
                <a class="nav-item nav-link active" href="#">Home</a>
                <a class="nav-item nav-link" href="http://localhost:8080/photo">Backoffice</a>
            </div>
        </nav>
    </header>
</template>

<script>
export default {
    name: 'Header',
    data() {
        return {
            
        }
    }
}
</script>

<style scoped>
    .ms_bg_darker{
        background-color: #1d1e1f !important;
    }
</style>
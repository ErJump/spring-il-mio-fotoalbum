<template>
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark px-3">
            <a class="navbar-brand" href="#">Jump's Gallery</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                <a class="nav-item nav-link active" href="#">Home</a>
                <a class="nav-item nav-link" href="http://localhost:8080/photo">Backoffice</a>
                </div>
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

</style>
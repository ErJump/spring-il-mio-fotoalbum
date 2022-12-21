<template>
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark px-3 d-flex flex-column align-items-start ms_bg_darker h-100 position-fixed">
            <a class="navbar-brand text-primary my-4" href="#"><img class="ms_logo" src="../../assets/jg.png" alt="logo"></a>
            <div class="navbar-nav d-flex flex-column">
                <a class="nav-item nav-link active" href="#"><i class="fa-solid fa-house display-inline-block me-2"></i> Home</a>
                <a class="nav-item nav-link" href="http://localhost:8080/photo"><i class="fa-solid fa-toolbox display-inline-block me-2"></i> Backoffice</a>
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

    .ms_logo{
        height: 35px;
    }
</style>
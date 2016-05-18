<template>
    <nav>
        <ul class="pagination">
            <li  :class="{'disabled':Previous}" @click="pageChanges(--page.pageNum)" >
                <a href="#" aria-label="Previous" >
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <template v-for="item in page.pageTotal">
                <li @click="pageChanges(page.pageNum=$index+1)"><a href="#">{{item+1}}</a></li>
            </template>
            <li :class="{'disabled':Next}">
                <a href="#"  aria-label="Next" @click="pageChanges(++page.pageNum)">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</template>
<script>
    export default {
        data(){
            return{
                Previous:false,
                Next:false
            }
        },
        ready(){
           this.initPage();
        },
        props: ['page'],
        methods:{
            pageChanges(e){
                this.initPage();
                this.$dispatch('page-nextPage', this.page.pageNum)
            },
            initPage(){
                if(this.page.pageNum==1){
                    this.Previous=true;
                }else{
                    this.Previous=false;
                }
                if(this.page.pageTotal==this.page.pageNum){
                    this.Next=true
                }else{
                    this.Next=false
                }
            }
        }
    }
</script>
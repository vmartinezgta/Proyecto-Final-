<template>
  <div>
    <table>
      <tbody>
          <tr v-for="todo in todos" :key="id"> 
          <td>{{ todo.userId }}</td>
          <td>{{ todo.id }}</td>
          <td>{{ todo.title }}</td> 
          <td>{{ todo.completed }}</td>
          </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from 'axios'
export default{
  data(){
    return{
      todos:null
    }
  },
  mounted(){
    this.getTodos();
  },
  methods:  {
    getTodos(){
      axios
         .get('https://jsonplaceholder.typicode.com/todos')
            .then( Response => {
                console.log(Response)
                this.todos = Response.data
            })
            .catch(e=> console.log(e))
    }
  }
}
</script>

<style>
</style>

import Vue from 'vue'
import App from './App.vue'
import store from './store'
import AxiosPlugin from 'vue-axios-cors';
Vue.use(AxiosPlugin)
Vue.config.productionTip = false

new Vue({
  store,
  render: h => h(App)
}).$mount('#app')

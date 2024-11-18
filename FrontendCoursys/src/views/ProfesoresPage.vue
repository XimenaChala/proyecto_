<template>
    <CrudComponent
      ref="crudComponent"
      title="Profesores"
      :items="profesores"
      :current-item="currentItem"
      @save="saveProfesores"
      @delete="deleteProfesores"
      @edit="editProfesores"
    >
      <template #form>
        <ion-item>
          <ion-label position="floating">Nombre</ion-label>
          <ion-input v-model="currentItem.nombre"></ion-input>
        </ion-item>
        <ion-item>
          <ion-label position="floating">Especialidad</ion-label>
          <ion-input v-model="currentItem.especialidad"></ion-input>
        </ion-item>
        <ion-item>
          <ion-label position="floating">Email</ion-label>
          <ion-input v-model="currentItem.email"></ion-input>
        </ion-item>
      </template>
    </CrudComponent>
  </template>
  
  <script>
  import CrudComponent from '@/components/CrudComponent.vue';
  import { getAllProfesores, saveProfesores, updateProfesores, deleteProfesores } from '@/services/profesores-service';
  import {
    IonItem,
    IonLabel,
    IonInput,
    IonButton,
    IonModal,
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonPage,
    IonCard,
    IonCardHeader,
    IonCardTitle,
    IonCardContent,
    IonIcon
  } from '@ionic/vue';
  
  export default {
    name: 'ProfesoresPage',
    components: {
      CrudComponent,
      IonItem,
      IonLabel,
      IonInput,
      IonButton,
      IonModal,
      IonHeader,
      IonToolbar,
      IonTitle,
      IonContent,
      IonPage,
      IonCard,
      IonCardHeader,
      IonCardTitle,
      IonCardContent,
      IonIcon
    },
    data() {
      return {
        currentItem: {
          id: null,
          nombre: '',
          especialidad: '',
          email: ''
        },
        profesores: []
      };
    },
    async mounted() {
      await this.loadProfesores();
    },
    methods: {
      async loadProfesores() {
        try {
          this.profesores = await getAllProfesores();
        } catch (error) {
          console.error('Error al cargar profesores:', error);
          alert('Error al cargar la lista de profesores');
        }
      },
      async saveProfesores() {
        try {
          if (this.currentItem.id) {
            await updateProfesores(this.currentItem,this.currentItem.id);
          } else {
            await saveProfesores(this.currentItem);
          }
          await this.loadProfesores();
          this.resetForm();
        } catch (error) {
          console.error('Error al guardar profesores:', error);
          alert('Error al guardar el profesores');
        }
      },
      async deleteProfesores(id) {
        try {
          await deleteProfesores(id);
          await this.loadProfesores();
        } catch (error) {
          console.error('Error al eliminar profesores:', error);
          alert('Error al eliminar el profesores');
        }
      },
      editProfesores(profesores) {
        this.currentItem = { ...profesores }; // Copiar los datos de profesores a currentItem
        this.$refs.crudComponent.openEditModal(); // Llamar al método en CrudComponent para abrir el modal
      },
      resetForm() {
        this.currentItem = { id: null, nombre: '', especialidad: '', email: '' };
      }
    }
  };
  </script>
  
  <style scoped>
  .button-group {
    display: flex;
    justify-content: flex-end;
    gap: 6px;
    margin-top: 8px;
  }
  
  ion-item {
    --padding-start: 16px;
    --inner-padding-top: 0x; 
    --inner-padding-bottom: 0px;
  }
  
  ion-label {
    line-height: 0.2; 
  }
  </style>
  
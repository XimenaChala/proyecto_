<template>
    <CrudComponent
      ref="crudComponent"
      title="Estudiantes"
      :items="estudiantes"
      :current-item="currentItem"
      @save="saveEstudiantes"
      @delete="deleteEstudiantes"
      @edit="editEstudiantes"
    >
      <template #form>
        <ion-item>
          <ion-label position="floating">Nombre</ion-label>
          <ion-input v-model="currentItem.nombre"></ion-input>
        </ion-item>
        <ion-item>
          <ion-label position="floating">Cedula</ion-label>
          <ion-input v-model="currentItem.cedula"></ion-input>
        </ion-item>
        <ion-item>
          <ion-label position="floating">Telefono</ion-label>
          <ion-input v-model="currentItem.telefono"></ion-input>
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
  import { getAllEstudiantes, saveEstudiantes, updateEstudiantes, deleteEstudiantes } from '@/services/estudiantes-service';
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
    name: 'EstudiantesPage',
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
          cedula: '',
          nombre: '',
          email: '',
          telefono: ''
        },
        estudiantes: []
      };
    },
    async mounted() {
      await this.loadEstudiantes();
    },
    methods: {
      async loadEstudiantes() {
        try {
          this.estudiantes = await getAllEstudiantes();
        } catch (error) {
          console.error('Error al cargar estudiantes:', error);
          alert('Error al cargar la lista de estudiantes');
        }
      },
      async saveEstudiantes() {
        try {
          if (this.currentItem.id) {
            await updateEstudiantes(this.currentItem,this.currentItem.id);
          } else {
            await saveEstudiantes(this.currentItem);
          }
          await this.loadEstudiantes();
          this.resetForm();
        } catch (error) {
          console.error('Error al guardar estudiantes:', error);
          alert('Error al guardar el estudiantes');
        }
      },
      async deleteEstudiantes(id) {
        try {
          await deleteEstudiantes(id);
          await this.loadEstudiantes();
        } catch (error) {
          console.error('Error al eliminar estudiantes:', error);
          alert('Error al eliminar el estudiantes');
        }
      },
      editEstudiantes(estudiantes) {
        this.currentItem = { ...estudiantes }; // Copiar los datos de estudiantes a currentItem
        this.$refs.crudComponent.openEditModal(); // Llamar al método en CrudComponent para abrir el modal
      },
      resetForm() {
        this.currentItem = { id: null, cedula: '', nombre: '', email: '', telefono: '' };
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
  
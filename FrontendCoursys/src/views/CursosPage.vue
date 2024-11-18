<template>
    <CrudComponent
      ref="crudComponent"
      title="Cursos"
      :items="processedCursos"
      :current-item="currentItem"
      @save="saveCursos"
      @delete="deleteCursos"
      @edit="editCursos"
    >
      <template #form>
        <ion-item>
          <ion-label position="floating">Nombre</ion-label>
          <ion-input v-model="currentItem.nombre"></ion-input>
        </ion-item>
        <ion-item>
          <ion-label position="floating">Estudiante</ion-label>
          <ion-select v-model="currentItem.estudiantesId.id" interface="popover">
            <ion-select-option
              v-for="estudiantes in estudiantes"
              :key="estudiantes.id"
              :value="estudiantes.id"
            >
              {{ estudiantes.nombre }}
            </ion-select-option>
          </ion-select>
        </ion-item>
        <ion-item>
          <ion-label position="floating">Profesor</ion-label>
          <ion-select v-model="currentItem.profesoresId.id" interface="popover">
            <ion-select-option
              v-for="profesores in profesores"
              :key="profesores.id"
              :value="profesores.id"
            >
              {{ profesores.nombre }}
            </ion-select-option>
          </ion-select>
        </ion-item>
        <ion-item>
          <ion-label position="floating">Horas</ion-label>
          <ion-input v-model="currentItem.horas"></ion-input>
        </ion-item>
        <ion-item>
          <ion-label position="floating">Precio</ion-label>
          <ion-input v-model="currentItem.precio"></ion-input>
        </ion-item>
        <ion-item>
          <ion-label position="floating">Fecha Inicio</ion-label>
          <ion-datetime
            v-model="currentItem.fechaInicio"
            display-format="YYYY-MM-DD"
            placeholder="Selecciona una fecha"
          ></ion-datetime>
        </ion-item>
      </template>
    </CrudComponent>
  </template>
  
  <script>
  import CrudComponent from '@/components/CrudComponent.vue';
  import { getAllCursos, saveCursos, updateCursos, deleteCursos } from '@/services/cursos-service';
  import { getAllProfesores } from '@/services/profesores-service';
  import { getAllEstudiantes } from '@/services/estudiantes-service';
  import {
    IonItem,
    IonLabel,
    IonInput,
    IonButton,
    IonSelect,
    IonSelectOption,
    IonDatetime,
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
    name: 'CursosPage',
    components: {
      CrudComponent,
      IonItem,
      IonLabel,
      IonInput,
      IonButton,
      IonSelect,
      IonSelectOption,
      IonDatetime,
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
            nombre: null,
            estudiantesId: { id: null },
            profesoresId: { id: null },
            horas: null,
            precio: null,
            fechaInicio: null,
          },
          Cursos: [],
          profesores: [],
          estudiantes: [],
          processedCursos: [], // Lista procesada para mostrar en CrudComponent
        };
      },
      async mounted() {
        await this.loadCursos();
        await this.loadProfesores();
        await this.loadEstudiantes();
      },
      methods: {
        async loadCursos() {
          try {
            const cursosData = await getAllCursos();
  
            // Procesar la data para que solo contenga los campos necesarios
            this.processedCursos= cursosData.map((item, index) => ({
              id: item.id,
              nombre: item.nombre,
              estudiantesId: item.estudiantesId,
              profesoresId: item.profesoresId,
              horas: item.horas,
              precio: item.precio,
              fechaInicio: item.fechaInicio
            }));
          } catch (error) {
            console.error('Error al cargar cursos del cliente:', error);
            alert('Error al cargar la lista de cursos del cliente');
          }
        },
        async loadProfesores() {
          try {
            this.profesores = await getAllProfesores();
          } catch (error) {
            console.error('Error al cargar profesores:', error);
            alert('Error al cargar la lista de profesores');
          }
        },
        async loadEstudiantes() {
          try {
            this.estudiantes = await getAllEstudiantes();
          } catch (error) {
            console.error('Error al cargar estudiantes:', error);
            alert('Error al cargar la lista de estudiantes');
          }
        },
        async saveCursos() {
          try {
            if (this.currentItem.id) {
              await updateCursos(this.currentItem, this.currentItem.id);
            } else {
              await saveCursos(this.currentItem);
            }
            await this.loadCursos();
            this.resetForm();
          } catch (error) {
            console.error('Error al guardar cursos del cliente:', error);
            alert('Error al guardar los cursos del cliente');
          }
        },
        async deleteCursos(id) {
          try {
            await deleteCursos(id);
            await this.loadCursos();
          } catch (error) {
            console.error('Error al eliminar cursos del cliente:', error);
            alert('Error al eliminar los cursos del cliente');
          }
        },
        editCursos(cursos) {
          this.currentItem = { ...cursos};
          this.$refs.crudComponent.openEditModal();
        },
        resetForm() {
          this.currentItem = { id: null, nombre: null, estudiantesId: { id: null }, profesoresIdId: { id: null }, horas: null, precio: null,  fechaInicio: null };
  
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
      --inner-padding-top: 0px;
      --inner-padding-bottom: 0px;
    }
    
    ion-label {
      line-height: 0.2;
    }
    </style>
    
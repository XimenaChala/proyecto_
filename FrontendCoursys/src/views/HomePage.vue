<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>COURSYS</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-grid>
        <ion-row>
          <CardComponent
            title="Estudiantes"
            description="Administrar registro de estudiantes en el sistema."
            buttonText="Gestionar Estudiantes"
            pageLink="/estudiantes"
            imageSrc="/src/imagenes/Estudiantes.png"
          />
          <CardComponent
            title="Profesores"
            description="Administrar registro de profesores en el sistema."
            buttonText="Gestionar Profesores"
            pageLink="/profesores"
            imageSrc="/src/imagenes/Profesores.png"
          />
          <CardComponent
            title="Cursos"
            description="Administrar registro de cursos."
            buttonText="Gestionar Cursos"
            pageLink="/cursos"
            imageSrc="/src/imagenes/Cursos.png"
          />
        </ion-row>
      </ion-grid>
    </ion-content>
  </ion-page>
</template>

<script>
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonGrid, IonRow } from '@ionic/vue';
import CardComponent from '@/components/CardComponent.vue';

export default {
  name: 'HomePage',
  components: {
    IonPage,
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonGrid,
    IonRow,
    CardComponent
  }
};
</script>
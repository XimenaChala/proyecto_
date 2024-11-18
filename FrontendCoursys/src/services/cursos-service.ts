import axios from 'axios';
import { API_BASE_URL } from './api-config';

const CURSOS_API_URL = `${API_BASE_URL}/cursos`;

// Opcional: define una interfaz para clientesData si tienes una estructura conocida
interface CursosData {
  nombre: string;
  estudiantesId: {id:number};
  profesoresId: {id:number};
  horas: Float32Array;
  precio: Float32Array;
  fechaInicio: Date;
  // Añade aquí otras propiedades según la estructura de cursosData
}

export const getAllCursos = async (): Promise<any> => {
  try {
    const { data } = await axios.get(CURSOS_API_URL);
    return data;
  } catch (error) {
    console.error('Error al obtener cursos:', error);
    throw error;
  }
};

export const findCursosById = async (id: number): Promise<any> => {
  try {
    const { data } = await axios.get(`${CURSOS_API_URL}/${id}`);
    return data;
  } catch (error) {
    console.error(`Error al obtener cursos ID ${id}:`, error);
    throw error;
  }
};

export const saveCursos = async (cursosData: CursosData): Promise<any> => {
  try {
    const { data } = await axios.post(CURSOS_API_URL, cursosData);
    return data;
  } catch (error) {
    console.error('Error al guardar cursos:', error);
    throw error;
  }
};

export const updateCursos = async (cursosData: CursosData, id: number): Promise<any> => {
  try {
    const { data } = await axios.put(`${CURSOS_API_URL}/${id}`, cursosData);
    return data;
  } catch (error) {
    console.error(`Error al actualizar cursos ID ${id}:`, error);
    throw error;
  }
};

export const deleteCursos = async (id: number): Promise<any> => {
  try {
    const { data } = await axios.delete(`${CURSOS_API_URL}/${id}`);
    return data;
  } catch (error) {
    console.error(`Error al eliminar cursos ID ${id}:`, error);
    throw error;
  }
};
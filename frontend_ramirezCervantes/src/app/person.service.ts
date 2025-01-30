
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


interface Persona {
  id: number;
  nombre: string;
  apellido: string;
  fechaNacimiento: string | null;
  puesto: string;
  sueldo: number;
}
interface Respuesta {
  status: boolean;
  msg: string;
  data: Persona[];
}

@Injectable({
  providedIn: 'root'
})
export class PersonService {
  private apiUrl = 'personas'; // URL de tu API

  constructor(private http: HttpClient) { }

  // Obtener todas las personas
  getPersonas(): Observable<Respuesta> {
    return this.http.get<Respuesta>(this.apiUrl);
  }

  // Crear una nueva persona
  createPersona(persona: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, persona);
  }

  // Actualizar una persona
  updatePersona(id: number, persona: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${id}`, persona);
  }

  // Eliminar una persona 
  deletePersona(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/${id}`);
  }
}

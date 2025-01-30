
import { Component, OnInit } from '@angular/core';
import { PersonService } from '../../../person.service';


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

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
})
export class PersonComponent  implements OnInit {
  
  personas: any = null; 
  newPersona = { 
    nombre: '',
    apellido: '',
    fechaNacimiento: '',
    puesto: '',
    sueldo: 0.0
  };
  editPersona: any = null;

  constructor(private personService: PersonService) { }

  ngOnInit(): void {
    this.getPersonas();
  }

  // Obtener todas las personas
  getPersonas(): void {
    this.personService.getPersonas().subscribe(resp => {

      this.personas = resp.data;
      console.log("*************: ", this.personas)
    });
  }

  // Crear una nueva persona
  createPersona(): void {
    this.personService.createPersona(this.newPersona).subscribe(() => {
      this.getPersonas();
      this.newPersona = { 
        nombre: '',
        apellido: '',
        fechaNacimiento: '',
        puesto: '',
        sueldo: 0.0
      }; // Limpiar los campos
    });
  }

  // Editar una persona
  startEdit(persona: any): void {
    this.editPersona = { ...persona };  // Crear una copia de la persona para editar
  }

  // Actualizar una persona
  updatePersona(): void {
    if (this.editPersona) {
      this.personService.updatePersona(this.editPersona.id, this.editPersona).subscribe(() => {
        this.getPersonas();
        this.editPersona = null;  // Limpiar el formulario de edición
      });
    }
  }

  // Eliminar una persona
  deletePersona(id: number): void {
    this.personService.deletePersona(id).subscribe(() => {
      this.getPersonas();
    });
  }
}

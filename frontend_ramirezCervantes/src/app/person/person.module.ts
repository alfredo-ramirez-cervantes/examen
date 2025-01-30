import { NgModule } from '@angular/core';
import { PersonComponent } from './components/person/person.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';  


@NgModule({
  declarations: [
    PersonComponent
  ],
  exports: [
    PersonComponent
  ],
  imports: [
    CommonModule,
    FormsModule
  ]
})
export class PersonModule {}

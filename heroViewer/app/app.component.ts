import { Component } from '@angular/core';

@Component({
  selector: 'my-app',
  template: `
  <h1>Hello new learner.</h1>
  <p>Hello, {{name}}</p>
  <input [(ngModel)]="name">
  <br/>
  <input #box (keyup.enter)="keyOn(box.value)" (blur)="keyOn(box.value)">
  <p>{{values}}</p>
  `

})
export class AppComponent{
  values = "";
  name="adu";
  keyOn(value:string){
    this.values += value + ' | ';
  }
}

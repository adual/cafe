import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HeroFormComponent } from './hero-form.component';
import { Logger } from './logger.service';

@NgModule({
  id: module.id,
  imports: [ BrowserModule , FormsModule ],
  providers: [ Logger ],
  declarations: [ AppComponent, HeroFormComponent ],
  bootstrap: [AppComponent ]
})
export class AppModule{

}

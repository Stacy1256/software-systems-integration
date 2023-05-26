import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FacultiesComponent } from './components/faculties/faculties.component';
import {ApolloClientModule} from './apollo/apollo.client.module';
import { FacultyItemComponent } from './components/faculty-item/faculty-item.component';

@NgModule({
  declarations: [
    AppComponent,
    FacultiesComponent,
    FacultyItemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ApolloClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {HttpModule, JsonpModule} from '@angular/http';

import { AppComponent } from './app.component';
//import {AppRoutingModule} from "./app-routing.module";
import {MongoSearchComponent} from "./component/mongosearch.component";
import {ClientService} from "./service/client.service";

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    //AppRoutingModule,
    HttpModule,
    JsonpModule,
  ],
  declarations: [
    AppComponent,
    MongoSearchComponent,
  ],
  providers: [ClientService],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DataTableComponent } from './Components/data-table/data-table.component';
import {HttpClientModule} from "@angular/common/http";
import { VendorPipe } from "./Pipes/vendor-pipe";
import {FormsModule} from "@angular/forms";
import { CarrierPipe } from "./Pipes/carrier-pipe";
import { ClientPipe } from "./Pipes/client-pipe";

@NgModule({
  declarations: [
    AppComponent,
    DataTableComponent,
    VendorPipe,
    CarrierPipe,
    ClientPipe,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent,
    DataTableComponent
  ]
})
export class AppModule { }

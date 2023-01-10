import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FilterTableComponent } from './Components/filter-table/filter-table.component';
import { SortingTableComponent } from './Components/sorting-table/sorting-table.component';
import { DataTableComponent } from './Components/data-table/data-table.component';
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    FilterTableComponent,
    SortingTableComponent,
    DataTableComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent,
    FilterTableComponent,
    SortingTableComponent,
    DataTableComponent
  ]
})
export class AppModule { }

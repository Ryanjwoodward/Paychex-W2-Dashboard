import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DataTableComponent } from './Components/data-table/data-table.component';
import { FilterTableComponent } from './Components/filter-table/filter-table.component';
import { SortingTableComponent } from './Components/sorting-table/sorting-table.component';
import { MapInterfaceComponent } from './Components/map-interface/map-interface.component';

@NgModule({
  declarations: [
    AppComponent,
    DataTableComponent,
    FilterTableComponent,
    SortingTableComponent,
    MapInterfaceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule} from "@angular/router";
import {DashboardComponent} from "../../modules/dashboard/dashboard.component";
import {DefaultComponent} from "./default.component";
import {PostsComponent} from "../../modules/posts/posts.component";
import {SharedModule} from "../../shared/shared.module";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatDividerModule} from "@angular/material/divider";
import {DetailsComponent} from "../../modules/details/details.component";
import {MatTableModule} from "@angular/material/table";
import {MatSortModule} from "@angular/material/sort";
import {MatPaginatorModule} from "@angular/material/paginator";







@NgModule({
  declarations: [
    DefaultComponent,
    DashboardComponent,
    PostsComponent,
    DetailsComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    SharedModule,
    MatSidenavModule,
    MatDividerModule,
    MatTableModule,
    MatSortModule,
    MatPaginatorModule

  ]

})
export class DefaultModule { }

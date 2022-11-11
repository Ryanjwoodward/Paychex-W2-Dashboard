import {Component, OnInit} from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from "@angular/material/sort";
import { MatPaginator } from "@angular/material/paginator";

interface IDetails {
  branch: string;
  client?: string;
  numberOfEmployees?: string;
  numberOfW2?: string;
  clientType?: string;
}
@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.scss']
})
export class DetailsComponent implements OnInit {
  dataSource: MatTableDataSource<IDetails>
  details: IDetails[];
  columns: string[] = ['branch', 'client', 'numberOfEmployees', 'numberOfW2', 'clientType'];

  //adding for sorting the data
  //@ViewChild(MatSort, { static: true }) sort: MatSort;
  //@viewChild(MatPaginator, { static: true}) paginator: MatPaginator;

  constructor() {
    this.details = [{
      branch: '0013',
      client: '00001204',
      numberOfEmployees: '5',
      numberOfW2: '7',
      clientType: 'Core Advanced'
    },
      {
        branch: '0014',
        client: '00001205',
        numberOfEmployees: '6',
        numberOfW2: '8',
        clientType: 'Core Advanced'
      }];
    this.dataSource = new MatTableDataSource(this.details);
  }

  ngOnInit(): void {
    //this.dataSource.sort = this.sort;
    //this.dataSource.paginator = this.paginator;
  }

}

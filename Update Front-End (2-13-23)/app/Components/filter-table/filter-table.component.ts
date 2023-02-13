///<reference path="../../../List.ts" />
import { Component, OnInit } from '@angular/core';


var counter :number = 0;
var clientFilterCriteriaIndexlist :List<number>;
var carrierFilterCriteriaIndexList :List<number>;
var vendorFilterCriteriaIndexList :List<number>;

@Component({
  selector: 'app-filter-table',
  templateUrl: './filter-table.component.html',
  styleUrls: ['./filter-table.component.css']
})
export class FilterTableComponent implements OnInit {


  constructor() {

  }


  selectColumn(id: string){

    if (counter == 1){
      document.getElementById(id).style.color = "#9fa3a7";
      // take id and pass to the array object area
      counter = 0;
    }else{
      document.getElementById(id).style.color = "#0059a2";
      counter = 1;
    }

  }

  ngOnInit(): void {
  }

}

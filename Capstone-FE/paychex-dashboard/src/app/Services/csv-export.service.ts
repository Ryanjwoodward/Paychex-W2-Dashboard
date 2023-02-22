import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CsvExportService {

  private baseURL = "http://localhost:8080/dashboard/csvexport/pcd/csvexport";

  constructor(private httpClient: HttpClient) { }

  callExportCSV(){
    console.log("inside call export");
    window.open(`${this.baseURL}`);
  }

}

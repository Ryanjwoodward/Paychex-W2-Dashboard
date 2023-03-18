import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Vendor} from "../Classes/vendor";

@Injectable({
  providedIn: 'root'
})
export class VendorService {

  private baseURL = "http://localhost:8080/dashboard/vendor/vendors/";

  private stateSortURL = "http://localhost:8080/dashboard/vendor/lookuptable/NY"
  private pageURL = "http://localhost:8080/dashboard/vendor/pagevendors"
  constructor(private httpClient: HttpClient) { }

  getAllVendors(sel: string): Observable<Vendor[]>{

    return this.httpClient.get<Vendor[]>(`${this.baseURL+sel}`);
  }




  //***************************************************88
// NEED TO ADD PAGE VENDOR TABLE HERE
  //***************************************************88

  getVendorsByState(): Observable<Vendor[]>{
    return this.httpClient.get<Vendor[]>(`${this.stateSortURL}`);
  }

}//VendorService Class

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

  constructor(private httpClient: HttpClient) { }

  getAllVendors(sel: string): Observable<Vendor[]>{
    return this.httpClient.get<Vendor[]>(`${this.baseURL+sel}`);
  }

  getVendorsByState(): Observable<Vendor[]>{
    return this.httpClient.get<Vendor[]>(`${this.stateSortURL}`);
  }

}//VendorService Class

import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Carrier} from "../Classes/carrier";

@Injectable({
  providedIn: 'root'
})
export class CarrierService {

  private baseURL = "http://localhost:8080/dashboard/carrier/carriers/";
  private sortStateURL = "http://localhost:8080/dashboard/carrier/lookuptable/NV";

  constructor(private httpClient: HttpClient) { }

  getAllCarriers(sel: string): Observable<Carrier[]>{
    return this.httpClient.get<Carrier[]>(`${this.baseURL+sel}`);
  }

  getCarriersByState(): Observable<Carrier[]>{
    return this.httpClient.get<Carrier[]>(`${this.sortStateURL}`);
  }
}

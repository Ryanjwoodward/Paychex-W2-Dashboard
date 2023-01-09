import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Carrier} from "../Classes/carrier";

@Injectable({
  providedIn: 'root'
})
export class CarrierService {

  private baseURL = "http://localhost:8080/dashboard/carrier/carriers";

  constructor(private httpClient: HttpClient) { }

  getAllCarriers(): Observable<Carrier[]>{
    return this.httpClient.get<Carrier[]>(`${this.baseURL}`);
  }
}

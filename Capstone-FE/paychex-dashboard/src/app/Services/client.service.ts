import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Client} from "../Classes/client";

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private baseURL = "http://localhost:8080/dashboard/client/clients";

  constructor(private httpClient: HttpClient) { }

  getAllClients(): Observable<Client[]>{
    return this.httpClient.get<Client[]>(`${this.baseURL}`);
  }
}
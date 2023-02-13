import { Injectable } from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Observable} from "rxjs";
import {LookupType} from "../Classes/lookup-type";

@Injectable({
  providedIn: 'root'
})
export class LookupTypeServiceService {

  private baseURL = "http://localhost:8080/dashboard/lookuptype/lookuptypes";
  constructor(private httpClient: HttpClient) { }

  getAllLookupTypes(): Observable<LookupType[]>{
    return this.httpClient.get<LookupType[]>(`${this.baseURL}`);
  }
}

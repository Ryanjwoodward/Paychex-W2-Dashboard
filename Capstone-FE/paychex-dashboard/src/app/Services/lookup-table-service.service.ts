
import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {LookupTable} from "../Classes/lookup-table";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class LookupTableService {

  private baseURL = "http://localhost:8080/dashboard/lookuptable/lookuptables";

  constructor(private httpClient: HttpClient) { }

  getAllLookupTables(): Observable<LookupTable[]>{
    return this.httpClient.get<LookupTable[]>(`${this.baseURL}`);
  }
}

import { Injectable } from '@angular/core';
import {DataService} from "./common/data-service";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {EMPLOYEES} from "./api-endpoint";
import {IApiResponse, IEmployee} from "./employee";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService extends DataService{

  constructor(http:HttpClient) {
    super(http);
  }

  getEmployees(page: number, size: number): Observable<IApiResponse> {
    return this.get<IApiResponse>(`${EMPLOYEES}?page=${page}&size=${size}`);
  }

  saveEmployee(employee: IEmployee): Observable<IEmployee> {
    return this.post<IEmployee>(`${EMPLOYEES}`, employee);
  }
}

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable()
export abstract class DataService {

  constructor(private http: HttpClient) {}

  public get<T>(url: string, params?: any): Observable<T> {
    let headers = new HttpHeaders();
    headers  = headers.append('responseType', 'json');
    return this.http.get<T>(url, {headers: headers, params: params});
  }

  public list<T>(url: string): Observable<T> {
    return this.http.get<T>(url, {'responseType': 'json'});
  }

  public post<T>(url: string, object: any): Observable<T> {
    return this.http.post<T>(url, object, {'responseType': 'json'});
  }

  public put<T>(url: string, object: any): Observable<T> {
    return this.http.put<T>(url, object, {'responseType': 'json'});
  }

  public delete<T>(url: string, id: string): Observable<T> {
    return this.http.delete<T>(url + '/' + id, {'responseType': 'json'});
  }

}

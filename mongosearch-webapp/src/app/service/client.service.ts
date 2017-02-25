/**
 * Created by Herve on 22/02/2017.
 */

import { Injectable } from '@angular/core';
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs";
import {Client} from "../objects/client";

@Injectable()
export class ClientService {

  private itemsUrl = 'http://localhost:8080/searchPartial';  // URL to web api

  constructor(private http: Http) { }

  getClients(name : string): Observable<Client[]> {

    let url : string = this.itemsUrl + '?name=' + name;
    console.log('url='+url);
    return this.http.get(url)
      .map(response => <Client[]>response.json())
      .do((data => console.log('parsed')))
      .catch(this.handleError);
  }

  private handleError (error: Response | any) {

    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);


  }

}

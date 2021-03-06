import { Injectable } from '@angular/core';
import { Headers, RequestOptions, Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { AuthResponse } from './authResponse';
import { AuthStatus } from './authStatus';
import { Credentials } from './credentials';

@Injectable()
export class LoginService {

  private authUrl : string = 'http://10.226.159.191:9090/api/v1/auth';

  constructor(private http: Http) {}

  public authenticate(credentials: Credentials, callbackError: any | Function): Observable<Response> {

    let body = JSON.stringify(credentials)
    let headers = new Headers({ 'content-type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    let authResponse = new AuthResponse();
    console.log(this.authUrl)
    return this.http.post(this.authUrl, body, options)
      .map(response => response)
      .catch(error => {
        callbackError();
        return Observable.throw('an error occured');
      });


  }

  public retrieveAuthStatus(token: string): Observable<Response> {
    let headers = new Headers({ 'content-type': 'application/json' });
    headers.append('Authorization', 'Bearer ' + token);
    let options = new RequestOptions({ headers: headers });
    let authStatus = new AuthStatus();

    return this.http.get(this.authUrl, options)
      .map(response => response)
      .catch(error => Observable.throw("an error occured"));
  }




}

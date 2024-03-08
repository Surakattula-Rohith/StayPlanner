import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  registerUser(registeruser: any): Observable<any> {
    return this.http.post('http://localhost:8081/user/register', registeruser)
  }

  authenicatedUser(loginUser: any): Observable<any> {
    return this.http.post('http://localhost:8081/user/login', loginUser)
  }

  convertJsonToFormData(jsonData: any): FormData {
    const formData = new FormData();

    for (const [key, value] of Object.entries(jsonData)) {
      if (value instanceof Blob) {
        formData.append(key, value);
      } else {
        formData.append(key, String(value));
      }
    }

    return formData;
  }



  setBearerToken(token: string) {
    sessionStorage.setItem('bearerToken', token)
  }
  getBearerToken() {
    sessionStorage.getItem('bearerToken');
  }

  public isAuthenticated(): boolean {
    const token = sessionStorage.getItem('bearerToken');
    return token !== null;
  }




}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { HotelOwner } from 'src/app/model/HotelOwner';
import { Admin } from 'src/app/model/admin';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http : HttpClient) { }

  addAdmin(admin : Admin){
    return this.http.post('http://localhost:8089/Admin/addAdmin', admin);
  }
  updateAdmin(admin : Admin){
    let id = admin.adminId ;
    
    return this.http.put('http://localhost:8089/Admin/update/'+id, admin);
  }

  getHotelOwner():Observable<any> {
    return this.http.get('http://localhost:8089/getHotelOwner');
  }

  updateHotelOwner(hotelOwner : HotelOwner):Observable<any>{
    
    return this.http.put('http://localhost:8089/updateHotelOwner', hotelOwner);
  }
}

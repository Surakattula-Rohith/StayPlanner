import { Room } from "./Room";

export class Hotel {
     hotelId ?: string;
     hotelName ?: string;
     hotelAddress ?: string;
     referalCode ?: string;
     gstNumber ?: string;
     location ?: string ;
     availability ?: string;
     acNonAc ?:boolean;
     NearbyTransportation  ?: string;
     wifi?:boolean;
     maintanance?:boolean;
     restoRent?:boolean;
     price ?: number ;
     roomList ?: Array<Room>;

}
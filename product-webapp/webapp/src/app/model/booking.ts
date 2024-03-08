import { Hotel } from "./Hotel";
import { Room } from "./Room";
import { Customer } from "./customer";

export class Booking {
  customer !: Customer;
  cusId !: number;
  bookingId!: string;
  hotId !: string;
  hotel !: Hotel;
  coupon !: string;
  startDate!: Date;
  endDate!: Date;

}

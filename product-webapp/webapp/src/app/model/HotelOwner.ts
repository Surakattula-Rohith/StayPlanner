import { Hotel } from './Hotel';

export class HotelOwner {
  ownerId?: String;
  email?: String;
  name?: String;
  mobileNo?: String;
  referalCode?: String;
  addr?: String;
  dob?: String;
  hotelList?: Array<Hotel>;
  aprovedbyadmin?: boolean;
  price?: String;
}

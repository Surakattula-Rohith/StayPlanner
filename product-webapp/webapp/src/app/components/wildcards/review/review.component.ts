import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {
  ReviewArray: any[] = [];


  reviewDesc: string = "";




  constructor(private http: HttpClient) {

  }

  register() {
    let bodyData = {

      "reviewDesc": this.reviewDesc,
      "rating": this.ratingcount1,
      "maintenance": this.ratingcount2,
      "affordability": this.ratingcount3,
      "wifi": this.ratingcount4,



    };

    this.http.post("http://localhost:8085/reviews/addreviews", bodyData, { responseType: 'text' }).subscribe(
      (resultData: any) => {
        alert("Review added successfully");


        this.reviewDesc = '';
      });


  }



  ngOnInit(): void {
  }

  ratingcount1 = 0;

  ratingcount2 = 0;

  ratingcount3 = 0;

  ratingcount4 = 0;






  ratingcontrol1 = new FormControl(0);


  ratingcontrol2 = new FormControl(0);

  ratingcontrol3 = new FormControl(0);


  ratingcontrol4 = new FormControl(0);


}






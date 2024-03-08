package com.stackroute.hotelservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Review {
    public String customerId;
    public String hotelId;
    @Id
    public String reviewId;
    public String reviewDesc;

    public int rating;
    public int maintenance;
    public int wifi;
    public int affordability;
}

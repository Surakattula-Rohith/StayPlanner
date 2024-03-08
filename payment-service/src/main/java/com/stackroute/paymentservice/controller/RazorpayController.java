package com.stackroute.paymentservice.controller;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.stackroute.paymentservice.model.OrderRequest;
import com.stackroute.paymentservice.model.OrderResponse;
import com.stackroute.paymentservice.repository.PaymentRepository;
import com.stackroute.paymentservice.service.PaymentServiceImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/ps")
public class RazorpayController {
    @Autowired
    PaymentRepository repo;
    @Autowired
    PaymentServiceImpl service;
    private RazorpayClient client;
    private static final String SECRET_ID1 = "rzp_test_Ukc8XHFetrUFJN";
    private static final String SECRET_KEY1 = "KIc1DbmxH2s3Ejzg6vkRSK8J";
    private static final String SECRET_ID2 = "rzp_test_5zXKQaMGJjqY7B";
    private static final String SECRET_KEY2 = "3ijvuMgBGbeFejcXiYWeH7VZ";

    @RequestMapping(path = "/createOrder", method = RequestMethod.POST)
    public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
        OrderResponse response = new OrderResponse();
        try {

            if (orderRequest.getAmount().intValue() > 1000) {
                client = new RazorpayClient(SECRET_ID1, SECRET_KEY1);
            } else {
                client = new RazorpayClient(SECRET_ID2, SECRET_KEY2);
            }

            Order order = createRazorPayOrder(orderRequest.getAmount());
            System.out.println("---------------------------");
            String orderId = order.get("id");
            System.out.println("Payment Id: " + orderId);
            System.out.println("---------------------------");
            response.setRazorpayOrderId(orderId);
            response.setApplicationFee("" + orderRequest.getAmount());
            if (orderRequest.getAmount().intValue() > 1000) {
                response.setSecretKey(SECRET_KEY1);
                response.setSecretId(SECRET_ID1);
                response.setPsName("razor1");
                response.setEmail(orderRequest.getEmail());
            } else {
                response.setSecretKey(SECRET_KEY2);
                response.setSecretId(SECRET_ID2);
                response.setPsName("razor2");
                response.setEmail(orderRequest.getEmail());
            }

            return repo.save(response);
        } catch (RazorpayException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return repo.save(response);

    }

    private Order createRazorPayOrder(BigInteger amount) throws RazorpayException {

        JSONObject options = new JSONObject();
        options.put("amount", amount.multiply(new BigInteger("100")));
        options.put("currency", "INR");
        options.put("receipt", "txn_123456");
        options.put("payment_capture", 1); // You can enable this if you want to do Auto Capture.
        return client.orders.create(options);
    }

    @GetMapping("viewall")
    public ResponseEntity<?> view(){
        List<OrderResponse> responseList = service.view();
        return  new ResponseEntity<List>(responseList, HttpStatus.OK);
    }
    @GetMapping("/viewbymail/{email}")
    public ResponseEntity<?> viewPaymentIdByEmail(@PathVariable String email){
        return  new ResponseEntity<>(service.getPaymentIdByEmail(email),HttpStatus.OK);
    }



}

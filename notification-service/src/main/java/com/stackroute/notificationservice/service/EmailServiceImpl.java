package com.stackroute.notificationservice.service;

import com.stackroute.notificationservice.model.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements  EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private  String sender;

    @Override
    public String sendSimpleMail(OrderResponse orderResponse) {
        try{
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(orderResponse.getEmail() );
            mailMessage.setText("Order Id:" + orderResponse.getRazorpayOrderId() + " " + "Order Fee:"
                    + orderResponse.getApplicationFee() + " " + "Order Status:"
                    + orderResponse.getMsgBody());
            mailMessage.setSubject(orderResponse.getSubject());

            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully";
        }
        catch (Exception exception){
            return "Error while Sending Mail";
        }
    }

}

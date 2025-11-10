package com.example.order.form.customerInfo;

import com.example.order.annotation.NotNull;
import lombok.Data;

@Data
public class Address {
    private String id;
    private String primaryAddress;
    private String line1;
    private String line2;
    private String line3;
    private String postalCode;
    private String city;
    private String state;

    @NotNull(message = "Address -> country: Please input your country")
    private String country;
}

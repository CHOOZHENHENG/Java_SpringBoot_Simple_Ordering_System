package com.example.order.form.customerInfo;

import com.example.order.annotation.NotBlank;
import com.example.order.annotation.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class Customer {

    @NotNull(message = "Customer -> id: Please input ID Type.")
    @NotBlank(message = "Customer -> id: Please input ID Type!")
    private String id;

    @NotNull(message = "Customer -> identification: Please input identification.")
    @NotBlank(message = "Customer -> identification: Please input identification!")
    private Identification identification;

    @NotNull(message = "Customer -> details: Please input details.")
    @NotBlank(message = "Customer -> details: Please input details!")
    private Details details;

    @NotNull(message = "Customer -> contact: Please input contact.")
    @NotBlank(message = "Customer -> contact: Please input contact!")
    private List<Contact> contact;

    @NotNull(message = "Customer -> roles: Please input roles.")
    @NotBlank(message = "Customer -> roles: Please input roles!")
    private List<Roles> roles;
}

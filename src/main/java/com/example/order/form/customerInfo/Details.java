package com.example.order.form.customerInfo;

import com.example.order.annotation.*;
import com.example.order.enums.Gender;
import lombok.Data;

import java.util.List;

@Data
public class Details {
    @NotNull(message = "Details -> displayName: Please input display name.")
    @NotBlank(message = "Details -> displayName: Please input display name!")
    private String displayName;

    @NotNull(message = "Details -> gender: Please input gender.")
    @NotBlank(message = "Details -> gender: Please input gender!")
    @EnumValid(target = Gender.class, message = "Details -> gender: Either MALE, FEMALE or OTHER only")
    private String gender;

    @NotNull(message = "Details -> dateOfBirth: Please input date of birth.")
    @NotBlank(message = "Details -> dateOfBirth: Please input date of birth!")
    @DateValid(message = "Details -> dateOfBirth: Please input a valid date format")
    private String dateOfBirth;

    @NotNull(message = "Details -> email: Please input email.")
    @NotBlank(message = "Details -> email: Please input email!")
    @EmailValid(message = "Details -> email: Please input a valid email")
    private String email;

    private String nationality;
    private String race;

    @NotNull(message = "Details -> address: Please input address.")
    @NotBlank(message = "Details -> address: Please input address!")
    private List<Address> address;
}

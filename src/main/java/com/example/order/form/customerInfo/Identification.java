package com.example.order.form.customerInfo;

import com.example.order.annotation.*;
import com.example.order.enums.IdType;
import lombok.Data;

@Data
public class Identification {
    @NotNull(message = "Identification -> idType: Please input ID type.")
    @NotBlank(message = "Identification -> idType: Please input ID type!")
    @EnumValid(target = IdType.class, message = "Identification -> idType: Either NEWNRIC or PASSPORT only")
    private String idType;

    @NotNull(message = "Identification -> idNumber: Please input ID number.")
    @NotBlank(message = "Identification -> idNumber: Please input ID number!")
    @IdValid(message = "Identification -> idNumber: Only length of 9 or 12 is allowed")
    @MaskValue
    private String idNumber;
}

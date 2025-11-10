package com.example.order.form.transaction;

import com.example.order.annotation.EnumValid;
import com.example.order.annotation.NotBlank;
import com.example.order.annotation.NotNull;
import com.example.order.enums.OrderCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @NotNull(message = "Order -> code: Please input Order code.")
    @NotBlank(message = "Order -> code: Please input Order code!")
    @EnumValid(target = OrderCode.class, message = "Order -> code: Either A1, A2 or A3 only")
    private String code;

    @NotNull(message = "Order -> code: Please input Order quantity.")
    @NotBlank(message = "Order -> code: Please input Order quantity!")
    private int quantity;
}

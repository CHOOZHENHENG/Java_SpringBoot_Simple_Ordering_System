package com.example.order.form.transaction;

import com.example.order.annotation.EnumValid;
import com.example.order.annotation.NotBlank;
import com.example.order.annotation.NotNull;
import com.example.order.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestStatus {

    @NotNull(message = "RequestStatus -> status: Please input status.")
    @NotBlank(message = "RequestStatus -> status: Please input status!")
    @EnumValid(target = Status.class, message = "Order -> code: Either SUBMITTED, IN_PROGRESS, CANCELLED, EXCEPTION, or COMPLETED only")
    private String status;

    @NotNull(message = "RequestStatus -> statusDesc: Please input status description.")
    @NotBlank(message = "RequestStatus -> statusDesc: Please input status description!")
    private String statusDesc;

    @NotNull(message = "RequestStatus -> code: Please input remarks.")
    @NotBlank(message = "RequestStatus -> code: Please input remarks!")
    private String remarks;
}

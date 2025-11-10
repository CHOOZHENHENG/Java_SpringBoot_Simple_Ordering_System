package com.example.order.form.transaction;

import com.example.order.annotation.EnumValid;
import com.example.order.annotation.NotBlank;
import com.example.order.annotation.NotNull;
import com.example.order.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Transaction {

    @NotNull(message = "Transaction -> trxRefId: Please input transaction id.")
    @NotBlank(message = "Transaction -> trxRefId: Please input transaction id!")
    private String trxRefId;

    @NotNull(message = "Transaction -> status: Please input status.")
    @NotBlank(message = "Transaction -> status: Please input status!")
    @EnumValid(target = Status.class, message = "Transaction -> status: Either SUBMITTED, IN_PROGRESS, CANCELLED, EXCEPTION, or COMPLETED only")
    private String status;

    @NotNull(message = "Transaction -> statusDesc: Please input status description.")
    @NotBlank(message = "Transaction -> statusDesc: Please input status description!")
    private String statusDesc;

    @NotNull(message = "Transaction -> remarks: Please input remarks.")
    @NotBlank(message = "Transaction -> remarks: Please input remarks!")
    private String remarks;
    private String created;
    private String lastUpdated;
    private Order order;

    public Transaction(Order order, String trxRefId, String status, String statusDesc, String remarks, String created, String lastUpdated) {
        this.trxRefId = trxRefId;
        this.status = status;
        this.statusDesc = statusDesc;
        this.remarks = remarks;
        this.created = created;
        this.lastUpdated = lastUpdated;
        this.order = order;
    }
}

package com.example.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Meta {

    private int code;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int recordCount;
}

package com.data.penjualan;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Response implements Serializable {
    private String code;
    private String message;
    private Object data;
}

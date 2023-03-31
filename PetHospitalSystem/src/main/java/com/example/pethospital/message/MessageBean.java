package com.example.pethospital.message;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@SuppressWarnings("unused")
public class MessageBean<T> implements Serializable {
    private static final long serialVersionUID = 7192766535561421181L;
    private String msg;
    private T data;
    private Integer code;

    public MessageBean(MessageCodeEnum errorCode, T data, String errorMsg) {
        this.code = errorCode.getCode();
        this.data = data;
        this.msg = errorMsg;
    }

    public MessageBean(MessageCodeEnum errorCode, T data) {
        this.code = errorCode.getCode();
        this.data = data;
        this.msg = errorCode.getMessage();
    }

    public MessageBean(MessageCodeEnum errorCode, String errorMsg) {
        this.code = errorCode.getCode();
        this.msg = errorMsg;
    }

    public MessageBean(MessageCodeEnum errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMessage();
    }
}

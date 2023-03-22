package com.example.pethospital.message.exception;

import com.example.pethospital.message.MessageCodeEnum;

@SuppressWarnings("unused")
public class ErrorCodeException extends RuntimeException {
    private static final long serialVersionUID = -7638041501183925225L;

    private final Integer code;

    public ErrorCodeException(MessageCodeEnum errorCode, String msg) {
        super(msg);
        this.code = errorCode.getCode();
    }

    public ErrorCodeException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public ErrorCodeException(MessageCodeEnum errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public ErrorCodeException(String msg) {
        super(msg);
        this.code = MessageCodeEnum.NO.getCode();
    }

    public Integer getCode() {
        return code;
    }


}

package com.example.pethospital.message.exception;

import com.example.pethospital.message.MessageBean;
import com.example.pethospital.message.MessageCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局请求异常处理
 */
@SuppressWarnings("Duplicates")
@Slf4j
@ControllerAdvice
public class WebExceptionHandler {

    /**
     * 自定义异常
     */
    @ExceptionHandler(value = ErrorCodeException.class)
    @ResponseBody
    public MessageBean<?> myErrorHandler(HttpServletRequest request, ErrorCodeException e) {
        MessageBean<?> message = new MessageBean<>();
        log.error("[{}]接口异常", request.getRequestURI(), e);
        message.setCode(e.getCode());
        message.setMsg(e.getMessage());
        return message;
    }

    /**
     * 系统异常
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public MessageBean<?> errorHandler(HttpServletRequest request, Exception ex) {
        MessageBean<?> message = new MessageBean<>();
        log.error("[{}]系统异常", request.getRequestURI(), ex);
        message.setCode(MessageCodeEnum.ERROR.getCode());
        message.setMsg(ex.getMessage());
        return message;
    }

}

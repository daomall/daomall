package io.daosoft.daomall.support;

import io.daosoft.daomall.config.ResultEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.validation.BindingResult;

import java.util.Objects;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {

    private String status;

    private T data;

    private Error error;

    private Response(T data) {
        this.status = "success";
        this.data = data;
    }

    private Response(Integer code, String message) {
        this.status = "failed";
        this.error = new Error(code, message);
    }

    public static <T> Response<T> succeed(T data) {
        return new Response<>(data);
    }

    public static <T> Response<T> failed(ResultEnum resultEnum) {
        return new Response<>(resultEnum.getCode(), resultEnum.getMessage());
    }

    public static <T> Response<T> failed(ResultEnum resultEnum, BindingResult bindingResult) {
        return new Response<>(resultEnum.getCode(),
                Objects.requireNonNull(bindingResult.getFieldError()).getField() + " " + bindingResult.getFieldError().getDefaultMessage());
    }

    @Data
    private static class Error {
        private Integer code;

        private String message;

        public Error(Integer code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
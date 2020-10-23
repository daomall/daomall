package io.daosoft.daomall.config;

import lombok.Getter;

/**
 * 请求状态枚举
 * 后续状态若太多，可以考虑使用继承等方式拓展。
 * 10x: message
 * 20x: success
 * 30x: redirect
 * 40x: request error
 * 50x: server error
 * 600: unparseable response headers
 */
@Getter
public enum ResultEnum {

    ERROR(500, "服务端错误"),
    SUCCESS(200, "请求成功"),

    CAPTCHA_ERROR(400001, "图片验证码错误"),
    DUPLICATE_EXCEPTION(400999, "重复异常"),

    ;

    private final Integer code;

    private final String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
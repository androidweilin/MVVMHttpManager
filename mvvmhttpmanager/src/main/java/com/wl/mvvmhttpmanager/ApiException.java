package com.wl.mvvmhttpmanager;

/**
 * 自定义api异常
 * @author wl
 */
public class ApiException extends RuntimeException {
    public ApiException(String detailMessage) {
        super(detailMessage);
    }
}

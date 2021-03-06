package com.wl.mvvmhttpmanager.download;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * 下载拦截器
 *
 * @author wl
 */
public class HttpDownInterceptor implements Interceptor {
    private ProgressListener mProgressListener;

    public HttpDownInterceptor(ProgressListener progressListener) {
        mProgressListener = progressListener;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        return response.newBuilder().body(new HttpDownProgressResponseBody(response.body(), mProgressListener)).build();
    }
}

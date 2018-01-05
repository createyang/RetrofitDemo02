package com.cfuas.retrofitdemo02;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * -----------------------------------------------------------------
 * Copyright (C) by CFUAS, All rights reserved.
 * 2. 创建LoginService服务器接口，作为服务器
 * -----------------------------------------------------------------
 *
 * @author caoyang
 * @date Created on 2018/01/04
 */
public interface LoginService {
    String LOGIN_URL = "index.php?m=user&c=user&a=login";


    /**
     * 1.HTTP请求方法
     * 例：注解 @POST(LOGIN_URL)：请求方法+url请求路径
     * HTTP请求方法 get,post,put,delet,patch,head,options,http
     * 都接收一个字符串表示接口路径 与baseUrl组成完整的url;
     * 也可以不指定参数使用如 @Path("url") String url  占位符。
     */
    @POST(LOGIN_URL)
    /**
     * 2.标记类
     * 例：注解 @FormUrlEncoded 参数为表单时需要指定编码形式
     *     Request：Content-Type：application/x-www-form-urlencoded
     *  FormUrlEncode：标识请求体是一个Form表单，在网站上看到的登录页面就是用的这种请求
     *                 Request：Content-Type：application/x-www-form-urlencoded
     *
     *  Multipart:标识请求体是一个支持文件上传的Form表单，带文件上传的网页就是用的这个请求方式
     *            Request：Content-Type:multipart/form-data
     *
     *  Streaming:表示响应体的数据用流的形式返回，如果没有使用该注解，response
     *             默认会把数据全部载入内存
     *             之后你通过流获取数据也不过是获取内存中的数据，
     *             所以如果你的返回数据比较大，你就需要使用这个注解。
     */
    @FormUrlEncoded
    Call<ResponseBody> getLoginInfo(@FieldMap Map<String, String> params);

    /**
     * 注解  @HTTP(method = "GET", path = LOGIN_URL, hasBody = false)：请求方法+url请求路径+body
     *The following problems have occurred when adding the files:
     fatal: Pathspec 'app/src/main/java/com/cfuas/retrofitdemo01/LoginService.java' is in submodule 'app/src/main/java/com/cfuas/retrofitdemo01'
     during executing git "C:\Program Files\Git\bin\git.exe" -c core.quotepath=false add --ignore-errors -- app/src/main/java/com/cfuas/retrofitdemo01/LoginService.java
     * @param url
     * @param username
     * @param password
     * @return
     */
    @HTTP(method = "GET", path = LOGIN_URL, hasBody = false)
    Call<ResponseBody> getLoginInfo2(@Path("url") String url, @Path("username") String username, @Path("password") String password);
}

package com.cfuas.retrofitdemo02;

/**
 * -----------------------------------------------------------------
 * Copyright (C) by CFUAS, All rights reserved.
 * -----------------------------------------------------------------
 * 注1： Retrofit2 的baseUlr 必须以 /（斜线） 结束，
 *      不然会抛出一个IllegalArgumentException,所以如果你看到别的教程没有以 / 结束，那么多半是直接从Retrofit 1.X 照搬过来的。
 * 注2： 上面的 注1 应该描述为 baseUrl 中的路径(path)必须以 / 结束， 因为有些特殊情况可以不以/结尾，
 *      比如 其实这个 URL https://www.baidu.com?key=value用来作为baseUrl其实是可行的，因为这个URL隐含的路径就是 /（斜线，代表根目录） ，
 *      而后面的?key=value在拼装请求时会被丢掉所以写上也没用。之所以 Retrofit 2 在文档上要求必须以 /（斜线） 结尾的要求想必是要消除歧义以及简化规则。
 *
 * @author caoyang
 * @date Created on 2018/01/04
 */
public interface AppUrl {
    String BASE_URL = "http://www.cfuas.net/cftest/";
}

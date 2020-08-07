package com.twan.kotlinbase.network

import rxhttp.wrapper.annotation.DefaultDomain

object Api {
    @DefaultDomain //设置为默认域名
    const val baseUrl = "https://api.xxx.com/"
}
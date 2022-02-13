package com.example.myusershiltapp.services

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val tokenType: String, private val token: String): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var originalRequest = chain.request()

        var requestBuilder = originalRequest.newBuilder()
            .header("Authorization", "$tokenType $token")
            .build()

        return chain.proceed(requestBuilder)
    }

}
package com.example.example_retrofit.Retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query
import java.lang.reflect.Method

interface ApiService {
    @Headers("Content-Type: application/json")
    @POST("auth")
    fun login(
        @Query("method") method: String = "ClassicSession",
        @Body loginRequest: LoginRequest
    ): Call<LoginResponse>
}
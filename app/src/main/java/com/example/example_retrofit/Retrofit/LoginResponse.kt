package com.example.example_retrofit.Retrofit

data class LoginResponse(
    val msg: String,
    val result: Result,
    val version: String
)

data class Result(
    val authenticator: String,
    val body: Body,
    val code: String,
    val is_auth: Boolean,
    val status_code: Int,
    val success: Boolean
)

data class Body(
    val message: String?,
    val grade: String?,
    val major: String?,
    val name: String?,
    val read_certification: Map<String, String>?,
    val status: String?
)

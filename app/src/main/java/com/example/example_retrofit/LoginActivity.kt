package com.example.example_retrofit

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.example_retrofit.Retrofit.ApiService
import com.example.example_retrofit.Retrofit.LoginRequest
import com.example.example_retrofit.Retrofit.LoginResponse
import com.example.example_retrofit.Retrofit.RetrofitClient
import com.example.example_retrofit.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrofit 인스턴스 생성
        val retrofit = RetrofitClient.getClient()
        apiService = retrofit.create(ApiService::class.java)

        binding.btnLoginLogin.setOnClickListener {
            // 로그인 요청
            val userId = binding.etLoginId.text.toString()
            val userPw = binding.etLoginPassword.text.toString()
            login(userId, userPw)
        }
    }

    private fun login(id: String, pw: String) {
        val loginRequest = LoginRequest(id, pw)
        val call = apiService.login(loginRequest = loginRequest)
        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    if (loginResponse != null) {
                        if (loginResponse.result.is_auth) {
                            Toast.makeText(this@LoginActivity, "로그인 성공", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this@LoginActivity, "로그인 실패: ${loginResponse.result.body.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this@LoginActivity, "응답 실패: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(this@LoginActivity, "요청 실패: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
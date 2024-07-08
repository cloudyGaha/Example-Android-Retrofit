package com.example.example_retrofit

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.example_retrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val grade = intent.getStringExtra("grade")
        val major = intent.getStringExtra("major")
        val status = intent.getStringExtra("status")

        binding.tvMainName.text = "$name"
        binding.tvMainGrade.text = "${grade}학년"
        binding.tvMainMajor.text = "$major"
    }
}
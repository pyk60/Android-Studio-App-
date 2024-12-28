package com.example.medicineinfoapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.medicineinfoapp.databinding.ActivityMapBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MapActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 뷰 바인딩 초기화
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // BottomNavigationView 설정
        val bottomNavigationView: BottomNavigationView = binding.bottomNavigationView
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.fragment_home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.fragment_map -> {
                    // 현재 페이지에서는 아무 작업도 하지 않음
                    true
                }
                R.id.fragment_information -> {
                    val intent = Intent(this, CategoryListActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.fragment_profile -> {
                    val intent = Intent(this, TodoActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}

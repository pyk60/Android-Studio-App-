package com.example.medicineinfoapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medicineinfoapp.TodoActivity
import com.example.medicineinfoapp.databinding.ActivityCategoryListBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class CategoryListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View Binding 초기화
        binding = ActivityCategoryListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // RecyclerView에 표시할 데이터 (약물 카테고리 리스트)
        val categories = listOf(
            "진통/해열제",
            "항생제",
            "소염제",
            "소화제",
            "항바이러스제",
            "위장약",
            "항히스타민제(알레르기)",
            "심혈관 약물",
            "정신과 약물",
            "연고/크림"
        )

        // RecyclerView 어댑터 연결
        val adapter = PopularCategoryAdapter(categories) { category ->
            // 카테고리 클릭 시 MedicineListActivity로 이동
            val intent = Intent(this, MedicineListActivity::class.java)
            intent.putExtra("category", category) // 카테고리 데이터 전달
            startActivity(intent)
        }

        // RecyclerView 설정
        binding.categoryRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@CategoryListActivity)
            this.adapter = adapter
        }
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
                    // 지도 화면 이동 (필요 시 활성화)
                    val intent = Intent(this, MapActivity::class.java)  // 예: 지도 화면 Activity
                    startActivity(intent)
                    true
                }
                R.id.fragment_information -> {
                    true
                }
                R.id.fragment_profile -> {
                    // 프로필 화면 이동 (필요 시 활성화)
                    val intent = Intent(this, TodoActivity::class.java)  // 예: 프로필 화면 Activity
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}

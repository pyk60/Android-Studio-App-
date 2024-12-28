package com.example.medicineinfoapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.medicineinfoapp.TodoActivity
import com.example.medicineinfoapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // BottomNavigationView 설정
        val bottomNavigationView: BottomNavigationView = binding.bottomNavigationView
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.fragment_home -> {
                    // 홈 화면 이동 (현재 액티비티 유지)
                    true
                }
                R.id.fragment_map -> {
                    // 지도 화면 이동
                    val intent = Intent(this, MapActivity::class.java)  // 지도 화면 예시
                    startActivity(intent)
                    true
                }
                R.id.fragment_information -> {
                    // CategoryListActivity로 이동
                    val intent = Intent(this, CategoryListActivity::class.java)
                    startActivity(intent)
                    true
                }

                R.id.fragment_profile -> {
                    // 프로필 화면 이동
                    val intent = Intent(this, TodoActivity::class.java)  // 프로필 화면 예시
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        // 상단 배너 클릭 이벤트
        binding.banner1.setOnClickListener {
            navigateToDetail(
                Medicine(
                    name = "마데카솔",
                    type = "상처 치료제",
                    imageResId = R.drawable.maden, // 약품 이미지 리소스 ID
                    details = """
                        기본정보
                        제품명: 마데카솔
                        성상: 녹색의 연고
                        모양: 튜브형
                        업체명: 동국제약(주)
                        전문/일반: 일반의약품
                        
                        효능 / 효과
                        상처 치료 및 감염 예방
                        화상, 찰과상, 베인 상처, 욕창, 궤양 등 피부 손상 부위에 사용
                        
                        용법용량
                        상처 부위를 깨끗이 세척한 후, 1일 1~2회 얇게 도포
                        필요시 드레싱(거즈로 덮기) 처리 가능
                        
                        주의사항
                        1) 이 약에 과민증 환자
                        2) 눈 또는 점막 부위에 사용 금지
                        3) 장기간 사용 시 전문가와 상의
                    """.trimIndent()
                )
            )
        }
        binding.banner2.setOnClickListener {
            navigateToDetail(
                Medicine(
                    name = "우루사",
                    type = "간 기능 개선제",
                    imageResId = R.drawable.woo,
                    details = """
                        기본정보
                        제품명: 우루사
                        성상: 흰색의 장방형 필름코팅정제
                        모양: 장방형
                        업체명: 대웅제약(주)
                        전문/일반: 일반의약품
                        
                        효능 / 효과
                        간 기능 개선, 피로 회복
                        간질환으로 인한 황달 및 간기능 장애 개선
                        
                        용법용량
                        만 15세 이상: 1일 3회, 식후 복용
                        1회 1정 또는 2정씩, 의사 처방에 따라 조정 가능
                        
                        주의사항
                        1) 담도 폐쇄 환자
                        2) 심한 간 질환 환자
                        3) 이 약에 과민증 환자
                    """.trimIndent()
                )
            )
        }

        // 카테고리 클릭 이벤트
        binding.painReliefCategory.setOnClickListener {
            navigateToCategory("진통/해열제")
        }
        binding.antibioticsCategory.setOnClickListener {
            navigateToCategory("항생제")
        }
        binding.digestiveCategory.setOnClickListener {
            navigateToCategory("소화제")
        }
        binding.ointmentCategory.setOnClickListener {
            navigateToCategory("연고/크림")

        }

        // "모두 보기" 버튼 클릭
        binding.viewAll.setOnClickListener {
            startActivity(Intent(this, CategoryListActivity::class.java))
        }
    }

    // 특정 카테고리로 이동
    private fun navigateToCategory(category: String) {
        startActivity(Intent(this, MedicineListActivity::class.java).apply {
            putExtra("category", category)
        })
    }

    // 약물 상세 정보 화면으로 이동
    private fun navigateToDetail(medicine: Medicine) {
        startActivity(Intent(this, DetailActivity::class.java).apply {
            putExtra("medicine", medicine)
        })
    }
}


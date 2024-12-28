package com.example.medicineinfoapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medicineinfoapp.databinding.ActivityMedicineListBinding

class MedicineListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMedicineListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMedicineListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 전달된 카테고리 데이터 가져오기
        val category = intent.getStringExtra("category") ?: "Unknown"
        binding.medicineCategoryTitle.text = category

        // RecyclerView 데이터 설정 7개씩
        val medicines = when (category) {
            "진통/해열제" -> listOf(
                Medicine("타이레놀", "일반의약품", R.drawable.tyn, """
            기본정보
            제품명: 타이레놀
            성상: 흰색 또는 미색의 정제
            모양: 원형
            업체명: 존슨앤드존슨
            전문/일반: 일반의약품
            
            효능 / 효과
            통증 완화, 해열
            두통, 치통, 생리통, 근육통, 감기 등의 증상에 사용
            
            용법용량
            성인: 1회 1~2정, 1일 3~4회 복용
            필요시 4시간 이상 간격을 두고 복용
            
            주의사항
            1) 간 질환이 있는 환자
            2) 알레르기 반응이 있는 환자
            3) 과다 복용 금지
        """.trimIndent()),
                Medicine("탁센", "일반의약품", R.drawable.takn,"""
            기본정보
            제품명: 탁센
            성상: 흰색 또는 미색의 정제
            모양: 타원형
            업체명: 대웅제약(주)
            전문/일반: 일반의약품
            
            효능 / 효과
            진통, 항염, 해열
            류머티즘, 관절염, 근육통, 생리통, 두통 등 통증 완화
            
            용법용량
            성인: 1일 1~2회, 1회 1정 복용
            필요시 4시간 이상 간격을 두고 복용
            
            주의사항
            1) 위장장애가 있는 환자
            2) 심혈관 질환 환자
            3) 과다 복용 금지
        """.trimIndent()),
                Medicine("부루펜", "일반의약품", R.drawable.boon,"""
            기본정보
            제품명: 부루펜
            성상: 붉은색 또는 갈색의 정제
            모양: 원형
            업체명: 동국제약(주)
            전문/일반: 일반의약품
            
            효능 / 효과
            진통, 해열
            두통, 치통, 근육통, 생리통, 감기 등 통증 완화
            
            용법용량
            성인: 1일 1~3회, 1회 1정 복용
            필요시 4시간 간격으로 복용
            
            주의사항
            1) 위장 질환이 있는 환자
            2) 신장 질환이 있는 환자
            3) 과다 복용 금지
        """.trimIndent()),
                Medicine("이지엔6", "일반의약품", R.drawable.easyn,"""
            기본정보
            제품명: 이지엔6
            성상: 하얀색 정제
            모양: 원형
            업체명: 일동제약(주)
            전문/일반: 일반의약품
            
            효능 / 효과
            진통, 항염, 해열
            근육통, 관절염, 치통, 두통, 생리통 등 통증 완화
            
            용법용량
            성인: 1일 1~2회, 1회 1정 복용
            필요시 4시간 이상 간격을 두고 복용
            
            주의사항
            1) 위장 질환이 있는 환자
            2) 신장 질환이 있는 환자
            3) 과다 복용 금지
        """.trimIndent()),
                Medicine("펜잘 큐", "일반의약품", R.drawable.penn,"""
            기본정보
            제품명: 펜잘 큐
            성상: 흰색 정제
            모양: 원형
            업체명: 한국얀센
            전문/일반: 일반의약품
            
            효능 / 효과
            진통, 해열
            두통, 생리통, 치통, 근육통 등 통증 완화
            
            용법용량
            성인: 1일 1~3회, 1회 1정 복용
            필요시 4시간 간격으로 복용
            
            주의사항
            1) 위장 질환이 있는 환자
            2) 신장 질환이 있는 환자
            3) 과다 복용 금지
        """.trimIndent()),
                Medicine("콜대원", "일반의약품", R.drawable.zhf,"""
                    기본정보
                    제품명: 콜대원
                    성상: 갈색의 원형 정제
                    모양: 원형
                    업체명: 대웅제약
                    전문/일반: 일반의약품
            
                    효능 / 효과
                    기침, 가래, 인후염 완화
                    기침, 가래를 동반한 상기도 감염 완화
            
                    용법용량
                    성인: 1일 2~3회, 1회 1정 복용
                    필요시 4시간 간격으로 복용
            
                    주의사항
                    1) 과민증이 있는 환자
                    2) 임신 중 또는 수유 중인 여성
                    3) 과다 복용 금지
                """.trimIndent()),
                Medicine("그날엔", "일반의약품", R.drawable.rmskf,"""
        기본정보
        제품명: 그날엔
        성상: 분홍색 타원형 필름정
        모양: 타원형
        업체명: LG화학
        전문/일반: 일반의약품

        효능 / 효과
        생리통 완화
        생리 전후의 불쾌감과 통증 완화

        용법용량
        성인: 1일 1회, 1회 1정 복용
        필요시 6시간 간격으로 복용

        주의사항
        1) 위장 질환이 있는 환자
        2) 신장 질환이 있는 환자
        3) 과다 복용 금지
    """.trimIndent())
            )
            "소화제" -> listOf(
                Medicine("베나치오", "일반의약품", R.drawable.qpsk, """
        기본정보
        제품명: 베나치오
        성상: 황색 필름코팅 정제
        모양: 타원형
        업체명: 보령제약
        전문/일반: 일반의약품

        효능 / 효과
        기침, 가래 완화
        상기도 감염으로 인한 기침 및 가래 완화

        용법용량
        성인: 1일 2~3회, 1회 1정 복용
        필요시 6시간 간격으로 복용

        주의사항
        1) 과민증이 있는 환자
        2) 만성질환 환자
        3) 과다 복용 금지
    """.trimIndent()),
                Medicine("훼스탈", "일반의약품", R.drawable.gnptmxkf, """
        기본정보
        제품명: 훼스탈
        성상: 황색의 장방형 정제
        모양: 장방형
        업체명: 한국얀센
        전문/일반: 일반의약품

        효능 / 효과
        소화불량, 위장 기능 개선
        소화불량 및 위장 불쾌감 완화

        용법용량
        성인: 1일 2~3회, 1회 1정 복용
        필요시 6시간 간격으로 복용

        주의사항
        1) 위장 질환이 있는 환자
        2) 알레르기 반응을 보이는 환자
        3) 과다 복용 금지
    """.trimIndent()),
                Medicine("배아제", "일반의약품", R.drawable.qpsk, """
        기본정보
        제품명: 배아제
        성상: 황색의 장방형 정제
        모양: 장방형
        업체명: 동국제약
        전문/일반: 일반의약품

        효능 / 효과
        소화불량, 위장 기능 개선
        위장과 장의 기능 개선

        용법용량
        성인: 1일 2~3회, 1회 1정 복용
        필요시 6시간 간격으로 복용

        주의사항
        1) 위장 질환이 있는 환자
        2) 과민증 환자
        3) 과다 복용 금지
    """.trimIndent()),
                Medicine("까스 활명수", "일반의약품", R.drawable.dig, """
        기본정보
        제품명: 배아제
        성상: 황색의 장방형 정제
        모양: 장방형
        업체명: 동국제약
        전문/일반: 일반의약품

        효능 / 효과
        소화불량, 위장 기능 개선
        위장과 장의 기능 개선

        용법용량
        성인: 1일 2~3회, 1회 1정 복용
        필요시 6시간 간격으로 복용

        주의사항
        1) 위장 질환이 있는 환자
        2) 과민증 환자
        3) 과다 복용 금지
    """.trimIndent()),
                Medicine("위청수", "일반의약품", R.drawable.dnl, "정보 준비중!!"),
                Medicine("위생천", "일반의약품", R.drawable.dnltodcjs, "정보 준비중!!"),
                Medicine("겔포스", "일반의약품", R.drawable.rpfvhtm, "정보 준비중!!")
            )
            "항생제" -> listOf(
                Medicine("아목시실린 (Amoxicillin)", "전문의약품", R.drawable.amox, """
        기본정보
        제품명: 아목시실린
        성상: 캡슐
        모양: 캡슐형
        업체명: 한미약품
        전문/일반: 전문의약품

        효능 / 효과
        감염증 치료
        세균성 감염 치료

        용법용량
        성인: 1일 3회, 1회 1캡슐 복용
        필요시 4시간 간격으로 복용

        주의사항
        1) 알레르기 반응이 있는 환자
        2) 간 기능 장애가 있는 환자
        3) 과다 복용 금지
    """.trimIndent()),
                Medicine("세파클러 (Cefaclor)", "전문의약품", R.drawable.cefa, """
        기본정보
        제품명: 세파클러
        성상: 캡슐
        모양: 캡슐형
        업체명: 대웅제약
        전문/일반: 전문의약품

        효능 / 효과
        세균성 감염 치료
        호흡기, 비뇨기, 피부 등 여러 감염 치료

        용법용량
        성인: 1일 2~3회, 1회 1캡슐 복용
        필요시 6시간 간격으로 복용

        주의사항
        1) 알레르기 반응이 있는 환자
        2) 위장 질환이 있는 환자
        3) 과다 복용 금지
    """.trimIndent()),
                Medicine("독시사이클린 (Doxycycline)", "전문의약품", R.drawable.doxy, """
        기본정보
        제품명: 독시사이클린
        성상: 캡슐
        모양: 캡슐형
        업체명: 한림제약
        전문/일반: 전문의약품

        효능 / 효과
        세균성 감염 치료
        호흡기, 피부, 비뇨기 등 감염 치료

        용법용량
        성인: 1일 1~2회, 1회 1캡슐 복용
        필요시 4~6시간 간격으로 복용

        주의사항
        1) 알레르기 반응이 있는 환자
        2) 간, 신장 기능에 문제가 있는 환자
        3) 과다 복용 금지
    """.trimIndent()),
                Medicine("시프로플록사신 (Ciprofloxacin)", "전문의약품",R.drawable.cipr, "정보 준비중!!"),
                Medicine("반코마이신 (Vancomycin)", "전문의약품", R.drawable.vanco, "정보 준비중!!"),
                Medicine("메트로니다졸 (Metronidazole)", "전문의약품", R.drawable.metron, "정보 준비중!!"),
                Medicine("클린다마이신 (Clindamycin)", "전문의약품", R.drawable.clin, "정보 준비중!!")
            )

            "연고/크림" -> listOf(
                Medicine("마데카솔", "일반의약품", R.drawable.maden,"""
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
    """.trimIndent()),
                Medicine("노스카나", "일반의약품", R.drawable.shtmzksk,"""
        기본정보
        제품명: 노스카나
        성상: 연한 노란색의 연고
        모양: 튜브형
        업체명: 한미약품
        전문/일반: 일반의약품

        효능 / 효과
        상처 치료 및 감염 예방
        화상, 찰과상, 베인 상처, 욕창 등에 사용

        용법용량
        상처 부위에 얇게 도포 후 필요시 드레싱 처리 가능
        1일 1~2회 사용

        주의사항
        1) 과민증이 있는 환자
        2) 눈이나 점막 부위에 사용 금지
        3) 외용 전용 약물로, 내부 복용 금지
    """.trimIndent()),
                Medicine("후시딘", "일반의약품", R.drawable.gntlels,"""
        기본정보
        제품명: 후시딘
        성상: 백색 또는 미황색의 연고
        모양: 튜브형
        업체명: 유한양행
        전문/일반: 전문의약품

        효능 / 효과
        피부 상처 감염 예방 및 치료
        피부 상처, 화상, 찰과상 등

        용법용량
        상처 부위에 1일 2~3회 도포
        필요시 드레싱 가능

        주의사항
        1) 과민증 환자
        2) 눈에 들어가지 않도록 주의
        3) 1주 이상 사용 시 전문가와 상의
    """.trimIndent()),
                Medicine("더마틱스 울트라", "일반의약품",R.drawable.dnfxmfk,"""
        기본정보
        제품명: 더마틱스 울트라
        성상: 투명한 젤
        모양: 튜브형
        업체명: I+Med
        전문/일반: 일반의약품

        효능 / 효과
        상처 후 흉터 예방 및 치료
        화상, 수술 후 흉터, 피부 상처 등

        용법용량
        상처 부위에 얇게 도포하고, 마르면 자연스럽게 흡수되도록 한다
        1일 1~2회 사용

        주의사항
        1) 상처가 완전히 치유되지 않은 부위에 사용 금지
        2) 과민증 환자
        3) 외용 전용 약물, 내부 사용 금지
    """.trimIndent()),
                Medicine("안티푸라민", "일반의약품", R.drawable.dksxl, "정보 준비중!!"),
                Medicine("오라메디", "일반의약품", R.drawable.dhfkapel, "정보 준비중!!"),
                Medicine("에스로반", "일반의약품", R.drawable.dptmfhqks, "정보 준비중!!")
            )


            else -> emptyList()
        }

        val adapter = MedicineAdapter(medicines) { medicine ->
            // 약물 클릭 시 상세 화면으로 이동
            startActivity(Intent(this, DetailActivity::class.java).apply {
                putExtra("medicine", medicine)
            })
        }

        binding.medicineRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.medicineRecyclerView.adapter = adapter
    }
}

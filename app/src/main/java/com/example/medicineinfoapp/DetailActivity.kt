
package com.example.medicineinfoapp

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.medicineinfoapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Intent로 전달된 Medicine 객체 가져오기
        val medicine = intent.getSerializableExtra("medicine") as Medicine

        // UI 업데이트
        binding.medicineImage.setImageResource(medicine.imageResId)
        binding.medicineTitle.text = medicine.name
        binding.medicineType.text = medicine.type
        binding.detailsTextView.text = medicine.details

        // 툴바 설정
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = medicine.name

    }

    // 뒤로 가기 버튼 클릭 시 처리
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()  // 뒤로가기 버튼 클릭시 이전 액티비티로 돌아감.
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
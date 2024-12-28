package com.example.medicineinfoapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medicineinfoapp.databinding.ActivityTodoBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class TodoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTodoBinding
    private val todoList = mutableListOf<String>() // 투두리스트 데이터
    private lateinit var adapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // RecyclerView 설정
        adapter = TodoAdapter(todoList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // Add 버튼 클릭 시 새로운 To-Do 추가
        binding.addButton.setOnClickListener {
            val todo = binding.editText.text.toString()
            if (todo.isNotEmpty()) {
                todoList.add(todo)
                adapter.notifyDataSetChanged()
                binding.editText.text.clear()
            }
        }

        // BottomNavigationView 설정
        val bottomNavigationView: BottomNavigationView = binding.bottomNavigationView
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.fragment_home -> {
                    // 홈 화면 이동 (현재 액티비티 유지)
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
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
                    true
                }

                else -> false
            }
        }
    }
}

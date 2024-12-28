package com.example.medicineinfoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.medicineinfoapp.databinding.ItemTodoBinding

class TodoAdapter(private val todoList: MutableList<String>) :
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(private val binding: ItemTodoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(todo: String) {
            binding.todoText.text = todo
            binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
                binding.todoText.alpha = if (isChecked) 0.5f else 1.0f // 체크 시 흐리게 표시
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todoList[position])
    }

    override fun getItemCount(): Int = todoList.size
}

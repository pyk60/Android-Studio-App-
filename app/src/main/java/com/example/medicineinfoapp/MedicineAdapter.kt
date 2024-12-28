package com.example.medicineinfoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MedicineAdapter(
    private val items: List<Medicine>,
    private val onItemClick: (Medicine) -> Unit
) : RecyclerView.Adapter<MedicineAdapter.MedicineViewHolder>() {

    inner class MedicineViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val medicineImage: ImageView = view.findViewById(R.id.medicineImage)
        val medicineName: TextView = view.findViewById(R.id.medicineName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_medicine, parent, false)
        return MedicineViewHolder(view)
    }

    override fun onBindViewHolder(holder: MedicineViewHolder, position: Int) {
        val medicine = items[position]
        holder.medicineImage.setImageResource(medicine.imageResId)
        holder.medicineName.text = medicine.name
        holder.itemView.setOnClickListener { onItemClick(medicine) }
    }

    override fun getItemCount(): Int = items.size
}

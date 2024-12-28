
package com.example.medicineinfoapp

import java.io.Serializable

data class Medicine(
    val name: String,
    val type: String,
    val imageResId: Int,
    val details: String
) : Serializable

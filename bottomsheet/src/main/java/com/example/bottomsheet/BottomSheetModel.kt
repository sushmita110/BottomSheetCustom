package com.example.bottomsheet

data class BottomSheetModel(
    val label: String? = null, val image: Int? = null, var onItemClick: () -> Unit)
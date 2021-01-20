package com.example.bottomsheet

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomsheet.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

object BottomSheetCustomActivity {

    lateinit var binding: ActivityMainBinding
    lateinit var bottomSheetAdapter: BottomSheetAdapter

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//    }

    open fun s(c: Context, message: String) {
        Toast.makeText(c, message, Toast.LENGTH_SHORT).show()
    }

    fun showEditDialog(context: Context, view: RecyclerView, labels: String, images: IntArray) {
        val dialog = BottomSheetDialog(context)

        bottomSheetAdapter = BottomSheetAdapter()
        view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bottomSheetAdapter
        }

        bottomSheetAdapter.items = labels
        bottomSheetAdapter.images = images
        dialog.show()
    }
}
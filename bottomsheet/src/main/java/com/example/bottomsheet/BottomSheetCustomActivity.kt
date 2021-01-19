package com.example.bottomsheet

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
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

    open fun showEditDialog(context: Context, labels: String, images: IntArray) {
        binding = ActivityMainBinding.inflate(LayoutInflater.from(context))
        binding.root
        val dialog = BottomSheetDialog(context)

        bottomSheetAdapter = BottomSheetAdapter()
        binding.rvProfileData.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bottomSheetAdapter
        }

        bottomSheetAdapter.items = labels
        bottomSheetAdapter.images = images
        dialog.show()
    }
}
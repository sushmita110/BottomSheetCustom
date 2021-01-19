package com.example.bottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottomsheet.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class BottomSheetCustomActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var bottomSheetAdapter: BottomSheetAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun showEditDialog(labels: Array<String>, images: IntArray) {
        val dialog = BottomSheetDialog(this)

        bottomSheetAdapter = BottomSheetAdapter()
        binding.rvProfileData.apply {
            layoutManager = LinearLayoutManager(this@BottomSheetCustomActivity)
            adapter = bottomSheetAdapter
        }

        bottomSheetAdapter.items = labels
        bottomSheetAdapter.images = images
        dialog.show()
    }
}
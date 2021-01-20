package com.example.bottomsheetcustom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottomsheetcustom.databinding.ActivityBottomSheetBinding
import com.example.bottomsheetcustom.databinding.DialogBottonCustomViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class BottomSheetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBottomSheetBinding
    private lateinit var bottomSheetAdapter: BottomSheetAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomSheetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding.btnClick.setOnClickListener {
            showEditDialog()
       // }
    }

    private fun showEditDialog() {
        val dialog = BottomSheetDialog(this)
        val bindingSheet = DialogBottonCustomViewBinding.inflate(layoutInflater)
        dialog.setContentView(bindingSheet.root)
        bottomSheetAdapter = BottomSheetAdapter()
        bindingSheet.rvProfileData.apply {
            layoutManager = LinearLayoutManager(this@BottomSheetActivity)
            adapter = bottomSheetAdapter
        }

        val labels = mutableListOf(BottomSheetModel("Settings",R.drawable.ic_settings),
        BottomSheetModel("Archieve",R.drawable.ic_archieve))

        bottomSheetAdapter.items = labels
        dialog.show()
    }
}
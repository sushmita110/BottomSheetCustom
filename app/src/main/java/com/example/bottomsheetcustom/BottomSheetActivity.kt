package com.example.bottomsheetcustom

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.bottomsheetcustom.databinding.ActivityBottomSheetBinding
import com.example.bottomsheetcustom.databinding.BottomSheetCustomViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class BottomSheetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomSheetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClick.setOnClickListener {
            showEditDialog()
        }
    }

    private fun showEditDialog() {
        val bottomSheetDialog = layoutInflater.inflate(R.layout.dialog_botton_custom_view, null)
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(bottomSheetDialog)
        dialog.show()
    }
}
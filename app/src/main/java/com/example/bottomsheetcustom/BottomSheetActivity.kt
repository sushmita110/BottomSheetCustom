package com.example.bottomsheetcustom

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottomsheetcustom.databinding.ActivityBottomSheetBinding
import com.example.bottomsheetcustom.databinding.DialogBottonCustomViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class BottomSheetActivity : AppCompatActivity(){

    private lateinit var binding: ActivityBottomSheetBinding
    private lateinit var bottomSheetAdapter: BottomSheetAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomSheetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClick.setOnClickListener {
            showEditDialog()
        }
    }

    private fun showEditDialog() {
        val dialog = BottomSheetDialog(this)
        val bindingSheet = DialogBottonCustomViewBinding.inflate(layoutInflater)
        dialog.setContentView(bindingSheet.root)

        bottomSheetAdapter = BottomSheetAdapter(onItemClick = { label ->
          showToast(label)
        })

        bindingSheet.rvProfileData.apply {
            layoutManager = LinearLayoutManager(this@BottomSheetActivity)
            adapter = bottomSheetAdapter
        }

        val labels = mutableListOf(
            BottomSheetModel("Settings", R.drawable.ic_settings),
            BottomSheetModel("Archieve", R.drawable.ic_archieve)
        )

        bottomSheetAdapter.items = labels
        dialog.show()
    }

    fun showToast(label:String){
        object : InterfaceListener {
            override fun onItemClicked() {
                Log.e("Tag", "$label")
                Toast.makeText(applicationContext, "$label",Toast.LENGTH_LONG).show()
            }
        }
    }

    fun InterfaceListener.showToast(label:String) : InterfaceListener =
        object : InterfaceListener {
            override fun onItemClicked() {
                Log.e("Tag", "$label")
                Toast.makeText(applicationContext, "$label",Toast.LENGTH_LONG).show()
            }
        }
}
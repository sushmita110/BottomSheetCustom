package com.example.bottomsheetcustom

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottomsheetcustom.databinding.ActivityBottomSheetBinding
import com.example.bottomsheetcustom.databinding.DialogBottonCustomViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class BottomSheetActivity : AppCompatActivity(), InterfaceListener {

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

        bottomSheetAdapter = BottomSheetAdapter(object : BottomSheetAdapter.OnItemClickListener {
            override fun onProfileData(item: Int) {
                test(item)
            }
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

    fun test(item: Int) {
        Toast.makeText(applicationContext, "$item", Toast.LENGTH_LONG).show()
    }

    fun startActivity(context: Context, clazz: Class<*>) {
        val intent = Intent(context, clazz)
        context.startActivity(intent)
    }


//    fun showToast(label:String){
//        object : InterfaceListener {
//            override fun onItemClicked() {
//                Log.e("Tag", "$label")
//                Toast.makeText(applicationContext, "$label",Toast.LENGTH_LONG).show()
//            }
//        }
//    }

//    fun InterfaceListener.showToast(label:String) : InterfaceListener =
//        object : InterfaceListener {
//            override fun onItemClicked() {
//                Log.e("Tag", "$label")
//                Toast.makeText(applicationContext, "$label",Toast.LENGTH_LONG).show()
//            }
//        }

    override fun onItemClicked(context: Context, clazz: Class<*>) {
        startActivity(Intent(context, BottomSheetActivity::class.java))
    }
}
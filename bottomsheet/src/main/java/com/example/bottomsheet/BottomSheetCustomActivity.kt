package com.example.bottomsheet

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottomsheet.databinding.ActivityMainBinding
import com.example.bottomsheet.databinding.DialogBottomCustomViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class BottomSheetCustomActivity(
    private val listener: OnItemClickListener
) : AppCompatActivity(), InterfaceListener.ProfileData, InterfaceListener.Presenter {

    lateinit var binding: ActivityMainBinding
    lateinit var bottomSheetAdapter: BottomSheetAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun showEditDialog(
        context: Context, profileData: MutableList<BottomSheetModel>
    ) {
        val dialog = BottomSheetDialog(context)
        val bindingSheet =
            DialogBottomCustomViewBinding.inflate(LayoutInflater.from(context), null, false)
        dialog.setContentView(bindingSheet.root)

        bottomSheetAdapter = BottomSheetAdapter(this)
        bindingSheet.rvProfile.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bottomSheetAdapter
        }

        bottomSheetAdapter.items = profileData
    }

    override fun onProfileData(label: String) {
        listener.onProfileData(label)
    }

    interface OnItemClickListener {
        fun onProfileData(label: String)
    }
}

package com.example.bottomsheet

import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.withStyledAttributes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomsheet.databinding.ActivityMainBinding
import com.example.bottomsheet.databinding.BottomSheetCustomViewBinding
import com.example.bottomsheet.databinding.DialogBottonCustomViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialog


class BottomSheetCustomActivity @JvmOverloads constructor(
    context: Context,
    listener: InterfaceListener = InterfaceListener.DEFAULT,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr), InterfaceListener {
    var binding: ActivityMainBinding
    lateinit var bottomSheetAdapter: BottomSheetAdapter

    init {
        binding =
            ActivityMainBinding.inflate(LayoutInflater.from(context), null, false)
    }


    fun showEditDialog(
        context: Context, profileData: MutableList<BottomSheetModel>
    ) {
        val dialog = BottomSheetDialog(context)
        val bindingSheet = DialogBottonCustomViewBinding.inflate(LayoutInflater.from(context),null,false)
        dialog.setContentView(bindingSheet.root)

        bottomSheetAdapter = BottomSheetAdapter(this)
        bindingSheet.rvProfileData.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bottomSheetAdapter
        }

        bottomSheetAdapter.items = profileData
    }

    override fun onProfileData(context: Context, label: String) {
        Log.e("TAG", "$label")
        Test.startAction(context, this::class.java)
    }
}

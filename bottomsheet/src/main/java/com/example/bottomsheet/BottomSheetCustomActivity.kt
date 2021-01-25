package com.example.bottomsheet

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottomsheet.databinding.ActivityMainBinding
import com.example.bottomsheet.databinding.DialogBottomCustomViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class BottomSheetCustomActivity(
    private val onClickListener: OnItemClickListener
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
        context: Context, actionData: MutableList<BottomSheetModel>
    ) {
        val dialog = BottomSheetDialog(context)
        val bindingSheet =
            DialogBottomCustomViewBinding.inflate(LayoutInflater.from(context), null, false)
        dialog.setContentView(bindingSheet.root)

        bottomSheetAdapter = BottomSheetAdapter(this)
        bindingSheet.rvActionData.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bottomSheetAdapter
        }

        bottomSheetAdapter.items = actionData
        dialog.show()
    }

    override fun onProfileData(item: BottomSheetModel) {
        onClickListener.onActionData(item)
    }

    interface OnItemClickListener {
        fun onActionData(item: BottomSheetModel)
    }
}

package com.example.bottomsheet

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottomsheet.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog


class BottomSheetCustomActivity @JvmOverloads constructor(
    context: Context,
    listener: InterfaceListener = InterfaceListener.DEFAULT
) : InterfaceListener {
    lateinit var binding: ActivityMainBinding
    lateinit var context: Context

    lateinit var bottomSheetAdapter: BottomSheetAdapter

    private fun showEditDialog(profileData: MutableList<BottomSheetModel>) {
        val dialog = BottomSheetDialog(context)

        bottomSheetAdapter = BottomSheetAdapter(this)
        binding.rvProfileData.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bottomSheetAdapter
        }
        bottomSheetAdapter.items = profileData
        dialog.show()
    }

    override fun onProfileData(label: String) {
        Log.e("TAG", "$label")
    }
}

package com.example.bottomsheet

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog

object BottomSheetCustomActivity {
    lateinit var bottomSheetAdapter: BottomSheetAdapter

    fun showEditDialog(
        context: Context,
        view: RecyclerView,
        profileData: MutableList<BottomSheetModel>
    ) {
        bottomSheetAdapter = BottomSheetAdapter(onItemClick = { label ->
            showToast(label)
        })
        view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bottomSheetAdapter
        }

        bottomSheetAdapter.items = profileData
    }

    fun showToast(label:String){
        Log.e("Tag", "$label")
    }
}
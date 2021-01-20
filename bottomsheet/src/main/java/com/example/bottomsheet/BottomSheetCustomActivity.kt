package com.example.bottomsheet

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog

object BottomSheetCustomActivity {
    lateinit var bottomSheetAdapter: BottomSheetAdapter
    lateinit var context: Context
    lateinit var clazz: Class<*>

    fun showEditDialog(
        context: Context,
        view: RecyclerView,
        profileData: MutableList<BottomSheetModel>
    ) {
        bottomSheetAdapter = BottomSheetAdapter(onItemClick = { context, label, clazz ->
            onProfileData(context, label, clazz)
        })
        view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bottomSheetAdapter
        }

        bottomSheetAdapter.items = profileData
    }

    fun onProfileData(context: Context, label: String, clazz: Class<*>) {
        Log.e("Tag", "$label")
        context.startActivity(Intent(context, clazz))
    }
}
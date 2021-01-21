package com.example.bottomsheet

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

object BottomSheetCustomActivity {
    lateinit var bottomSheetAdapter: BottomSheetAdapter

    fun showEditDialog(
        context: Context,
        view: RecyclerView,
        profileData: MutableList<BottomSheetModel>
    ) {
        bottomSheetAdapter = BottomSheetAdapter(onItemClick = { label ->
            object : InterfaceListener {
                override fun onItemClicked() {
                    Log.e("Tag", "$label")
                }
            }
        })
        view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bottomSheetAdapter
        }

        bottomSheetAdapter.items = profileData
    }

    fun onProfileData(context: Context, label: String, clazz: Class<*>) {
        Log.e("Tag", "$label")

    }
}
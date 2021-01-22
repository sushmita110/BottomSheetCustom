package com.example.bottomsheet

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomsheet.databinding.ActivityMainBinding


class BottomSheetCustomActivity @JvmOverloads constructor(
    context: Context,
    listener: InterfaceListener = InterfaceListener.DEFAULT
) : InterfaceListener {
    lateinit var binding: ActivityMainBinding

    lateinit var bottomSheetAdapter: BottomSheetAdapter

    fun showEditDialog(
        context: Context,
        view: RecyclerView, profileData: MutableList<BottomSheetModel>
    ) {
        bottomSheetAdapter = BottomSheetAdapter(this)
        view.apply {
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

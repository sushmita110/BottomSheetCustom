package com.example.bottomsheetcustom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottomsheetcustom.databinding.ActivityBottomSheetBinding
import com.example.bottomsheetcustom.databinding.DialogBottonCustomViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class BottomSheetActivity : AppCompatActivity() {

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
        val labels = arrayOf(
            "Settings",
            "Archive",
            "Insights",
            "Your Activity",
            "QR Code",
            "Saved",
            "Close Friends",
            "Discover People"
        )
        val images = intArrayOf(
            R.drawable.ic_settings,
            R.drawable.ic_archieve,
            R.drawable.ic_insights,
            R.drawable.ic_activity,
            R.drawable.ic_scanner,
            R.drawable.ic_saved,
            R.drawable.ic_close_friends,
            R.drawable.ic_discover_people
        )

        bottomSheetAdapter = BottomSheetAdapter()
        bindingSheet.rvProfileData.apply {
            layoutManager = LinearLayoutManager(this@BottomSheetActivity)
            adapter = bottomSheetAdapter
        }

        bottomSheetAdapter.items = labels
        bottomSheetAdapter.images = images
        dialog.show()
    }
}
package com.example.app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bottomsheet.BottomSheetCustomActivity
import com.example.bottomsheet.BottomSheetModel
import com.example.bottomsheetcustom.R
import com.example.bottomsheetcustom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var bottomSheetCustomActivity: BottomSheetCustomActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomSheetCustomActivity = BottomSheetCustomActivity(
            onBottomSheetItemClick = {
                Log.e("MainActivity", "postion:$it")
            }
        )
        binding.btnClick.setOnClickListener {
            val actionData = mutableListOf<BottomSheetModel>()
            val settings = BottomSheetModel(
                label = "Settings",
                image = R.drawable.ic_settings,
                onItemClick = {
                    startActivity(Intent(this, MainActivity::class.java))
                })
            val archieve = BottomSheetModel(
                label = "Archieve",
                image = R.drawable.ic_archieve,
                onItemClick = {
                    startActivity(Intent(this, MainActivity::class.java))
                })
            val insights = BottomSheetModel(
                label = "Insights",
                image = R.drawable.ic_insights,
                onItemClick = {
                    startActivity(Intent(this, MainActivity::class.java))
                })

            actionData.add(settings)
            actionData.add(archieve)
            actionData.add(insights)

            bottomSheetCustomActivity.showEditDialog(this, actionData)
        }
    }


}
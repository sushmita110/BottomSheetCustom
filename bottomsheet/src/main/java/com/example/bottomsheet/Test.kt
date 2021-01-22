package com.example.bottomsheet

import android.content.Context
import android.content.Intent

object Test {
    fun startAction(context: Context,clazz: Class<*>){
        val start = Intent(context,clazz)
        context.startActivity(start)
    }
}
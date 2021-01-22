package com.example.bottomsheet

interface InterfaceListener {
    object DEFAULT : InterfaceListener {
        override fun onProfileData(label: String) {}
    }

    fun onProfileData(label: String)
}
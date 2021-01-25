package com.example.bottomsheet

interface InterfaceListener {
   interface ProfileData{
       fun onProfileData(item: BottomSheetModel)
   }
    interface Presenter : BottomSheetAdapter.OnItemClickListener
}

package com.example.bottomsheet

import android.content.Context

interface InterfaceListener {
   interface ProfileData{
       fun onProfileData(label: String)
   }
    interface Presenter : BottomSheetAdapter.OnItemClickListener
}

//interface SearchViewContract {
//    interface View : BaseView<Presenter> {
//        fun onSearchItemClick(value: BaseSearch, position: Int)
//    }
//
//    interface Presenter : BasePresenter, SearchRecyclerAdapter.SearchItemClickListener
//}

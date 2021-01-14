package com.example.bottomsheetcustom

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.withStyledAttributes
import androidx.core.view.isGone
import com.example.bottomsheetcustom.databinding.BottomSheetCustomViewBinding
import kotlinx.android.synthetic.main.bottom_sheet_custom_view.view.*

class BottomSheetCustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    var binding: BottomSheetCustomViewBinding? = null

    init {
        binding = BottomSheetCustomViewBinding.inflate(LayoutInflater.from(context), this, true)
        context.withStyledAttributes(attrs, R.styleable.BottomSheet) {
            label = getString(R.styleable.BottomSheet_bsc_label) ?: ""
            setNavImage = getDrawable(R.styleable.BottomSheet_bsc_image)
        }
    }

    var label: String
        get() = tv_label.text.toString()
        set(value) {
            tv_label.isGone
            tv_label.text = value
        }

    var setNavImage: Drawable?
        get() = iv_icon.drawable
        set(value) {
            iv_icon.setImageDrawable(value)
        }
}
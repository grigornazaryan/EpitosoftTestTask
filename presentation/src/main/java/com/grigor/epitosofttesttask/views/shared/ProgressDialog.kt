package com.grigor.epitosofttesttask.views.shared

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import com.grigor.epitosofttesttask.baseFeatures.BaseDialog
import com.grigor.epitosofttesttask.databinding.DialogProgressBinding

class ProgressDialog : BaseDialog<DialogProgressBinding>() {

    override val inflater: (LayoutInflater) -> DialogProgressBinding
        get() = DialogProgressBinding::inflate

    override fun initViews() {
        dialog?.window?.apply { setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setDimAmount(0f)}
        isCancelable = false
    }
}
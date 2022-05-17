package com.grigor.epitosofttesttask.baseFeatures

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.grigor.epitosofttesttask.R
import com.grigor.epitosofttesttask.views.shared.ProgressDialog

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    protected abstract val inflater: (LayoutInflater) -> VB

    private lateinit var _mBinding: VB
    val mBinding get() = _mBinding
    private val progressDialog by lazy { ProgressDialog() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBinding()
        initViews()
        initViewModel()

    }

    private fun initDataBinding() {
        _mBinding = inflater.invoke(layoutInflater).also {
            setContentView(it.root)
        }
    }

    protected abstract fun initViews()
    protected open fun initViewModel() {}
    protected open fun <T> chooseState(state: T) {
        dismissProgress()
    }


    protected open fun onError(message: String?, retry: () -> Unit) {
        dismissProgress()
        Snackbar.make(mBinding.root, message ?: "", Snackbar.LENGTH_INDEFINITE).apply {
            setActionTextColor(Color.WHITE)
            setAction(R.string.retry) { retry.invoke() }
            dismiss()
            show()

        }
    }

    protected open fun onLoading() {
        if (!progressDialog.isVisible) {
            progressDialog.show(supportFragmentManager, null)
        }
    }

    private fun dismissProgress() {
        if (progressDialog.isVisible) {
            progressDialog.dismissAllowingStateLoss()
        }
    }
}
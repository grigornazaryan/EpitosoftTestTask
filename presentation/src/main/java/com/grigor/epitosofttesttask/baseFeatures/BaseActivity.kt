package com.grigor.epitosofttesttask.baseFeatures

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.grigor.domain.entities.constants.Tags
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
        mGetArguments(intent)
        initViews()
        initViewModel()

    }

    private fun initDataBinding() {
        _mBinding = inflater.invoke(layoutInflater).also {
            setContentView(it.root)
        }
    }

    protected open fun mGetArguments(intent: Intent) {}
    protected abstract fun initViews()
    protected open fun initViewModel() {}
    protected open fun <T> chooseState(state: T) {
        dismissProgress()
    }


    protected open fun onError(message: String?, retry: () -> Unit) {
        dismissProgress()
        Snackbar.make(mBinding.root, message ?: "", Snackbar.LENGTH_INDEFINITE).apply {
            setActionTextColor(Color.WHITE)
            setAction(R.string.retry) {
                dismiss()
                retry.invoke()
            }
            show()

        }
    }

    protected open fun onLoading() {
        if (!progressDialog.isVisible && !supportFragmentManager.isDestroyed) {
            progressDialog.show(supportFragmentManager, Tags.PROGRESS_TAG)
        }
    }

    private fun dismissProgress() {
        (supportFragmentManager.findFragmentByTag(Tags.PROGRESS_TAG) as? DialogFragment)?.dismissAllowingStateLoss()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.hold_anim, R.anim.slide_out_right)
    }
}
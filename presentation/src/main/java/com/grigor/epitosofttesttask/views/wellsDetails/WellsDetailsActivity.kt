package com.grigor.epitosofttesttask.views.wellsDetails

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import com.grigor.domain.entities.constants.BundleConstants
import com.grigor.domain.entities.models.dataModels.WellSitesDataModel
import com.grigor.epitosofttesttask.baseFeatures.BaseActivity
import com.grigor.epitosofttesttask.databinding.ActivityWellsDetailsBinding
import com.grigor.epitosofttesttask.extencions.convertGeoHash

class WellsDetailsActivity : BaseActivity<ActivityWellsDetailsBinding>() {

    override val inflater: (LayoutInflater) -> ActivityWellsDetailsBinding
        get() = ActivityWellsDetailsBinding::inflate

    private var model: WellSitesDataModel? = null

    override fun mGetArguments(intent: Intent) {
        super.mGetArguments(intent)
        model = intent.getParcelableExtra(BundleConstants.MODEL_TO_DETAILS_ACTIVITY)
    }

    @SuppressLint("SetTextI18n")
    override fun initViews() {
        mBinding.includedCard.apply {
            name.text=model?.name
            apiName.text=model?.api
            convertGeoHash(model?.location)?.let {
            location.text="lat ${it.latitude} lon ${it.longitude}"
            }
        }
    }
}
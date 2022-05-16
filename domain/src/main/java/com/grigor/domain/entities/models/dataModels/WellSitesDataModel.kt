package com.grigor.domain.entities.models.dataModels

import com.google.gson.annotations.SerializedName

data class WellSitesDataModel(
    @SerializedName("api")
    var api: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("location")
    var location: String? = null

)
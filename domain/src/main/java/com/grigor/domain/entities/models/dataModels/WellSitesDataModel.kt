package com.grigor.domain.entities.models.dataModels

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class WellSitesDataModel(
    @SerializedName("api")
    var api: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("location")
    var location: String? = null
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(api)
        parcel.writeString(name)
        parcel.writeString(location)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WellSitesDataModel> {
        override fun createFromParcel(parcel: Parcel): WellSitesDataModel {
            return WellSitesDataModel(parcel)
        }

        override fun newArray(size: Int): Array<WellSitesDataModel?> {
            return arrayOfNulls(size)
        }
    }
}
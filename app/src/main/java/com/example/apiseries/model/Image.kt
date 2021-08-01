package com.example.apiseries.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(
    @Expose @SerializedName("medium") val medium: String,
    @Expose @SerializedName("original") val original: String
):Parcelable

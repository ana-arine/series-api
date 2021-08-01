package com.example.apiseries.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Schedule(
    @Expose @SerializedName("time") val time: String,
    @Expose @SerializedName("days") val days: List<String>
):Parcelable
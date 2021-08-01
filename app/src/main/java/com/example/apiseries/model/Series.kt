package com.example.apiseries.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class Series(
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("name") val name : String,
    @Expose @SerializedName("image") val image: Image,
    @Expose @SerializedName("language") val language: String,
    @Expose @SerializedName("genres") val genres: List<String>,
    @Expose @SerializedName("runtime") val runtime: Int,
    @Expose @SerializedName("officialSite") val officialSite: String,
    @Expose @SerializedName("schedule") val schedule: Schedule
)

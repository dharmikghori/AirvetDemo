package com.airvet.demo.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserData(
    val results: ArrayList<UserDetailsData>
) : Parcelable

@Parcelize
class UserDetailsData(
    val gender: String = "",
    val name: UserNameData,
    val picture: UserPicture,
    val cell: String,
    val email: String
) : Parcelable

@Parcelize
class UserNameData(
    val first: String,
    val last: String
) : Parcelable

@Parcelize
class UserPicture(
    val medium: String
) : Parcelable
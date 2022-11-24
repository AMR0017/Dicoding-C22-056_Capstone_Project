package com.example.dicoding_c22_056_capstone_project.Homepage.HomepageModel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomepagesModel(
    var homepageName: String,
    var homepagesImage: Int
) : Parcelable

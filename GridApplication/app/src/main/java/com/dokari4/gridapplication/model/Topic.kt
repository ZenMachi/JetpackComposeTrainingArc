package com.dokari4.gridapplication.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val name: Int,
    val avalaibleCourses: Int,
    @DrawableRes val imageRes: Int
)

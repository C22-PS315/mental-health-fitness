package org.eu.temandengar.menfit

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Question(
    var questions: String,
//    var answer: Int
) : Parcelable

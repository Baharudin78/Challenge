package com.baharudin.common_utils

import android.app.Activity

interface Navigator {
    fun navigate(activity : Activity)

    interface NavigatorProvider {
        fun getActivity (activity: Activities) : Navigator
    }
}
package com.baharudin.challange.navigator

import com.baharudin.common_utils.Activities
import com.baharudin.common_utils.Navigator
import com.baharudin.news_presentation.GoToNewsActivity
import com.baharudin.search_presentation.GoToSearchActivity

class DefaultNavigator : Navigator.NavigatorProvider {

    override fun getActivity(activity: Activities): Navigator {
        return when (activity) {
            Activities.NewsActivity -> {
                GoToNewsActivity
            }
            Activities.SearchNewsActivity -> {
                GoToSearchActivity
            }
        }
    }
}
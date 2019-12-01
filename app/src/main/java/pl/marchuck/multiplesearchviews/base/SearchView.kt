package pl.marchuck.multiplesearchviews.base

import android.annotation.SuppressLint
import android.app.Activity
import android.app.SearchManager
import android.content.Context
import androidx.appcompat.widget.SearchView
import androidx.core.os.bundleOf
import pl.marchuck.multiplesearchviews.SearchDestination

const val SEARCHABLE_DESTINATION = "AppSearchData"
@SuppressLint("RestrictedApi")
fun SearchView.configureSearchableInfo(destination: SearchDestination) {
    val activity = context as Activity
    val appContext = activity.applicationContext
    val searchManager = appContext.getSystemService(Context.SEARCH_SERVICE) as SearchManager
    this.setSearchableInfo(searchManager.getSearchableInfo(activity.componentName))
    this.setAppSearchData(bundleOf(SEARCHABLE_DESTINATION to destination))
}
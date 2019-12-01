package pl.marchuck.multiplesearchviews

import androidx.lifecycle.ViewModel
import pl.marchuck.multiplesearchviews.base.LiveEvent
import java.io.Serializable

enum class SearchDestination : Serializable {
    ELVES, HOBBITS
}

data class SearchableResult(val query: String, val destination: SearchDestination)

class MainViewModel : ViewModel() {

    val searchableLiveData = LiveEvent<SearchableResult>()

    fun onNewSearchResultReceived(query: String, destination: SearchDestination) {
        searchableLiveData.value = SearchableResult(query, destination)
    }

}
package pl.marchuck.multiplesearchviews

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pl.marchuck.multiplesearchviews.base.SEARCHABLE_DESTINATION

class MainActivity : AppCompatActivity(), MainViewModelOwner {

    override lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = MainViewModel()
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        handleNewIntent(intent)
    }

    private fun handleNewIntent(intent: Intent) {
        if (Intent.ACTION_SEARCH == intent.action) {
            val appSearchData = intent.getBundleExtra(SearchManager.APP_DATA) ?: return
            val destination =
                (appSearchData.getSerializable(SEARCHABLE_DESTINATION) as? SearchDestination)
                    ?: return
            val query = intent.getStringExtra(SearchManager.QUERY) ?: return
            mainViewModel.onNewSearchResultReceived(query, destination)
        }
    }
}

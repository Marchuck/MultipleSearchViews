package pl.marchuck.multiplesearchviews.elves

import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.elves_fragment.*
import pl.marchuck.multiplesearchviews.CharactersAdapter
import pl.marchuck.multiplesearchviews.R
import pl.marchuck.multiplesearchviews.SearchDestination
import pl.marchuck.multiplesearchviews.base.BaseFragment
import pl.marchuck.multiplesearchviews.base.configureSearchableInfo

class ElvesFragment : BaseFragment(R.layout.elves_fragment) {

    private lateinit var viewModel: ElvesViewModel

    val elvesAdapter = CharactersAdapter()

    val listener: SearchView.OnQueryTextListener = object : SearchView.OnQueryTextListener {

        override fun onQueryTextSubmit(query: String?): Boolean {
            return false
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            if (newText != null) {
                viewModel.queryDataSet(newText)
            }
            return false
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ElvesViewModel(provideApp().dataSource)

        viewModel.results.observe(viewLifecycleOwner, Observer {
            elvesAdapter.submitList(it)
        })

        provideMainViewModel().searchableLiveData
            .observe(viewLifecycleOwner, Observer {
                if (it.destination == SearchDestination.ELVES) {
                    elves_search.setQuery(it.query, false)
                }
            })
        elves_recyclerview.adapter = elvesAdapter
        with(elves_search) {
            configureSearchableInfo(SearchDestination.ELVES)
            setOnQueryTextListener(listener)
        }
    }
}

package pl.marchuck.multiplesearchviews.hobbits

import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.hobbits_fragment.*
import pl.marchuck.multiplesearchviews.CharactersAdapter
import pl.marchuck.multiplesearchviews.R
import pl.marchuck.multiplesearchviews.SearchDestination
import pl.marchuck.multiplesearchviews.base.BaseFragment
import pl.marchuck.multiplesearchviews.base.configureSearchableInfo

class HobbitsFragment : BaseFragment(R.layout.hobbits_fragment) {

    private lateinit var viewModel: HobbitsViewModel

    val args: HobbitsFragmentArgs by navArgs()

    val adapter = CharactersAdapter()

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

        viewModel = HobbitsViewModel(
            provideApp().dataSource
        )

        viewModel.results.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        provideMainViewModel().searchableLiveData
            .observe(viewLifecycleOwner, Observer {
                if (it.destination == SearchDestination.HOBBITS) {
                    hobbits_search.setQuery(it.query, false)
                }
            })

        hobbits_recyclerview.adapter = adapter
        with(hobbits_search) {
            configureSearchableInfo(SearchDestination.HOBBITS)
            setOnQueryTextListener(listener)
            if (args.searchQuery.isNotEmpty()) {
                setQuery(args.searchQuery, false)
                requestFocus()
            }
        }
    }
}

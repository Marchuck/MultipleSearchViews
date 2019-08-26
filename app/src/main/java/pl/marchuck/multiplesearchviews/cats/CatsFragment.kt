package pl.marchuck.multiplesearchviews.cats

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import pl.marchuck.multiplesearchviews.R

class CatsFragment : Fragment() {

    companion object {
        fun newInstance() = CatsFragment()
    }

    private lateinit var viewModel: CatsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cats_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CatsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}

package pl.marchuck.multiplesearchviews.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.intro_fragment.*
import pl.marchuck.multiplesearchviews.IntroFragmentDirections
import pl.marchuck.multiplesearchviews.R

class IntroFragment : Fragment() {

    companion object {
        fun newInstance() = IntroFragment()
    }

    private lateinit var viewModel: IntroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.intro_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(IntroViewModel::class.java)


        button_cats.setOnClickListener {
            viewModel.onCatsButtonClicked()
        }
        button_dogs.setOnClickListener {
            viewModel.onDogsButtonClicked()
        }

        viewModel.catsButtonClick.observe(this, Observer {
            val action = IntroFragmentDirections.navigateToCats()

            findNavController().navigate(action)
        })
        viewModel.dogsButtonClick.observe(this, Observer {
            val action = IntroFragmentDirections.navigateToDogs()
            findNavController().navigate(action)
        })

    }

}

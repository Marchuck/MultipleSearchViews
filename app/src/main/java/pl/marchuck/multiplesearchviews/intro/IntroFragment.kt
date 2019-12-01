package pl.marchuck.multiplesearchviews.intro

import android.os.Bundle
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.intro_fragment.*
import pl.marchuck.multiplesearchviews.R
import pl.marchuck.multiplesearchviews.base.BaseFragment

class IntroFragment : BaseFragment(R.layout.intro_fragment) {

    private lateinit var viewModel: IntroViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = IntroViewModel()

        button_elves.setOnClickListener {
            viewModel.onElvesButtonClicked()
        }
        button_hobbits.setOnClickListener {
            viewModel.onHobbitsButtonClicked()
        }

        viewModel.navigateToElves.observe(this, Observer {
            val action = IntroFragmentDirections.navigateToElves()
            navController.navigate(action)
        })

        viewModel.navigateToHobbits.observe(this, Observer {
            val action = IntroFragmentDirections.navigateToHobbits()
            navController.navigate(action)
        })
    }
}

package pl.marchuck.multiplesearchviews.base

import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import pl.marchuck.multiplesearchviews.App
import pl.marchuck.multiplesearchviews.MainActivity
import pl.marchuck.multiplesearchviews.MainViewModel
import pl.marchuck.multiplesearchviews.R

abstract class BaseFragment(resId: Int) : Fragment(resId) {

    fun provideMainViewModel(): MainViewModel {
        val activity = requireActivity()
        if (activity is MainActivity) {
            return activity.mainViewModel
        }
        throw RuntimeException(IllegalStateException("parent activity needs to be ${MainActivity::class.java}"))
    }

    fun provideApp() = requireContext().applicationContext as App

    val navController by lazy {
        findNavController(
            requireActivity(),
            R.id.fragment_nav_host
        )
    }
}
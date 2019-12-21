package pl.marchuck.multiplesearchviews.base

import androidx.fragment.app.Fragment
import pl.marchuck.multiplesearchviews.App
import pl.marchuck.multiplesearchviews.MainViewModel
import pl.marchuck.multiplesearchviews.MainViewModelOwner

abstract class BaseFragment(resId: Int) : Fragment(resId) {

    fun provideMainViewModel(): MainViewModel {
        return (activity as? MainViewModelOwner)
            ?.mainViewModel
            ?: throw RuntimeException(IllegalStateException("parent activity needs to be ${MainViewModelOwner::class.java}"))
    }

    fun provideApp() = requireContext().applicationContext as App
}
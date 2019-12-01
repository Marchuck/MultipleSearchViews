package pl.marchuck.multiplesearchviews.intro

import androidx.lifecycle.ViewModel;
import pl.marchuck.multiplesearchviews.base.LiveEvent

class IntroViewModel : ViewModel() {

    val navigateToElves = LiveEvent<Any>()

    val navigateToHobbits = LiveEvent<Any>()

    fun onElvesButtonClicked() {
        navigateToElves.value = Any()
    }

    fun onHobbitsButtonClicked() {
        navigateToHobbits.value = Any()
    }
}

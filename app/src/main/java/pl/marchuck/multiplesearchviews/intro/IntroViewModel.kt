package pl.marchuck.multiplesearchviews.intro

import androidx.lifecycle.ViewModel;
import pl.marchuck.multiplesearchviews.base.LiveEvent

class IntroViewModel : ViewModel() {

    val catsButtonClick = LiveEvent<Any>()
    val dogsButtonClick = LiveEvent<Any>()

    fun onCatsButtonClicked() {
        catsButtonClick.value = Any()
    }

    fun onDogsButtonClicked() {
        dogsButtonClick.value = Any()
    }
}

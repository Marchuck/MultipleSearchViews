package pl.marchuck.multiplesearchviews.elves

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.marchuck.multiplesearchviews.data.Character
import pl.marchuck.multiplesearchviews.data.CharactersDataSource

class ElvesViewModel(private val dataSource: CharactersDataSource) : ViewModel() {

    val results = MutableLiveData<List<Character>>()

    fun queryDataSet(query: String) {
        results.value = dataSource.filter("Elf", query)
    }
}

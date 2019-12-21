package pl.marchuck.multiplesearchviews.data

import android.content.res.Resources
import com.google.gson.Gson
import pl.marchuck.multiplesearchviews.R

class LotrCharactersDataSource(private val resources: Resources) : CharactersDataSource {

    private val dataSet: Characters by lazy {
        val stream = resources.openRawResource(R.raw.characters)
        val json = stream.bufferedReader().use { it.readText() }
        Gson().fromJson(json, Characters::class.java)
    }

    override fun filter(race: String, query: String): List<Character> {
        return dataSet.filter {
            it.race == race && it.name.contains(query, ignoreCase = true)
        }
    }
}
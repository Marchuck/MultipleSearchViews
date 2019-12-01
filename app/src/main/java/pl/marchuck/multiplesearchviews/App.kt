package pl.marchuck.multiplesearchviews

import android.app.Application
import pl.marchuck.multiplesearchviews.data.CharactersDataSource
import pl.marchuck.multiplesearchviews.data.LotrCharactersDataSource

class App : Application() {

    val dataSource: CharactersDataSource by lazy { LotrCharactersDataSource(resources) }

    override fun onCreate() {
        super.onCreate()

    }
}
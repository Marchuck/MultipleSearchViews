package pl.marchuck.multiplesearchviews.data

interface CharactersDataSource {
    fun filter(race: String, query: String): List<Character>
}
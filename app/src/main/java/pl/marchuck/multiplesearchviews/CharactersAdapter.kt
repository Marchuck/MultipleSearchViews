package pl.marchuck.multiplesearchviews

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import pl.marchuck.multiplesearchviews.data.Character
import pl.marchuck.multiplesearchviews.elves.SearchResultViewHolder

class CharactersAdapter(callback: CharacterCallback = CharacterCallback()) :
    ListAdapter<Character, SearchResultViewHolder>(callback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(SearchResultViewHolder.layoutResId, parent, false)
        return SearchResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchResultViewHolder, position: Int) {
        val item = getItem(position) ?: return
        val hash = item.hashCode()
        val color = Color.rgb(Color.red(hash), Color.green(hash), Color.blue(hash))
        holder.bind(item, color)
    }
}

class CharacterCallback :
    DiffUtil.ItemCallback<Character>() {

    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.name == newItem.name &&
                oldItem.race == newItem.race
    }

}
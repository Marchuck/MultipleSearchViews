package pl.marchuck.multiplesearchviews.elves

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.marchuck.multiplesearchviews.R
import pl.marchuck.multiplesearchviews.data.Character

class SearchResultViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        const val layoutResId = R.layout.item_elf
    }

    val name: TextView = view.findViewById(R.id.item_name)
    val picture: ImageView = view.findViewById(R.id.item_picture)

    fun bind(character: Character, color: Int) {
        name.text = character.name
        picture.setBackgroundColor(color)
    }

}
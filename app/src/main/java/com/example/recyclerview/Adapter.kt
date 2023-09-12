package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private var context:Context, private var dataSet:List<Country>)
    : RecyclerView.Adapter<Adapter.CardViewHolder>()
{
    // class which hold card objects
    inner class CardViewHolder(view:View) : RecyclerView.ViewHolder(view)
    {
        var cardDesign:CardView
        var text:TextView
        var more:ImageView

        init{
            cardDesign = view.findViewById(R.id.cardView)
            text = view.findViewById(R.id.textView)
            more = view.findViewById(R.id.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val design = LayoutInflater.from(context).inflate(R.layout.card_design, parent, false)
        return CardViewHolder(design)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val country = dataSet[position]

        holder.cardDesign.setOnClickListener{
            Toast.makeText(context, country.name.uppercase(), Toast.LENGTH_SHORT).show()
        }

        holder.text.text = country.name.replaceFirst(country.name.first(), country.name.first().uppercaseChar())

        holder.more.setOnClickListener {

           val popUp = PopupMenu(context, holder.more)
            popUp.menuInflater.inflate(R.menu.menu_design, popUp.menu)

            popUp.show()

            popUp.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.Continent -> {
                        Toast.makeText(context, country.continent, Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.Population -> {
                        Toast.makeText(context, country.population.toString(), Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }
        }
    }
}
package com.example.stories

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CustomRecycleAdapter (private val storyList :ArrayList<Story>,val context:Context) : RecyclerView.Adapter<CustomRecycleAdapter.DataHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int):DataHolder {
      return  DataHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.story,parent,false
        ),)

    }
    override fun onBindViewHolder(holder:DataHolder,position:Int) {
        val story = storyList[position]
        holder.storyTitle.text = story.title
        holder.storySubTitle.text = story.subTitle
        holder.stroyStartLetter.text  = story.title.first().toString()
        generateColor(holder,position)

        holder.itemView.setOnClickListener {
            val i = Intent(context,StoryDetailsActivity::class.java)
            i.putExtra("Title",story.title)
            i.putExtra("SubTitle",story.subTitle)
            context.startActivity(i)
        }

    }

    private fun generateColor(holder: DataHolder, position: Int) {
        val r = java.util.Random()
        val red = r.nextInt(255+position)
        val green = r.nextInt(255-position+1)
        val blue = r.nextInt(255+position+1)
        holder.stroycircleColor.setCardBackgroundColor(Color.rgb(red,green,blue))

    }

    override fun getItemCount(): Int {
        return  storyList.size
    }


    class DataHolder (item: View):RecyclerView.ViewHolder(item){
        val storyTitle = item.findViewById<TextView>(R.id.title_text_view)
        val storySubTitle = item.findViewById<TextView>(R.id.sub_title_text_view)
        val stroyStartLetter = item.findViewById<TextView>(R.id.stroy_start_letter)
        val stroycircleColor = item.findViewById<CardView>(R.id.circle)
    }
}
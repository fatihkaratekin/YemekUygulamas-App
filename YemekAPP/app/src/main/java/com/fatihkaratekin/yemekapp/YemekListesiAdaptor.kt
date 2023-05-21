package com.fatihkaratekin.yemekapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class YemekListesiAdaptor(private var items: List<Triple<String, String, Int>>):
    RecyclerView.Adapter<YemekListesiAdaptor.ViewHolder>() {


    fun setData(newData: List<Triple<String, String, Int>>){
        items = newData

        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.yemekler, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.imageView.setImageResource(item.third)
        holder.textView.text = item.first

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, YemekTarifi::class.java)

            //resim ve açıklamanın verilerini gönderiyoruz
            intent.putExtra("foodName", item.first)
            intent.putExtra("explanation", item.second)
            intent.putExtra("image", item.third)
            context.startActivity(intent)
        }
    }



    // sadece item sayısı döndürüyor
    override fun getItemCount(): Int {
        return items.size
    }

}
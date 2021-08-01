package com.example.apiseries.viewmodel

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apiseries.databinding.ItemSeriesBinding
import com.example.apiseries.model.Series
import com.example.apiseries.ui.SeriesInfoActivity

class ListAdapter(private val listSeries: List<Series>):
        RecyclerView.Adapter<ListAdapter.SeriesViewHolder>() {

    private lateinit var bindingItem: ItemSeriesBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesViewHolder {
        bindingItem = ItemSeriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SeriesViewHolder(bindingItem)
    }

    override fun onBindViewHolder(holder: SeriesViewHolder, position: Int) {
        val tvShow = listSeries[position]

        holder.seriesName.text = tvShow.name


        val urlImage = tvShow.image.medium

        Glide.with(bindingItem.root)
            .load(urlImage)
            .into(holder.seriesImage)

        val idShow = tvShow.id

        holder.seriesImage.setOnClickListener {

            val context: Context = it.context

            val intent = Intent(context, SeriesInfoActivity::class.java)
                intent.putExtra("ID_SHOW", idShow)
            context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int = listSeries.size


    class SeriesViewHolder(bindingItem: ItemSeriesBinding) :
        RecyclerView.ViewHolder(bindingItem.root) {

        val seriesName: TextView = bindingItem.txtTitle
        val seriesImage: ImageView = bindingItem.imgSerie

    }

}
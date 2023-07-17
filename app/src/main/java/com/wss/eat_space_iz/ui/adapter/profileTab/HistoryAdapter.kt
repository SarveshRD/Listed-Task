package com.wss.eat_space_iz.ui.adapter.profileTab

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.wss.eat_space_iz.data.networkModels.listed.RecentLink
import com.wss.eat_space_iz.databinding.CustomAllCategoriesListItemLayoutBinding
import com.wss.eat_space_iz.utils.Drawables
import com.wss.eat_space_iz.utils.Layouts
import java.text.SimpleDateFormat
import java.util.*

class HistoryAdapter(private val data: List<RecentLink>) :
    RecyclerView.Adapter<HistoryAdapter.MyViewHolder>() {

    private lateinit var binding: CustomAllCategoriesListItemLayoutBinding
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        context = parent.context
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            Layouts.custom_all_categories_list_item_layout,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val viewCategoriesData = data[position]
        //   val color = "#${viewCategoriesData.colorCode}".toColorInt()
        with(binding) {
            imageView3.load(viewCategoriesData.originalImage) {
                placeholder(Drawables.burger_icon)
                error(Drawables.burger_icon)
            }
            sampleLinkName.text = viewCategoriesData.smartLink
            clickCount.text = viewCategoriesData.totalClicks.toString()
            //materialCardView.setBackgroundColor(color)
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
            val outputFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())

            val date: Date = inputFormat.parse(viewCategoriesData.createdAt)
            val formattedDate: String = outputFormat.format(date)

            dateCard.text = formattedDate
            linkText.text = viewCategoriesData.webLink
        }


    }

    override fun getItemCount(): Int {
        return data.size
    }


    class MyViewHolder(val binding: CustomAllCategoriesListItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            // binding.mcvCampaignHistory.setOnClickListener { v ->
            //    onItemClickListener!!.onItemClick(absoluteAdapterPosition, v)
        }
    }

}
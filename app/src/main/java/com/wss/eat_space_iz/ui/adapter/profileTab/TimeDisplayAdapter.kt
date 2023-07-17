package com.wss.eat_space_iz.ui.adapter.profileTab

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.wss.eat_space_iz.databinding.CustomPickYourRideItemLayoutBinding
import com.wss.eat_space_iz.databinding.FragmentPickYourRideBottomSheetBinding
import com.wss.eat_space_iz.utils.Layouts

class TimeDisplayAdapter(private val data: List<Any>) :
    RecyclerView.Adapter<TimeDisplayAdapter.MyViewHolder>() {

    private lateinit var binding: CustomPickYourRideItemLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            Layouts.custom_pick_your_ride_item_layout,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return data.size
    }


    class MyViewHolder(val binding: CustomPickYourRideItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
           /* binding.mcvRestaurantImg.setOnClickListener { v ->
                PopularNearYouAdapter.onItemClickListener!!.onItemClick(absoluteAdapterPosition, v)
            }*/
        }
    }



}
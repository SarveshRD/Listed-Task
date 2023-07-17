package com.wss.eat_space_iz.ui.adapter.blogTab.followerAndFollowing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.wss.eat_space_iz.databinding.CustomFollowersListItemLayoutBinding
import com.wss.eat_space_iz.utils.Layouts

class FollowerAdapter(private val data : List<Any>):
    RecyclerView.Adapter<FollowerAdapter.MyViewHolder>()
{


    private lateinit var binding: CustomFollowersListItemLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerAdapter.MyViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            Layouts.custom_followers_list_item_layout,
            parent,
            false
        )
        return FollowerAdapter.MyViewHolder(binding)
    }
    override fun onBindViewHolder(holder: FollowerAdapter.MyViewHolder, position: Int) {}

    override fun getItemCount(): Int {
        return data.size
    }


    class MyViewHolder(val binding: CustomFollowersListItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /*  init {
              binding.mcvCampaignHistory.setOnClickListener { v ->
                  onItemClickListener!!.onItemClick(absoluteAdapterPosition, v)
              }*/
    }


}
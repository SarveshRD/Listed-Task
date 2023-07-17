package com.wss.eat_space_iz.data.networkModels.listed


import com.google.gson.annotations.SerializedName

data class ListedData(
    @SerializedName("overall_url_chart")
    val overallUrlChart: OverallUrlChart,
    @SerializedName("recent_links")
    val recentLinks: List<RecentLink>,
    @SerializedName("top_links")
    val topLinks: List<TopLink>
)
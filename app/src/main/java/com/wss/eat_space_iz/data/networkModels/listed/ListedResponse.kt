package com.wss.eat_space_iz.data.networkModels.listed


import com.google.gson.annotations.SerializedName

data class ListedResponse(
    @SerializedName("applied_campaign")
    val appliedCampaign: Int,
    @SerializedName("data")
    val data: ListedData,
    @SerializedName("extra_income")
    val extraIncome: Double,
    @SerializedName("links_created_today")
    val linksCreatedToday: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("startTime")
    val startTime: String,
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("support_whatsapp_number")
    val supportWhatsappNumber: String,
    @SerializedName("today_clicks")
    val todayClicks: Int,
    @SerializedName("top_location")
    val topLocation: String,
    @SerializedName("top_source")
    val topSource: String,
    @SerializedName("total_clicks")
    val totalClicks: Int,
    @SerializedName("total_links")
    val totalLinks: Int
)
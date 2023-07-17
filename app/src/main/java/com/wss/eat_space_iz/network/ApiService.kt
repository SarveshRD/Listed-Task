package com.wss.eat_space_iz.network


import com.wss.eat_space_iz.data.networkModels.listed.ListedResponse
import com.wss.eat_space_iz.utils.constants.AppConstants
import retrofit2.http.*


interface ApiService {


//Testing purpose
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjU5MjcsImlhdCI6MTY3NDU1MDQ1MH0.dCkW0ox8tbjJA2GgUx2UEwNlbTZ7Rr38PVFJevYcXFI")
    @GET(AppConstants.Api.UserEndUrl.LISTED)
    suspend fun topLink(): ListedResponse


}
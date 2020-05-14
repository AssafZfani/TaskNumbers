package zfani.assaf.task.data

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("8wJzytQX")
    fun getNumbers(): Call<JsonObject>
}
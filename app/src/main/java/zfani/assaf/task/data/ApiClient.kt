package zfani.assaf.task.data

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private var BASE_URL: String = "https://pastebin.com/raw/"
    val getClient: ApiInterface
        get() {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create(GsonBuilder().create())).build()
            return retrofit.create(ApiInterface::class.java)
        }
}
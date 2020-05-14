package zfani.assaf.task.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import zfani.assaf.task.data.ApiClient

class MainViewModel() : ViewModel() {

    private var numberList: MutableLiveData<List<Int>>? = null

    init {
        numberList = MutableLiveData()
    }

    fun getNumberList(): MutableLiveData<List<Int>>? {
        ApiClient.getClient.getNumbers().enqueue(object : Callback<JsonObject> {

            override fun onResponse(call: Call<JsonObject>?, response: Response<JsonObject>?) {
                handleResponse(response)
            }

            override fun onFailure(call: Call<JsonObject>?, t: Throwable?) {
            }
        })
        return numberList
    }

    private fun handleResponse(response: Response<JsonObject>?) {
        val jsonObject = response!!.body()!!
        val numbers = ArrayList<Int>()
        if (jsonObject.has("numbers")) {
            jsonObject.getAsJsonArray("numbers").forEach { it ->
                numbers.add(it.asJsonObject.get("number").asInt)
            }
        }
        numberList!!.value = numbers
    }
}
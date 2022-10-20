package binar.academy.chapter6topic5.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import binar.academy.chapter6topic5.model.ResponseDataMakeupItem
import binar.academy.chapter6topic5.network.RestfulAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ViewModelMakeup
@Inject constructor(var api: RestfulAPI) : ViewModel(){
    var liveDataMakeup: MutableLiveData<List<ResponseDataMakeupItem>>

    init {
        liveDataMakeup = MutableLiveData()
    }

    fun getliveDataMakeup() : MutableLiveData<List<ResponseDataMakeupItem>> {
        return  liveDataMakeup
    }

    fun callApi(){
        api.getAllMakeup().enqueue(object : Callback<List<ResponseDataMakeupItem>> {
            override fun onResponse(
                call: Call<List<ResponseDataMakeupItem>>,
                response: Response<List<ResponseDataMakeupItem>>
            ) {
                if (response.isSuccessful){
                    liveDataMakeup.postValue(response.body())
                }else{
                    liveDataMakeup.postValue(null)
                }
            }

            override fun onFailure(call: Call<List<ResponseDataMakeupItem>>, t: Throwable) {
                liveDataMakeup.postValue(null)
            }
        })
    }
}
package com.example.apiconnection.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apiconnection.model.People
import com.example.apiconnection.retrofit.RetrofitClient
import com.example.apiconnection.retrofit.services.PeopleService
import com.example.apiconnection.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PeopleViewModel : ViewModel() {

    private val peopleService: PeopleService = RetrofitClient.getClient(Constants.BASE_URL).create(PeopleService::class.java)

    private val _peopleList = MutableLiveData<List<People>>()
    val peopleList: LiveData<List<People>> get() = _peopleList

    private val _person = MutableLiveData<People>()
    val person: LiveData<People> get() = _person

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    private val _successMessage = MutableLiveData<String>()
    val successMessage: LiveData<String> get() = _successMessage

    fun fetchAllPeople() {
        peopleService.getAllPeople().enqueue(object : Callback<List<People>> {
            override fun onResponse(call: Call<List<People>>, response: Response<List<People>>) {
                if (response.isSuccessful) {
                    _peopleList.value = response.body() ?: emptyList()
                } else {
                    _errorMessage.value = "Error al obtener las personas"
                }
            }

            override fun onFailure(call: Call<List<People>>, t: Throwable) {
                _errorMessage.value = "Error: ${t.message}"
            }
        })
    }

    fun fetchPersonById(id: Int) {
        peopleService.getPeopleById(id).enqueue(object : Callback<People> {
            override fun onResponse(call: Call<People>, response: Response<People>) {
            if (response.isSuccessful) {
                _person.value = response.body()
            } else {
                _errorMessage.value = "Error al obtener los detalles de la persona"
            }
        }

            override fun onFailure(call: Call<People>, t: Throwable) {
                _errorMessage.value = "Error: ${t.message}"
            }
        })
    }

    fun createPerson(person: People) {
        peopleService.createPeople(person).enqueue(object : Callback<People>{
            override fun onResponse(call: Call<People>, response: Response<People>) {
            if (response.isSuccessful) {
                _successMessage.value = "Persona creada exitosamente"
                fetchAllPeople()
            } else {
                _errorMessage.value = "Error al crear la persona"
            }
        }

            override fun onFailure(call: Call<People>, t: Throwable) {
                _errorMessage.value = "Error: ${t.message}"
            }
        })
    }

    fun updatePerson(id: Int, person: People) {
        peopleService.updatePeople(id, person).enqueue(object : Callback<People> {
            override fun onResponse(call: Call<People>, response: Response<People>) {
            if (response.isSuccessful) {
                _successMessage.value = "Persona actualizada exitosamente"
                fetchAllPeople()
            } else {
                _errorMessage.value = "Error al actualizar la persona"
            }
        }

            override fun onFailure(call: Call<People>, t: Throwable) {
                _errorMessage.value = "Error: ${t.message}"
            }
        })
    }

    fun deletePerson(id: Int) {
        peopleService.deletePeople(id).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
            if (response.isSuccessful) {
                fetchAllPeople()
            } else {
                _errorMessage.value = "Error al borrar la persona"
            }
        }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                _errorMessage.value = "Error: ${t.message}"
            }
        })
    }
}
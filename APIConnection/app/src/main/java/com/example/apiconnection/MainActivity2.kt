package com.example.apiconnection

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.apiconnection.databinding.ActivityMain2Binding
import com.example.apiconnection.model.People
import com.example.apiconnection.viewModel.PeopleViewModel

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private val peopleViewModel: PeopleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClickListeners()
        observeViewModel()
    }

    private fun setOnClickListeners() {
        binding.btnSubmit.setOnClickListener {
            val name = binding.etName.text.toString()
            val phone = binding.etPhone.text.toString().toIntOrNull()
            val age = binding.etAge.text.toString().toIntOrNull()
            val email = binding.etEmail.text.toString()

            if (name.isNotBlank() && phone != null && age != null && email.isNotBlank()) {
                val newPeople = People(id = null, name = name, phone = phone, age = age, email = email)
                peopleViewModel.createPerson(newPeople)
            } else {
                Toast.makeText(this, "Por favor, complete todos los campos correctamente", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun observeViewModel() {
        peopleViewModel.successMessage.observe(this) { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            finish() // Volver a la actividad principal después de crear
        }

        peopleViewModel.errorMessage.observe(this) { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}

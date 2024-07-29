package com.example.apiconnection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.apiconnection.databinding.ActivityMain3Binding
import com.example.apiconnection.databinding.ActivityMain4Binding
import com.example.apiconnection.model.People
import com.example.apiconnection.viewModel.PeopleViewModel

class MainActivity4 : AppCompatActivity() {
    private lateinit var binding: ActivityMain4Binding
    private val peopleViewModel: PeopleViewModel by viewModels()
    private var personId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        personId = intent.getIntExtra("person_id", -1)
        if (personId != -1) {
            peopleViewModel.fetchPersonById(personId)
        }

        setOnClickListeners()
        observeViewModel()
    }

    private fun setOnClickListeners() {
        binding.btnUpdate.setOnClickListener {
            val name = binding.etName.text.toString()
            val phone = binding.etPhone.text.toString().toIntOrNull()
            val age = binding.etAge.text.toString().toIntOrNull()
            val email = binding.etEmail.text.toString()

            if (name.isNotBlank() && phone != null && age != null && email.isNotBlank()) {
                val updatedPerson = People(id = personId, name = name, phone = phone, age = age, email = email)
                peopleViewModel.updatePerson(personId, updatedPerson)
            } else {
                Toast.makeText(this, "Por favor, complete todos los campos correctamente", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun observeViewModel() {
        peopleViewModel.person.observe(this) { person ->
            person?.let {
                binding.etName.setText(it.name)
                binding.etPhone.setText(it.phone.toString())
                binding.etAge.setText(it.age.toString())
                binding.etEmail.setText(it.email)
            }
        }

        peopleViewModel.successMessage.observe(this) { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }

        peopleViewModel.errorMessage.observe(this) { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}
package com.example.apiconnection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apiconnection.adapters.PeopleAdapter
import com.example.apiconnection.databinding.ActivityMain3Binding
import com.example.apiconnection.viewModel.PeopleViewModel


class MainActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityMain3Binding
    private val peopleViewModel: PeopleViewModel by viewModels()
    private lateinit var peopleAdapter: PeopleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        observeViewModel()
        peopleViewModel.fetchAllPeople()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        peopleAdapter = PeopleAdapter(
            onUpdateClick = { person ->
                val intent = Intent(this, MainActivity4::class.java)
                intent.putExtra("person_id", person.id)
                startActivity(intent)
            },
            onDeleteClick = { person ->
                peopleViewModel.deletePerson(person.id!!)
            }
        )
        binding.recyclerView.adapter = peopleAdapter
    }

    private fun observeViewModel() {
        peopleViewModel.peopleList.observe(this) { people ->
            peopleAdapter.submitList(people)
        }

        peopleViewModel.errorMessage.observe(this) { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}
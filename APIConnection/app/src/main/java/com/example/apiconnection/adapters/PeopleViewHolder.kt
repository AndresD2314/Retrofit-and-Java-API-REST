package com.example.apiconnection.adapters

import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.apiconnection.databinding.ItemPersonBinding
import com.example.apiconnection.model.People


class PeopleViewHolder(
    private val binding: ItemPersonBinding,
    private val onUpdateClick: (People) -> Unit,
    private val onDeleteClick: (People) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(person: People) {
        binding.tvName.text = person.name
        binding.tvAge.text = "Edad: ${person.age}"
        binding.tvEmail.text = "Correo: ${person.email}"
        binding.tvPhone.text = "Número de celular: ${person.phone}"

        binding.btnUpdate.setOnClickListener {
            onUpdateClick(person)
        }

        binding.btnDelete.setOnClickListener {
            showDeleteConfirmationDialog(person)
        }
    }

    private fun showDeleteConfirmationDialog(person: People) {
        val builder = AlertDialog.Builder(binding.root.context)
        builder.setTitle("Confirmar eliminación")
        builder.setMessage("¿Estás seguro de que quieres eliminar a ${person.name}?")
        builder.setPositiveButton("Sí") { dialog, _ ->
            dialog.dismiss()
            onDeleteClick(person)
        }
        builder.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss()
        }
        val alert = builder.create()
        alert.show()
    }
}
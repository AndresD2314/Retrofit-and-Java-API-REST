package com.example.apiconnection.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apiconnection.databinding.ItemPersonBinding
import com.example.apiconnection.model.People


class PeopleAdapter(
    private val onUpdateClick: (People) -> Unit,
    private val onDeleteClick: (People) -> Unit
) : RecyclerView.Adapter<PeopleViewHolder>() {

    private var peopleList: List<People> = emptyList()

    fun submitList(list: List<People>) {
        peopleList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val binding = ItemPersonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PeopleViewHolder(binding, onUpdateClick, onDeleteClick)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        holder.bind(peopleList[position])
    }

    override fun getItemCount(): Int = peopleList.size
}

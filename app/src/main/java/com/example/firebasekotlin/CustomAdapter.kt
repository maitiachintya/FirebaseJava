package com.example.firebasekotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val employeelist : List<EmployeeModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder> (){


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textview: TextView = itemView.findViewById(R.id.tv_empname)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.firebase_childclass,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return employeelist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textview.text = employeelist.get(position).empname
    }
}
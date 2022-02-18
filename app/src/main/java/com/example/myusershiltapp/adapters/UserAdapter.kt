package com.example.myusershiltapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myusershiltapp.R
import com.example.myusershiltapp.models.UserResponseItem

class UserAdapter(private val userList: ArrayList<UserResponseItem>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView = view.findViewById(R.id.textViewName)
        val textViewEmail: TextView = view.findViewById(R.id.textViewEmail)
        val textViewStreet: TextView = view.findViewById(R.id.textViewStreet)
        val textViewSuite: TextView = view.findViewById(R.id.textViewSuite)
        val textViewCity: TextView = view.findViewById(R.id.textViewCity)
        val textViewPhone: TextView = view.findViewById(R.id.textViewPhone)
        val textViewWebsite: TextView = view.findViewById(R.id.textViewWebsite)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val userView = LayoutInflater.from(parent.context).inflate(R.layout.user_row_item, parent, false)

        return ViewHolder(userView);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewName.text = userList[position].name
        holder.textViewEmail.text = userList[position].email
        holder.textViewStreet.text = userList[position].address.street
        holder.textViewSuite.text = userList[position].address.suite
        holder.textViewCity.text = userList[position].address.city
        holder.textViewPhone.text = userList[position].phone
        holder.textViewWebsite.text = userList[position].website
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    /**
     * Update List in Activity
     */
    fun updateData(newList: List<UserResponseItem>) {
        userList.clear()
        userList.addAll(newList)
        notifyDataSetChanged()
    }
}
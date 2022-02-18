package com.example.myusershiltapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myusershiltapp.adapters.UserAdapter
import com.example.myusershiltapp.models.UserResponseItem
import com.example.myusershiltapp.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val userList = ArrayList<UserResponseItem>()
    private val _mainViewModel by viewModels<MainViewModel>()
    private lateinit var usersAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        _mainViewModel.getUsers().observe(this) { users ->
            users?.let { u ->
                usersAdapter.updateData(u)

            }
        }
    }

    private fun init() {
        val layoutManager = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView_Users)
        recyclerView.layoutManager = layoutManager

        usersAdapter = UserAdapter(userList)

        recyclerView.adapter = usersAdapter
    }
}
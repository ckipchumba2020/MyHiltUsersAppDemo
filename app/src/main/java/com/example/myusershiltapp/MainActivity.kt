package com.example.myusershiltapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myusershiltapp.adapters.UserAdapter
import com.example.myusershiltapp.models.User
import com.example.myusershiltapp.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val userList = ArrayList<User>()
    private val _mainViewModel by viewModels<MainViewModel>()
    private lateinit var usersAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        observeResult()
    }

    private fun init() {
        val layoutManager = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView_Users)
        recyclerView.layoutManager = layoutManager

        usersAdapter = UserAdapter(userList)

        recyclerView.adapter = usersAdapter
    }

    private fun observeResult() {
        _mainViewModel.getUsersResult().observe(this) {
            it?.let { result ->

                when(result.status) {
                    Status.SUCCESS  -> {
                        // TODO: hide progress bar

                        result.data?.let { users ->
                            usersAdapter.updateData(users)
                            Toast.makeText(this, result.message, Toast.LENGTH_LONG).show()
                        }
                    }

                    Status.ERROR  -> {
                        // TODO: hide progress bar
                        result.message?.let {
                            Toast.makeText(this, result.message, Toast.LENGTH_LONG).show()
                        }
                    }

                    Status.LOADING  -> {
                        // TODO: show progress bar

                        result.data?.let { users ->
                            usersAdapter.updateData(users)
                            Toast.makeText(this, result.message, Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }
    }
}
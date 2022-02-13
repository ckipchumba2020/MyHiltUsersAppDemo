package com.example.myusershiltapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.myusershiltapp.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val _mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _mainViewModel.getUsers().observe(this, { users ->
            users.let {
                Log.d("MainActivity", "users: $it")

                Log.d("MainActivity", "singleUser ${it[0]?.username}")
            }
        })
    }
}
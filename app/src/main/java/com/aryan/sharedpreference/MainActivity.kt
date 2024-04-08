package com.aryan.sharedpreference

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aryan.sharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editor = getSharedPreferences("My Settings", Context.MODE_PRIVATE)
        binding.EmailText.setText(editor.getString("email",null))
        binding.PassText.setText(editor.getString("password",null))

        binding.login.setOnClickListener{
            val editor = getSharedPreferences("My Settings", Context.MODE_PRIVATE).edit()
            editor.putString("email",binding.EmailText.text.toString())
            editor.putString("password",binding.PassText.text.toString())
            editor.apply()
        }
    }
}
package com.aryan.sharedpreference

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aryan.sharedpreference.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            val editor = getPreferences(MODE_PRIVATE).edit()
            editor.putString("nameid",binding.nameid.text.toString())
            editor.putBoolean("checkBox",binding.checkBox.isChecked)
            editor.apply()
        }
    }
}

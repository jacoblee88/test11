package com.example.session09

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.session09.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // ---------------------------------------------
        binding.buttonSave.setOnClickListener {
            val message = binding.editTextMessage.text.toString()
            saveMessage(message)
            displayMessage(readMessage())
        }
        displayMessage(readMessage())
    }

    private fun saveMessage(message: String) {
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("message", message)
        editor.apply()
        Toast.makeText(this, "Message saved", Toast.LENGTH_SHORT).show()
    }

    private fun readMessage(): String? {
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        return sharedPreferences.getString("message", "")
    }

    private fun displayMessage(message: String?) {
        binding.textViewDisplay.text = message
    }
}
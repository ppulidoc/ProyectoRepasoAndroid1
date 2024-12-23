package com.paudam.proyectorepasoandroid1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.paudam.proyectorepasoandroid1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val KEY_CURS = "curs"
    var spinnerValue = ""
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main)

        //Intent
        val intent = Intent(applicationContext, ListadoUsers::class.java)

        //Spinner
        val spinner: Spinner = findViewById(R.id.spinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.cursos,
            android.R.layout.simple_spinner_item

        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedValue = parent.getItemAtPosition(position).toString()
                spinnerValue = selectedValue
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                spinnerValue = "No has seleccionado nada"
            }
        }


        //Automatico
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        //Boton Intent pasa valor a Act2
        binding.butChoseCurs.setOnClickListener {
            //intent amb parametre de curs
            intent.putExtra(KEY_CURS,spinnerValue)
            startActivity(intent)
        }





    }
}
package com.paudam.proyectorepasoandroid1

import android.os.Bundle
import android.provider.ContactsContract.Data
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.paudam.proyectorepasoandroid1.databinding.ActivityListadoUsersBinding

class ListadoUsers : AppCompatActivity() {

    lateinit var v_curs: String
    val KEY_CURS = "curs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityListadoUsersBinding = DataBindingUtil.setContentView(this, R.layout.activity_listado_users)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_listado_users)
        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        // Este es el lugar correcto para declarar la variable arrayAlumnos
        var arrayAlumnos: List<Alumnos> = listOf()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Recuperar el valor de la clave "curs" desde el intent
        val intent2 = intent
        val curs = intent2.getStringExtra(KEY_CURS)

        // Filtrar los alumnos según el valor de "curs"
        if (curs == "1r ESO") {
            arrayAlumnos = DataSource().loadAlumnos1()  // Cargar solo los de primer curso
        }

        if (curs == "2n ESO") {
            arrayAlumnos = DataSource().loadAlumnos2()  // Cargar solo los de primer curso
        }

        if (curs == "3r ESO") {
            arrayAlumnos = DataSource().loadAlumnos3()  // Cargar solo los de primer curso
        }


        //else {
          //  arrayAlumnos = DataSource().loadAlumnos()   // Cargar todos los alumnos
        //}

        // Pasar la lista de alumnos al adaptador
        val alumnoAdapter = CustomAdapter(arrayAlumnos)
        binding.recyclerview.adapter = alumnoAdapter

        binding.buttonVolver.setOnClickListener {
            finish()
        }
    }
}

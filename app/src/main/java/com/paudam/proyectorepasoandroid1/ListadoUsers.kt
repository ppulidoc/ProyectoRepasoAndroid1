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

    lateinit var v_curs:String

    val KEY_CURS="curs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityListadoUsersBinding = DataBindingUtil.setContentView(this, R.layout.activity_listado_users)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_listado_users)
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        val arrayAlumnos = DataSource().loadAlumnos()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //con esto haces un get intent, con esto obtienes los intents de otras variables
        val intent2 = intent
        val curs = intent2.getStringExtra(KEY_CURS)

        if (curs == "1r ESO") {

        } else if(curs == "2n ESO") (

        ) else {

        }

        val alumnoAdapter = CustomAdapter(arrayAlumnos)
        binding.recyclerview.adapter =alumnoAdapter

    }
}
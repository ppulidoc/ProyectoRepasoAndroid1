package com.paudam.proyectorepasoandroid1
class DataSource {
    val arrayAlumnos = listOf(
        Alumnos(1,"Pablo", 20),
        Alumnos(2,"Marcos", 19),
        Alumnos(1,"Pedro", 22),
        Alumnos(3,"Cristian", 21),
        Alumnos(3,"Joel", 20),

        )
    fun loadAlumnos(): List<Alumnos> {
        return arrayAlumnos
    }
}

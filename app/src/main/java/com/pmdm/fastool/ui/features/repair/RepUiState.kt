package com.pmdm.fastool.ui.features.repair

import java.time.ZonedDateTime

data class RepUiState(
    val id: Int,
    val descripcion: String,
    val horaInicio: ZonedDateTime,
    val horaFin: ZonedDateTime?,
    val matricula: MatriculaUi
)

data class MatriculaUi(
    val id: Int,
    val matricula: String,
    val marca: String,
    val modelo: String,
    val clienteId: ClienteUi
)

data class ClienteUi(
    val id: Int,
    val nombre: String,
    val email: String,
    val cif: String,
    val password: String?
)


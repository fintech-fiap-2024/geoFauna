package br.com.fiap.geofauna.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_usuario")
data class Usuario(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val login: String = "",
    val senha: String = "",
    val telefone: String = "",
    val email : String = ""
)
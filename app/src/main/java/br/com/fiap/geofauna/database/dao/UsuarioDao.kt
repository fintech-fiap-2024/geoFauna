package br.com.fiap.geofauna.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.fiap.geofauna.model.Usuario

@Dao
interface UsuarioDao {
    @Insert
    fun cadastrarUsuario(user: Usuario): Long

    @Query("Select * FROM tbl_usuario WHERE login = :login AND senha = :senha")
    fun login(login: String, senha: String): Usuario
}
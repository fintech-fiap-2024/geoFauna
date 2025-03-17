package br.com.fiap.geofauna.database.repository

import android.content.Context

import br.com.fiap.geofauna.database.dao.UsuarioDb
import br.com.fiap.geofauna.model.Usuario

class UsuarioRepository (context : Context){

    private val db = UsuarioDb.getDatabase(context).UsuarioDao()

    fun cadastrar(usuario: Usuario): Long{
        return db.cadastrarUsuario(user = usuario)
    }

    fun login(login: String, senha: String):Usuario{
        return db.login(login = login,senha=senha)
    }
}

package com.springboot.service;

import com.springboot.model.Usuario;

public interface IUsuarioService extends ICRUD<Usuario> {

	Usuario registrarUsuario(Usuario dto);
	Usuario findByUsername(String username);
}

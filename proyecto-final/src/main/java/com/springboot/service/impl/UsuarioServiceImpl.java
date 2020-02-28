package com.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.Usuario;
import com.springboot.repository.IUsuarioRepo;
import com.springboot.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService /*, UserDetailsService*/{

	@Autowired
	private IUsuarioRepo repo;
	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//	Usuario	us = repo.findByUsername(username);
//	
//	List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
//	roles.add(new SimpleGrantedAuthority("ADMIN"));
//	UserDetails userDet = new User(us.getUsername(),us.getPassword(),roles);
//	return userDet;
//	}

	@Override
	public Usuario registrar(Usuario obj) {
		// TODO Auto-generated method stub
//		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
//		obj.setPassword(encoder.encode(obj.getPassword()));
		return repo.save(obj);
	}

	@Override
	public Usuario modificar(Usuario obj) {
		// TODO Auto-generated method stub
		return repo.saveAndFlush(obj);
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Usuario leerPorId(Integer id) {
		Optional<Usuario> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Usuario();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

	@Override
	public Usuario registrarUsuario(Usuario dto) {
		
		return repo.save(dto);
	}

	@Override
	public Usuario findByUsername(String username) {
		// TODO Auto-generated method stub
		for(Usuario user:repo.findAll()) {
			if(user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}


}

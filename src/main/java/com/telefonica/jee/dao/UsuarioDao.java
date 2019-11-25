package com.telefonica.jee.dao;

import java.util.List;

import com.telefonica.jee.entities.Usuario;

public interface UsuarioDao {

	/**
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	
	public boolean login (String email, String password); 
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Usuario findById(Long id); 
	
	
	/**
	 * 
	 * @return
	 */
	public List <Usuario> findAll();
	
	/**
	 * Recibe un objeto usuario y lo almacena en la base de datos.
	 * Podemos usar el create para registrar un usuario en la plataforma.
	 * @return
	 */
	
	public Usuario create (Usuario usuario); 
	
	
	
	
	/**S
	 * Recibe un objeto usuario y lo almacena en la base de datos.
	 * @param usuario
	 * @return
	 */
	
	public Usuario update (Usuario usuario); 
	
	
	/**
	 * Actualiza la password de un usuario a partir de su id
	 * @param userId
	 * @param newPass
	 * @return
	 */
	
	
	
	
	/**
	 * Recibe un id y borra el usuario de la base de datos correspondiente a ese id.
	 * @param id
	 */
	
	void delete(Long id); 
	
	
}

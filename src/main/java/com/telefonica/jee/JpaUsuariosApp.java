package com.telefonica.jee;

import java.util.List;
import com.telefonica.jee.dao.UsuarioDAOImpl;
import com.telefonica.jee.entities.Usuario;


public class JpaUsuariosApp {

	public static void main(String[] args) {
		
		UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl(); 
		
		//metodo login
		System.out.println(usuarioDAOImpl.login("dfsdfsdf","fsedfsedf"));
		System.out.println(usuarioDAOImpl.login("fdgsggdgs@gmail.com","lalala")); 
		
		//metodo find 
		
		Usuario usuario1 = usuarioDAOImpl.findById (1l); 
		System.out.println(usuario1);
		
		//metodo findAll
		
		List<Usuario> usuarios = usuarioDAOImpl.findAll(); 
		System.out.println(usuarios.size());
		System.out.println(usuarios);
		
		//metodo create
		
		Usuario usuario = new Usuario("Fonso", "Martinez", "bada@gmail.com", "+654768789", "putavida"); 
		/**
		 * lo que acabas de hacer arriba equivale a lo mismo que lo que tienes abajo
		 */
		usuarioDAOImpl.create (usuario); 
		System.out.println(usuario);
		
		// metodo update 
		
//		usuario.setEmail ("cursojava@telefonica.com"); 
//		usuarioDAOImpl.update(usuario); 
//		System.out.println(usuario);
		
		//metodo delete
		
		usuarioDAOImpl.delete(1l); 
		
	
	}

}

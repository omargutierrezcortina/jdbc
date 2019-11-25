package com.telefonica.jee.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.telefonica.jee.entities.Usuario;

public class UsuarioDAOImpl implements UsuarioDao {
	
	private static final String USER_COUNT = "SELECT COUNT (u) FROM Usuario u "
			+ "WHERE u.email = :email AND u.password = :password";
	private static EntityManagerFactory managerFactory= 
			Persistence.createEntityManagerFactory("jpa-usuarios"); 
	private EntityManager manager; 
	
	public UsuarioDAOImpl() {
		manager = managerFactory.createEntityManager ();
	
	}

	@Override
	public boolean login(String email, String password) {
		
		TypedQuery<Long> query = manager.createQuery(USER_COUNT, Long.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		Long numUsuario = query.getSingleResult (); 
		System.out.println("número de usuarios con email y password" + numUsuario);
		
//		if (numUsuario > 0) {
//			return true
//		}		
//		return false;  ------------- 	va a ser lo mismo que lo siguiente
		
		return numUsuario > 0; 
	}

	@Override
	public Usuario findById(Long id) {
				
		
		if (id==null) {
			return null;
		}
		return manager.find(Usuario.class, id);
	}

	@Override
	public List<Usuario> findAll() {
		
		
		TypedQuery <Usuario> namedQuery= 
				manager.createNamedQuery ("Usuario.findAll", Usuario.class); 
		List<Usuario> usuarios = namedQuery.getResultList(); 
				return usuarios;
	}

	@Override
	public Usuario create(Usuario usuario) {
		if (usuario==null) {
			return usuario;
		}

		try{
			manager.getTransaction().begin();   
			manager.persist(usuario); 
			manager.getTransaction().commit();    
		}catch(PersistenceException e){
			e.printStackTrace();
			manager.getTransaction().rollback();   
			
		}
		return usuario;
	}

//	@Override
//	public Usuario update(Usuario usuario) {
//		
//		if (usuario.getId() == null) {
//			return usuario; 
//		}
//		
//		Usuario userDB = this.findById(usuario.getId()); 
//		userDB.setApellido(usuario.getApellido());
//		userDB.setEmail(usuario.getEmail());
//		userDB.setNombre(usuario.getNombre());
//		userDB.setPassword(usuario.getPassword());
//		userDB.setTelefono(usuario.getTelefono());
//
//		
//		manager.getTransaction().commit();
//		return usuario;
//	}

	@Override
	public void delete(Long id) {
	// manger remove 
		manager.getTransaction().begin(); 
		manager.remove(manager.find(Usuario.class,  id)); 
		manager.getTransaction().commit(); 
		

	}

	@Override
	public Usuario update(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}

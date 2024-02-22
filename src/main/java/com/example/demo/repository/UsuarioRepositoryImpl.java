package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Usuario;

@Transactional
@Repository
public class UsuarioRepositoryImpl implements IUsuarioRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Usuario consultarPoNombre(String nombre) {
		TypedQuery<Usuario> query = this.entityManager.createQuery("SELECT u FROM Usuario u WHERE u.nombre=:value",
				Usuario.class);
		query.setParameter("value", nombre);
		return query.getSingleResult();
	}

}

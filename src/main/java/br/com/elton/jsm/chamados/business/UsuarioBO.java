package br.com.elton.jsm.chamados.business;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import br.com.elton.jsm.chamados.models.UsuarioModel;

public class UsuarioBO {
	
	/**
	 * Método destinado a realizar a criptografia de Senha
	 * Usa o MD5
	 * 
	 * @param dsSenha
	 * @return
	 * @throws Exception
	 */
	
	
	public String encryptPassword(String dsSenha) throws Exception {
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		BigInteger hash = new BigInteger(1, messageDigest.digest(dsSenha.getBytes()));
		
		return hash.toString(16);
	}
	
	/**
	 * Método destinado para busca uma lista de Usuários
	 * @param entityManager responsável pela conexão com o banco de dados 
	 * @return retorna uma lista de Usuários
	 */
	@SuppressWarnings("unchecked")
	public List<UsuarioModel> getListUsuarios(EntityManager entityManager){
		Query query = entityManager.createQuery("from UsuarioModel");
		List<UsuarioModel> usuarios = query.getResultList();
		return usuarios;
	}
	
	
	/**
	 * Esse método irá checar se o email é único no sistema
	 * 
	 * Retorna true se o email for único
	 * 
	 * @param nmUser
	 * @param dsSenha
	 * @param entityManager
	 * @return
	 */
	public boolean checkEmailUnico(int idUsuario, String dsEmail, EntityManager entityManager) {
		
		String query = "";
		
		query += " from ";
		query += "   UsuarioModel u ";
		query += " where ";
		query += "   u.dsEmail = :dsEmail ";
		query += "   and u.idUsuario <> :idUsuario ";
		
		UsuarioModel usuario = null;
		
		try {
			usuario = (UsuarioModel) entityManager
					.createQuery(query)
					.setParameter("dsEmail", dsEmail)
					.setParameter("idUsuario", idUsuario)
					.setFirstResult(0)
					.setMaxResults(1)
					.getSingleResult();
		} catch (NoResultException noResult) {
			return true;
		} catch (NonUniqueResultException noUnique) {
			return false;
		} 
		
		if (usuario != null)
			return false;
		
		return true;
	}
	/**
	 * Método utilizado para o login do usuário.
	 * 
	 * nmUser = email
	 * 
	 * @param nmUser
	 * @param dsSenha
	 * @param entityManager
	 * @return
	 */
	public UsuarioModel getUsuario(String nmUser, String dsSenha, EntityManager entityManager) {
		
		String query = "";
		
		query += " from ";
		query += "   UsuarioModel u ";
		query += " where ";
		query += "   u.dsEmail = :dsEmail ";
		
		UsuarioModel usuario = null;
		
		try {
			usuario = (UsuarioModel) entityManager
					.createQuery(query)
					.setParameter("dsEmail", nmUser)
					.setFirstResult(0)
					.setMaxResults(1)
					.getSingleResult();
		} catch (NoResultException noResult) {
			
		} catch (NonUniqueResultException noUnique) {
			noUnique.printStackTrace();
		} 
		
		return usuario;
	}
	
}

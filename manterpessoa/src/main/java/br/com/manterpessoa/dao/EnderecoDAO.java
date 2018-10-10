package br.com.manterpessoa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.manterpessoa.entidade.Endereco;

public class EnderecoDAO {
	
	private EntityManager em;
	
	public EnderecoDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puManterPessoa");
		em = emf.createEntityManager();
	}
	
	public void inserir(Endereco endereco) {
		try {
			
			em.getTransaction().begin();
			em.persist(endereco);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	public void remover(Endereco endereco) {
		try {
			
			em.getTransaction().begin();
			endereco = em.find(Endereco.class, endereco.getCep());
			em.remove(endereco);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	public void alterar(Endereco endereco) {
		try {
			
			em.getTransaction().begin();
			endereco = em.find(Endereco.class, endereco.getCep());
			em.merge(endereco);
			em.getTransaction().commit();
			
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	public Endereco buscarPorCep(String cep) {
		return em.find(Endereco.class, cep);
	}
	
	public List<Endereco> buscarTodos(){
		StringBuilder hql = new StringBuilder();
		
		hql.append("SELECT e ").append("FROM ").append(Endereco.class.getName()).append(" e ");
		
		return em.createQuery(hql.toString(), Endereco.class).getResultList();
	}
}

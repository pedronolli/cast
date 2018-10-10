package br.com.manterpessoa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.manterpessoa.entidade.Pessoa;

public class PessoaDAO {
	
	private EntityManager em;
	
	public PessoaDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puManterPessoa");
		em = emf.createEntityManager();
	}
	
	public void inserir(Pessoa pessoa) {
		try {
			
			em.getTransaction().begin();
			em.persist(pessoa);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	public void remover(Pessoa pessoa) {
		try {
			
			em.getTransaction().begin();
			pessoa = em.find(Pessoa.class, pessoa.getCpf());
			em.remove(pessoa);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	public void alterar(Pessoa pessoa) {
		try {
			
			em.getTransaction().begin();
			pessoa = em.find(Pessoa.class, pessoa.getCpf());
			em.merge(pessoa);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	public Pessoa buscarPorCpf(String cpf) {
		System.out.println(em.find(Pessoa.class, cpf));
		return em.find(Pessoa.class, cpf);
	}	
	
	public List<Pessoa> buscarTodas(){
		StringBuilder hql = new StringBuilder();
		
		hql.append("SELECT p ").append("FROM ").append(Pessoa.class.getName()).append(" p ")
			.append("JOIN fetch p.endereco");
		
		return em.createQuery(hql.toString(), Pessoa.class).getResultList();
		
	}
	
}

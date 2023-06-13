package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class RemoverUsuario {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		Usuario usuario = em.find(Usuario.class, 8L);
		
		if (usuario != null ) {
			em.getTransaction().begin();
			em.remove(usuario);
			em.getTransaction().commit();
			System.out.println(usuario.getNome() + " Deletado com sucesso");		
		} else 
			System.out.println("Usuário não encontrado!");

		em.close();
		emf.close();
	}

}

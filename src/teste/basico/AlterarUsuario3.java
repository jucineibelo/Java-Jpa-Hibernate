package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario3 {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Usuario usuario = em.find(Usuario.class, 7L);
		em.detach(usuario);  //nesse caso ele não vai fazer update na tabela porém se descomentar  em.merge ele volta a ficar em estado gerenciado
		usuario.setNome("Inacio Alterado");
		usuario.setEmail("inacio@cachaceiro.com");
		
		//em.merge(usuario);     
		
		em.getTransaction().commit();
		
			
		em.close();
		emf.close();
	}

}

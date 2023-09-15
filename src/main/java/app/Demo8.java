package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo8 {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();

		// select * from tb_usu --> lista
		String jpql = "select u from Usuario u where u.idtipo = :xtipo";
		int xtipo =1;
		List<Usuario> lstUsuarios = em.createQuery(jpql , Usuario.class).setParameter("xtipo", xtipo).getResultList();
		
		//mostar contenido del listado
		
		for (Usuario u : lstUsuarios) {
			System.out.println("Nombre: " + u.getNom_usua() + " " + u.getApe_usua());
			System.out.println("Tipo: " + u.getIdtipo() + "---" + u.getObjTipo().getDescripcion());
			System.out.println("---------------------------------------");

		}
		
		em.close();

	}
}

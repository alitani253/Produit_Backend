package org.sid.catsid;

import org.sid.catsid.dao.ProduitRepository;
import org.sid.catsid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import sun.tools.jar.CommandLine;

@SpringBootApplication
public class CatSidApplication implements CommandLineRunner {

		@Autowired
		private ProduitRepository produitRepository;
		@Autowired
		private RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(CatSidApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Produit.class);
		produitRepository.save(new Produit(null, "Ordinateur Lx 45", 6700, 3));


 		produitRepository.findAll().forEach(p ->{
			System.out.println(p.toString());

	});


	}
}

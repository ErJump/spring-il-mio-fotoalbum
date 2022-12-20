package org.generation.italy.demo;

import org.generation.italy.demo.pojo.Photo;
import org.generation.italy.demo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner{
	
	@Autowired
	private PhotoService pS;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Photo p1 = new Photo("Sogno di mezza estate", "Foto notturna, la luna", "https://www.reflex-mania.com/wp-content/uploads/2015/07/63989735_m.jpg", "notte", true);
		Photo p2 = new Photo("Amleto", "La passione, il dubbio, la morte", "https://artslife.com/wp-content/uploads/2021/05/Il-teschio-opera-di-Gian-Lorenzo-Bernini.png", "essere", true);
		Photo p3 = new Photo("Mi illumino d'immenso", "E luce fu", "https://www.vistanet.it/cagliari/wp-content/uploads/sites/2/2019/04/alba-poetto.jpg", "alba", false);
		Photo p4 = new Photo("Normalità", "Routine e noia", "https://www.repstatic.it/content/localirep/img/rep-roma/2021/09/26/211257761-011c659c-e203-4564-826f-123411d291a1.jpg", "Roma", true);
		
		pS.save(p1);
		pS.save(p2);
		pS.save(p3);
		pS.save(p4);
		
		System.err.println(pS.findAll());
		
	}

}

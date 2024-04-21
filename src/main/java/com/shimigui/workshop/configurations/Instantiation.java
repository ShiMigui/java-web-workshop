package com.shimigui.workshop.configurations;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.shimigui.workshop.domain.Post;
import com.shimigui.workshop.domain.User;
import com.shimigui.workshop.dto.CommentDTO;
import com.shimigui.workshop.repositories.PostRepository;
import com.shimigui.workshop.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository users;

	@Autowired
	private PostRepository posts;

	@Override
	public void run(String... args) throws Exception {
		users.deleteAll();
		posts.deleteAll();

		List<User> usersList = new ArrayList<>();
		User u1 = new User(null, "Miguel Nascimento dos Santos", "miguel@gmail.com");
		User u2 = new User(null, "Maria da Silva", "maria@gmail.com");
		User u3 = new User(null, "João Oliveira", "joao@gmail.com");
		usersList.add(u1);
		usersList.add(u2);
		usersList.add(u3);
		usersList.add(new User(null, "Ana Souza", "ana@gmail.com"));
		usersList.add(new User(null, "Pedro Fernandes", "pedro@gmail.com"));
		usersList.add(new User(null, "Juliana Costa", "juliana@gmail.com"));
		usersList.add(new User(null, "Lucas Pereira", "lucas@gmail.com"));
		usersList.add(new User(null, "Carla Santos", "carla@gmail.com"));
		usersList.add(new User(null, "Rafaela Martins", "rafaela@gmail.com"));
		usersList.add(new User(null, "Rodrigo Almeida", "rodrigo@gmail.com"));
		usersList.add(new User(null, "Amanda Ferreira", "amanda@gmail.com"));
		users.saveAll(usersList);

		List<Post> postsList = new ArrayList<>();
		Post p1 = new Post(null, Instant.parse("2024-09-06T15:32:00Z"), "Buenos días Colômbia!","Tenho o prazer de contar que vim a Colômbia! Este país maravilhoso", u3);
		Post p2 = new Post(null, Instant.parse("2024-04-20T10:15:00Z"), "Novo projeto de desenvolvimento","Comecei um novo projeto de desenvolvimento em Java. Estou ansioso para compartilhar mais detalhes em breve!",u1);
		Post p3 = new Post(null, Instant.parse("2024-04-19T14:30:00Z"), "Receita de bolo de chocolate","Compartilhando minha receita favorita de bolo de chocolate. Espero que gostem!", u2);
		Post p4 = new Post(null, Instant.parse("2024-09-08T12:45:00Z"), "Experiência colombiana","Estou impressionado com a cultura e a hospitalidade colombianas. Uma experiência incrível até agora!",
				u3);
		postsList.add(p1);
		postsList.add(p2);
		postsList.add(p3);
		postsList.add(p4);

		p1.addComment(new CommentDTO(Instant.parse("2024-09-08T12:51:00Z"), u2, "Que legal mano!"));
		p1.addComment(new CommentDTO(Instant.parse("2024-09-09T10:32:00Z"), u1, "Que sonho, sair do Brasil kkkk"));

		posts.saveAll(postsList);

		u3.addPost(p1);
		u1.addPost(p2);
		u2.addPost(p3);
		u3.addPost(p4);
		users.saveAll(usersList);
	}

}

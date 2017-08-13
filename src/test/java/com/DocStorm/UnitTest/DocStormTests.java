/*
package com.DocStorm.UnitTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.javasampleapproach.jpaunittest.entity.Customer;
import com.javasampleapproach.jpaunittest.repo.CustomerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DocStormTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	User_Repository userRepository;

	@Autowired
	Document_Repository documentRepository;

	@Autowired
	DocumentTranslation_Repository dtRepository;

	@Test
	public void should_find_userss_if_repository_is_empty() {
		Iterable<User> users = userRepository.findAll();
		assertThat(users).isEmpty();
	}
	
 	@Test
	public void should_store_Information() {
		User user = new User("Ahmed Ali", "ahmedali@gmail.com", "852147", "admin");
		Date date = new Date();
		Document document = new Document("Eclipse Tutorial", "Programming", date, user);
		DocumentTranslation dt = new DocumentTranslation("english",
				"this document will provide an eclipse tutorial....", date, document);
		userRepository.save(user);
		documentRepository.save(document);
		dtRepository.save(dt);
		
		assertThat(user).hasFieldOrPropertyWithValue("useremail", "ahmedali@gmail.com");
		assertThat(document).hasFieldOrPropertyWithValue("docname", "Eclipse Tutorial");
	}
	
	@Test
	public void should_delete_all_users() {
		User user1 = new User("Ahmed Ali", "ahmedali@gmail.com", "852147", "admin");
		entityManager.persist(user);
		
		User user2 = new User("Taha Mohamed", "ahmedali@gmail.com", "852147", "admin");
		entityManager.persist(user2);
 
		userRepository.deleteAll();
 
		assertThat(userRepository.findAll()).isEmpty();
	}
 	
 	@Test
	public void should_find_all_documents() {
		User user = new User("Ahmed Ali", "ahmedali@gmail.com", "852147", "admin");
		Date date = new Date();
		Document document1 = new Document("Eclipse Tutorial", "Programming", date, user);
		entityManager.persist(document1);
 		
 		Document document2 = new Document("Netbeans Tutorial", "Programming", date, user);
		entityManager.persist(document2);
 
		Document document3 = new Document("Spring Tutorial", "Programming", date, user);
		entityManager.persist(document3);
 
		Iterable<Document> documents = documentRepository.findAll();
 
		assertThat(documents).hasSize(3).contains(document1, document2, document3);
	}
 
}
*/
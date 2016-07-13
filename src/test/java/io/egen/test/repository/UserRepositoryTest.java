package io.egen.test.repository;

import io.egen.repository.UsersRepository;
import io.egen.repository.UsersRepositoryImpl;
import io.egen.entity.Users;
import io.igen.test.TestConfig;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class UserRepositoryTest {

	@Mock
	private EntityManager em;

	@InjectMocks
	private UsersRepository repository = new UsersRepositoryImpl();

	@Mock
	private TypedQuery<Users> query;
	private Users user;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		user = new Users();
		user.setPassword("dummy");
		user.setEmail("dummy@dummy.com");
		user.setFirstName("dummy");
		user.setLastName("Users");
		user.setId(UUID.randomUUID().toString());

	}

	@Test
	public void testFindAllUsers() {
		List<Users> expected = Arrays.asList(user);

		Mockito.when(em.createQuery("SELECT u FROM Users u ORDER BY u.id ASC", Users.class)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(expected);

		List<Users> users = repository.findAllUsers();
		Assert.assertEquals(expected, users);

	}

	@Test
	public void testFindUserById() {
		Mockito.when(em.find(Users.class, user.getId())).thenReturn(user);
		Users actual = repository.findUserById(user.getId());

		Assert.assertEquals(user, actual);
	}
	
	
	@Test
	public void testFindUserByEmailId()
	{
		List<Users> expected = Arrays.asList(user);
		Mockito.when(em.createNamedQuery("Users.findUserByEmailId", Users.class)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(expected);
		
		Users actual = repository.findUserByEmailId(user.getEmail());
		Assert.assertEquals(user, actual);
	}
    

	@Test
	public void testFindUserByEmailINull()
	{
		
		Mockito.when(em.createNamedQuery("Users.findUserByEmailId", Users.class)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(null);
		
		Users actual = repository.findUserByEmailId(user.getEmail());
		Assert.assertEquals(null, actual);
	}
	
	
	@Test
	public void testFindUserByEmailAndPassword()
	{
		List<Users> expected = Arrays.asList(user);
		Mockito.when(em.createNamedQuery("Users.findUserByEmailAndPassword", Users.class)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(expected);
		
		Users actual = repository.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
		Assert.assertEquals(user, actual);
	}
	
	@Test
	public void testFindUserByEmailAndPasswordNull()
	{
		
		Mockito.when(em.createNamedQuery("Users.findUserByEmailAndPassword", Users.class)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(null);
		
		Users actual = repository.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
		Assert.assertEquals(null, actual);
	}
	
	@Test
	public void testCreateUser(){
		repository.createUser(user);
		Mockito.verify(em).persist(user);
	}

	@Test
	public void testUpdateUser(){
		repository.updateUser(user);
		Mockito.verify(em).merge(user);
	}
	@Test
	public void testDeleteUser(){
		repository.deleteUser(user);
		Mockito.verify(em).remove(user);
	}
}

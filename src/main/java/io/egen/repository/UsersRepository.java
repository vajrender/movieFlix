package io.egen.repository;

import java.util.List;

import io.egen.entity.Users;

public interface UsersRepository {

	public Users findUserById(String id);

	public Users findUserByEmailId(String email);

	public Users createUser(Users users);

	public List<Users> findAllUsers();

	public Users findUserByEmailIdAndPassword(String email, String password);
	
	public Users findUserByEmailAndPassword(String email, String password);
	
	public Users updateUser(Users user);

	public void deleteUser(Users user);



}

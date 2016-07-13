package io.egen.service;

import io.egen.entity.Users;
import io.egen.exception.UserAlreadyExitsException;
import io.egen.exception.UserNotFoundException;
import io.egen.repository.UsersRepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersRepository repository;
	
	
	@Override
	public Users createUser(Users users) throws UserAlreadyExitsException {
		Users existing= repository.findUserByEmailId(users.getEmail());
		if(existing == null){
			return repository.createUser(users);
		}
		else
		{
			throw new UserAlreadyExitsException(); 
		}
		 
	}

	@Override
	public Users findUserById(String id) throws UserNotFoundException {
		Users existing = repository.findUserById(id);
		if(existing == null){
			throw new UserNotFoundException();
		}
		else{
			return existing;
		}
	}

	@Override
	public List<Users> findAllUsers() {
		return repository.findAllUsers();
	}

	@Override
	public Users findUserByEmailId(String email) throws UserNotFoundException {
		Users existing = repository.findUserByEmailId(email);
		if(existing == null){
			throw new UserNotFoundException();
			//return null;
		}
		else{
			return existing;
		}
	}

	@Override
	public Users findUserByEmailIdAndPassword(String email, String password)
			throws UserNotFoundException {
		Users existing = repository.findUserByEmailIdAndPassword(email,password);
		if(existing == null ){
			throw new UserNotFoundException();
		}else{
			return existing;
		}
	}
	
	@Override
	public Users findUserByEmailAndPassword(String email, String password)
			throws UserNotFoundException {
		Users existing = repository.findUserByEmailAndPassword(email,password);
		if(existing == null ){
			throw new UserNotFoundException();
		}else{
			return existing;
		}
	}

	@Override
	public Users updateUser(String id, Users user) throws UserNotFoundException {
		Users existing = repository.findUserById(id);
		if(existing == null){
			throw new UserNotFoundException();
		}
		else{
			return repository.updateUser(user);
		}
	}

	@Override
	public void deleteUser(String id) throws UserNotFoundException {
		Users existing = repository.findUserById(id);
		if(existing == null){
			throw new UserNotFoundException();
		}
		else{
			 repository.deleteUser(existing);
		}

	}

}

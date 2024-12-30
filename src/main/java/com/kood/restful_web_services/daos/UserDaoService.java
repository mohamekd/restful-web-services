package com.kood.restful_web_services.daos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;

import com.kood.restful_web_services.controllers.UserNotFoundError;
import com.kood.restful_web_services.entitys.User;

@Component
public class UserDaoService {
	
	private static List<User> users= new ArrayList<>();
	private static int uCount=0;
	static {
		users.add(new User(++uCount,"Kood",LocalDate.now().minusYears(30)));
		users.add(new User(++uCount,"Eve",LocalDate.now().minusYears(20)));
		users.add(new User(++uCount,"Adam",LocalDate.now().minusYears(10)));
	}
	public List<User> findAllUsers(){
		return users;
	}
	
	public User findUser(int id) {
		return users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
	}

	public User addUser(User u) {
		u.setId(++uCount);
		users.add(u);
		return u;
	}
	public void deleteUserById(int id) {
//		if(users.get(id)!=null) {
//			users.remove(id);
//		}else {
//			throw new UserNotFoundError("id : "+id +"is not exist");
//		}
		users.removeIf(u -> u.getId().equals(id));
	}

}

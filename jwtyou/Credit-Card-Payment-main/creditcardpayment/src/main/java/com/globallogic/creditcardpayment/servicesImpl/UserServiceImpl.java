package com.globallogic.creditcardpayment.servicesImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.globallogic.creditcardpayment.entity.Role;
import com.globallogic.creditcardpayment.entity.User;
import com.globallogic.creditcardpayment.repositories.CustomerRepo;
import com.globallogic.creditcardpayment.repositories.RoleDao;
import com.globallogic.creditcardpayment.repositories.UserRepo;
import com.globallogic.creditcardpayment.services.UserService;

//public class UserServiceImpl implements UserService {
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo userRepo;

	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	private RoleDao roledao;

	@Override
	public String adminSignIn(String id, String password) {
		List<User> user = userRepo.findAll();

		for (User u : user) {
			if (u.getUserName().equalsIgnoreCase(id) && u.getUserPassword().equalsIgnoreCase(password)) {
				return "ADMIN LOGIN SUCCESSFULL";
			}
		}
		return "INVALID USERID OR PASSWORD";
	}

	@Override
	public String customerSignIn(String id, String password) {
		List<User> user = userRepo.findAll();

		for (User u : user) {
			if (u.getUserName().equalsIgnoreCase(id) && u.getUserPassword().equalsIgnoreCase(password)) {
				return "CUSTOMER LOGIN SUCCESSFULL";
			}
		}
		return "INVALID USERID OR PASSWORD";
	}

	@Override
	public List<User> showUser() {
		return userRepo.findAll();
	}

	@Override
	public String addUser(User user) {

		// checking if any data is empty then exception thrown
		// ("INPUT FIELD IS EMPTY,PLEASE CHECK", HttpStatus.BAD_REQUEST)
//		if (user.getUserName().isEmpty() || user.getUserPassword().isEmpty()) {
//			throw new GlobalException();
//		}

		userRepo.save(user); // adding data in database
		return "USER REGISTERED SUCCESSFULLY";
	}

	@Override
	public String updateUser(User user) {

		// checking if any data is empty then exception thrown
		// ("INPUT FIELD IS EMPTY,PLEASE CHECK", HttpStatus.BAD_REQUEST)
//		if (user.getUserId().isEmpty() || user.getPassword().isEmpty() || user.getId() == 0) {
//			throw new GlobalException(); // ("INPUT FIELD IS EMPTY,PLEASE CHECK", HttpStatus.BAD_REQUEST)
//		}
//		if (userRepo.findById(user.getId()).get() == null) {
//			throw new GlobalException();// ("NO SUCH ID EXISTS IN DATABASE", HttpStatus.NOT_FOUND)
//		}
		userRepo.save(user);
		return "USER ID/PASSWORD UPDATED SUCCESSFULLY";
	}

	@Override
	public String deleteUser(long id) {
		// checking if given id is present in database
//		if (userRepo.findById(id).get() == null) {
//			throw new GlobalException(); // ("NO SUCH ID EXISTS IN DATABASE", HttpStatus.NOT_FOUND)
//		} else {
//			User user = userRepo.findById(id).get();
//			Customer customer = customerRepo.findByUserId(user.getId());
//			if (customer != null) {
//				return "USER ID/PASSWORD CANNOT BE DELETED AS MAPPING DONE WITH CUSTOMER"; // returning message
//			}
		// userRepo.deleteById(id); // deleting account if mapping not done
		return "USER ID/PASSWORD DELETED SUCCESSFULLY";
	}

	@Autowired
	    private PasswordEncoder passwordEncoder;

	public User registerNewUser(User user) {
		Role role = roledao.findById("User").get();
     Set<Role> userRoles = new HashSet<>();
     userRoles.add(role);
     user.setRole(userRoles);
     user.setUserPassword(getEncodedPassword(user.getUserPassword()));

     return userRepo.save(user);
		
	}

	public void initRolesAndUser() {
		Role adminRole = new Role();
		adminRole.setRolename("Admin");
		adminRole.setRoleDescription("Admin Role");
		roledao.save(adminRole);

		Role userRole = new Role();
		userRole.setRolename("User");
		userRole.setRoleDescription("Default role for newly created record");
		roledao.save(userRole);

		User adminUser = new User();
		adminUser.setUserName("admin123");
		adminUser.setUserPassword(getEncodedPassword("admin@pass"));

		Set<Role> adminRoles = new HashSet<>();
		adminUser.setRole(adminRoles);
		adminRoles.add(adminRole);

		userRepo.save(adminUser);

		/*
		 * User user = new User(); user.setUserName("raj123");
		 * user.setUserPassword(getEncodedPassword("raj@123"));
		 * user.setUserFirstName("raj"); user.setUserLastName("sharma"); Set<Role>
		 * userRoles = new HashSet<>(); userRoles.add(userRole);
		 * user.setRole(userRoles); userRepo.save(user);
		 */

	}

	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}
}

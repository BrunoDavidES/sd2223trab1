package sd2223.trab1.server.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response.Status;
import sd2223.trab1.api.User;
import sd2223.trab1.api.rest.UsersService;

//FALTA IMPLEMENTAR searchUsers
public class UsersResources implements UsersService {

	// VER MELHOR
	private final Map<String, User> users = new HashMap<>();
	private static Logger Log = Logger.getLogger(UsersResources.class.getName());

	public UsersResources() {

	}

	@Override
	public String createUser(User user) {
		Log.info("createUser : " + user);
		if (user.getName() == null || user.getPwd() == null || user.getDisplayName() == null
				|| user.getDomain() == null) {
			Log.info("User object invalid.");
			throw new WebApplicationException(Status.BAD_REQUEST);
		}
		if (users.putIfAbsent(user.getName(), user) != null) {
			Log.info("User already exists.");
			throw new WebApplicationException(Status.CONFLICT);
		}
		return user.getName();
	}

	@Override
	public User getUser(String name, String pwd) {
		Log.info("getUser : user = " + name + "; pwd = " + pwd);
		if (name == null || pwd == null) {
			Log.info("UserId or password null.");
			throw new WebApplicationException(Status.BAD_REQUEST);
		}
		var user = users.get(name);
		if (user == null) {
			Log.info("User does not exist.");
			throw new WebApplicationException(Status.NOT_FOUND);
		}
		if (!user.getPwd().equals(pwd)) {
			Log.info("Password is incorrect.");
			throw new WebApplicationException(Status.FORBIDDEN);
		}
		return user;
	}

	@Override
	public User updateUser(String name, String pwd, User user) {
		Log.info("updateUser : user = " + name + "; pwd = " + pwd + " ; user = " + user);
		if (name == null || pwd == null || user == null) {
			Log.info("UserId or password null.");
			throw new WebApplicationException(Status.BAD_REQUEST);
		}
		var existingUser = users.get(name);
		if (existingUser == null) {
			Log.info("User does not exist.");
			throw new WebApplicationException(Status.NOT_FOUND);
		}
		if (!existingUser.getPwd().equals(pwd)) {
			Log.info("Password is incorrect.");
			throw new WebApplicationException(Status.FORBIDDEN);
		}
		existingUser.setDomain(user.getDomain());
		existingUser.setDisplayName(user.getDisplayName());
		existingUser.setPwd(user.getPwd());
		return existingUser;
	}

	@Override
	public User deleteUser(String name, String pwd) {
		Log.info("deleteUser : user = " + name + "; pwd = " + pwd);
		if (name == null || pwd == null) {
			Log.info("UserId or password null.");
			throw new WebApplicationException(Status.BAD_REQUEST);
		}
		var user = users.get(name);
		if (user == null) {
			Log.info("User does not exist.");
			throw new WebApplicationException(Status.NOT_FOUND);
		}
		if (!user.getPwd().equals(pwd)) {
			Log.info("Password is incorrect.");
			throw new WebApplicationException(Status.FORBIDDEN);
		}
		users.remove(name);
		return user;
	}

	@Override
	public List<User> searchUsers(String pattern) {
		// TODO Auto-generated method stub
		return null;
	}

}

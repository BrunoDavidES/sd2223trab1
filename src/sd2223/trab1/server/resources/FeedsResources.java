package sd2223.trab1.server.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response.Status;
import sd2223.trab1.api.Message;
import sd2223.trab1.api.User;
import sd2223.trab1.api.rest.FeedsService;
import sd2223.trab1.api.rest.UsersService;

public class FeedsResources implements FeedsService {

	// VER MELHOR
	private long messageIdAssigner = 0;
	private final Map<String, Map<Long, Message>> feeds = new HashMap<String, Map<Long, Message>>();
	private final Map<String, List<User>> subscribed = new HashMap<String, List<User>>();
	// ACABAR INICIALIZAÇÃO PRA APONTAR PRA O DOMINIO CERTO
	private final UsersService users = null;
	private static Logger Log = Logger.getLogger(UsersResources.class.getName());

	public FeedsResources() {

	}

	// MAY LEAD TO ERROR
	// VER MELHOR
	@Override
	public long postMessage(String username, String pwd, Message msg) {
		if (username == null || pwd == null || msg == null) {
			Log.info("Null information was given");
			throw new WebApplicationException(Status.BAD_REQUEST);
		}
		try {
			users.getUser(username, pwd);
		} catch (WebApplicationException e) {
			throw new WebApplicationException(Status.FORBIDDEN);
		}
		Message message = new Message(this.messageIdAssigner, username, msg.getDomain(), msg.getText());
		this.messageIdAssigner++;
		if (!feeds.containsKey(username)) {
			Map<Long, Message> messages = new HashMap<Long, Message>();
			messages.put(message.getId(), message);
			feeds.put(username, messages);
		} else {
			feeds.get(username).put(message.getId(), message);
		}
		return msg.getId();

	}

	@Override
	public void removeFromPersonalFeed(String username, long mid, String pwd) {
		if (username == null || pwd == null || mid == -1) {
			Log.info("Null information was given");
			throw new WebApplicationException(Status.BAD_REQUEST);
		}
		try {
			users.getUser(username, pwd);
		} catch (WebApplicationException e) {
			throw new WebApplicationException(Status.FORBIDDEN);
		}
		feeds.get(username).remove(mid);

	}

	@Override
	public Message getMessage(String user, long mid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getMessages(String user, long time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void subUser(String user, String userSub, String pwd) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unsubscribeUser(String user, String userSub, String pwd) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> listSubs(String user) {
		// TODO Auto-generated method stub
		return null;
	}

}

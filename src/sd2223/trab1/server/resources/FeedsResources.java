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

public class FeedsResources implements FeedsService {
	
	//VER MELLHOR
	private final Map<String, List<Message>> feeds = new HashMap<String, List<Message>>();
	private static Logger Log = Logger.getLogger(UsersResources.class.getName());
	
	public FeedsResources() {
		
	}

	@Override
	public long postMessage(String user, String pwd, Message msg) {
//		if(user==null || pwd == null || msg==null) {
//			Log.info("Null information was given");
//			throw new WebApplicationException(Status.BAD_REQUEST);
//		}
//		if(!feeds.containsKey(user)) {
//			Log.info("Null information was given");
//			throw new WebApplicationException(Status.BAD_REQUEST);
//		}
		return 0;
			
	}

	@Override
	public void removeFromPersonalFeed(String user, long mid, String pwd) {
		// TODO Auto-generated method stub
		
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

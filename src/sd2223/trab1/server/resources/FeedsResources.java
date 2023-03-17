package sd2223.trab1.server.resources;

import java.util.List;

import sd2223.trab1.api.Message;
import sd2223.trab1.api.User;
import sd2223.trab1.api.rest.FeedsService;

public class FeedsResources implements FeedsService {

	@Override
	public long postMessage(String user, String pwd, Message msg) {
		// TODO Auto-generated method stub
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
	public List<User> listSubs(String user) {
		// TODO Auto-generated method stub
		return null;
	}

}

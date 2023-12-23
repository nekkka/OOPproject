package users;

import unisystem2023.Request;

public  interface RecieveRequests {

	void completeRequest(Request r);
	
	void declineRequest(Request r);

}

package app;

import jello.model.JelloEntity;
import jello.model.JelloModel;
import jello.annotation.KeyElement;
import jello.rest.IllegalRequestResource;
import jello.annotation.Required;
import jello.security.Accessible;
import jello.ux.Preview;
import jello.ux.Validation;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.Ref;
import com.googlecode.objectify.Key;
import jello.annotation.Expose;
import java.util.List;
import jello.annotation.Association;



@Accessible
public class UserProfile extends JelloEntity {

	private static final long serialVersionUID = -7209712199851313339L;

	@Validation(email=true) @Expose @KeyElement
	public String email_address;

	@Expose @Required
	public String full_name;
	
	@Expose
	public String family_name;

	@Expose
	public String given_name;
	
	@Expose
	public String picture_url;

	@Expose @Preview(element="dateString")
	private List<Ref<UserTimeStamp>> timeStamps;

	@Association(mappedBy="user")
	@Expose
	private List<Player> activeGames;

	
	@Accessible
	public static UserProfile getProfile() throws IllegalRequestResource {
		User currentUser = UserServiceFactory.getUserService().getCurrentUser();
		if(currentUser == null) {
			return null;
		}
		String email = currentUser.getEmail();
		UserProfile newProfile;
		if(JelloModel.isInstanceExist(UserProfile.class, email)) {
			newProfile = (UserProfile) JelloModel.getInstance(UserProfile.class, email);
		}else {
			newProfile = new UserProfile();
			newProfile.email_address = email;
			newProfile.full_name = currentUser.getNickname();
			newProfile.create();
		}
		UserTimeStamp timeStamp = new UserTimeStamp();
		timeStamp.userProfile = (Key<UserProfile>) newProfile.getKey();
		timeStamp.create();
		return newProfile;
	}
}

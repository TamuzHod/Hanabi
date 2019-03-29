package app;

import java.util.Date;

import com.googlecode.objectify.Key;

import jello.annotation.Required;
import jello.model.JelloEntity;
import jello.security.Accessible;
import jello.security.Role;
import jello.ux.Preview;
import jello.annotation.Expose;
import jello.annotation.Final;
import jello.annotation.ReadOnly;

import java.util.function.Function;
import com.googlecode.objectify.Ref;


@Accessible( Role.ALL )
public final class UserTimeStamp extends JelloEntity {

	private static final long serialVersionUID = -7076758809401837909L;

	@Expose @Required @Final @ReadOnly
	public Date timeStamp;

	@Preview(element="email_address") @Expose @Required @Final
	public Key<UserProfile> userProfile;

	@Expose
	private Function<UserTimeStamp, String> dateString = (x) -> {
		UserTimeStamp context = x;
		return context.timeStamp.toString();
	};

	public UserTimeStamp() {
		timeStamp = new Date();
	}
}

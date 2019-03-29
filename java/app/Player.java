package app;

import jello.model.JelloEntity;
import jello.annotation.KeyElement;
import jello.annotation.Required;
import jello.security.Accessible;
import jello.security.Role;
import com.googlecode.objectify.Ref;
import jello.ux.Preview;
import jello.annotation.Expose;
import java.util.function.Function;


@Accessible( Role.ALL )
public class Player extends JelloEntity {

	private static final long serialVersionUID = -5655971567949510190L;

	@Expose
	@Required
	public Ref<GameState> game;

	@Preview(element="email_address")
	@Expose
	@Required
	public Ref<UserProfile> user;

	@Expose @KeyElement
	private Function<Player, String> key = (x) -> {
		Player context = x;
		return context.user + "-" + context.game;
	};
	
	@Expose @Required
	public Card card1;

	@Expose @Required
	public Card card2;

	@Expose @Required
	public Card card3;

	@Expose @Required
	public Card card4;



	
	



}

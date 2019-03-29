package app;

import jello.model.JelloEntity;
import jello.annotation.Required;
import jello.security.Accessible;
import jello.annotation.ReadOnly;
import jello.security.Role;
import jello.annotation.Final;
import jello.annotation.Expose;
import java.util.List;
import jello.annotation.Association;
import java.util.function.Function;



@Accessible( Role.ALL )
public class GameState extends JelloEntity {

	private static final long serialVersionUID = -4698386924604455932L;

	@Expose @Required @Final @ReadOnly
	public Card[] deck;

	@Expose @Required
	public Integer deckPosition;

	@Expose @Required
	public Integer hintsRemaining;

	@Expose @Required
	public Integer livesRemaining;


	@Association(mappedBy="game")
	@Expose
	private List<Player> players;

	@Expose
	private Function<GameState, Integer> numberOfPlayers = (x) -> {
		GameState context = x;
		if(context.players == null)
			return 0;
		return context.players.size();
	};
	
	public GameState() {
		deck = generateRandomDeck();
		this.deckPosition = 0;
		this.hintsRemaining = 8;
		this.livesRemaining = 3;
	}


	@Accessible
	public void generate() {
		for(int i=0; i<players.size(); i++) {
			players.get(i).card1 = deck[i*4];
			players.get(i).card2 = deck[i*4 + 1];
			players.get(i).card3 = deck[i*4 + 2];
			players.get(i).card4 = deck[i*4 + 3];
		}
	}

	
	private Card[] generateRandomDeck() {
		return new Card[54];
	}


}

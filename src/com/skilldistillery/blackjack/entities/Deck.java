package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cards;

	public Deck() {

		cards = new ArrayList<>();

		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {

				Card card = new Card(rank, suit);
				cards.add(card);
			}
		}
	}

	public int checkDeckSize() {
		return this.cards.size();
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public Card dealCard() {
	    if (cards.isEmpty()) {
	        System.out.println("The deck is empty. Unable to deal a card.");
	        return null;
	    }
	    
	    return cards.remove(0);
	}

}

package com.skilldistillery.blackjack.entities;

public class Player {

	private BlackjackHand hand;
	
	public Player() {
		hand = new BlackjackHand();
	}
	
	public void hit(Card card) {
		hand.addCard(card);
	}
	
	public void stand() {
		
	}
	
	public BlackjackHand getHand() {
		return hand;
	}
	
	
}

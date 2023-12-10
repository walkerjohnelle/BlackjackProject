package com.skilldistillery.blackjack.entities;

public enum Suit {
	HEARTS("Hearts", '\u2665'), 
	SPADES("Spades", '\u2660'), 
	CLUBS("Clubs", '\u2663'), 
	DIAMONDS("Diamonds", '\u2666');

	final private String name;
	final private char symbol;

	Suit(String name, char symbol) {
		this.name = name;
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public char getSymbol() {
		return symbol;
	}

	public String toString() {
		return name + " " + symbol;
	}
	
}

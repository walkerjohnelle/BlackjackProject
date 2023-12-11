# BlackjackProject

## Introduction

The Blackjack Game is a text-based implementation of the classic Blackjack card game. It allows players to play against a computerized dealer, following standard Blackjack rules.

## Features

- Player vs. Computerized Dealer gameplay
- Player decisions: Hit, Stand
- Automatic deck shuffling
- Game continues with a new deck when the current deck is almost empty
- Basic hand value calculation

## Getting Started

To run the game locally, you'll need Java installed on your machine.

1. Clone this repository:

   git clone https://github.com/walkerjohnelle/BlackjackProject.git

Compile the Java files:

Copy code
javac com/skilldistillery/blackjack/blackjack/app/BlackjackApplication.java
Run the game:


Copy code
java com.skilldistillery.blackjack.blackjack.app.BlackjackApplication

## How to Play
Launch the game using the instructions in the "Getting Started" section.

Follow the on-screen prompts to make decisions during your turn.

Enjoy playing Blackjack against the computerized dealer!

Game Flow
The game starts with an initial deck shuffle.

Players and the dealer are dealt two cards each.

Players take turns deciding to Hit or Stand.

The dealer takes its turn according to standard Blackjack rules.

The winner of the round is determined.

If the deck is almost empty, players are prompted to play again or exit.

Repeat steps 1-6 for each hand.

## Tech Used

- Java: The core programming language used for the implementation of the game logic.
- Git: Version control system used for tracking changes in the project.
- GitHub: Hosting platform for version-controlled code repositories.

## Lessons Learned

- Object-Oriented Programming (OOP): Gain a deeper understanding of OOP principles through the design of classes such as `Deck`, `Card`, `Player`, `Dealer`, `BlackjackHand`, `Rank`, and `Suit`. This really helped to conceptualize OOP and the various principles needed to accomplish OOP for a functional program. 
- Game Logic Implementation: Learn how to structure and implement game logic, including player turns, dealer behavior, and determining winners. This was made a lot easier by doing the NBA Draft exercise in class. I think without that, I'm not sure if I would've gotten through this homework.
- Console User Interface: Create a simple console-based user interface for interaction with the game.
- Error Handling: Implement error handling for scenarios such as an empty deck or invalid user input.

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class PlayBlackJack
	{
		static ArrayList <Card> deck = new ArrayList <Card>();
		static boolean playerHit, dealerHit, gameContinues, play, bust;
		static String name, dealerName;
		static int playerValue, dealerValue, hitChoice, playChoice;
		public static void main(String[] args)
			{
			greetUser();
			generateDeck();
			while (play)
				{
			gameContinues = true;
			countCards();
			shuffleCards();
			dealCards();
				while (playerHit)
					{
					askForHit();
					if (hitChoice == 1)
						{
						executeHit();
						checkBust();
						}
					if (hitChoice == 2)
						{
						executeStay();
						}
					}
				revealDealerCardTwo();
				checkBust();
				checkDealerHit();
				while (dealerHit)
					{
					executeDealerHit();
					checkDealerHit();
					checkBust();
					}
				executeDealerStay();
				showBust();
				evaluateWinner();
				askForAnotherPlay();
				}
			}
		public static void greetUser()
			{
			Scanner userName = new Scanner(System.in);
			Scanner dealerInput = new Scanner(System.in);
			System.out.println("Hi! What is your name?");
			name = userName.nextLine();
			System.out.println("Hello, " + name + "!");
			System.out.println("What would you like the name of your dealer to be?");
			dealerName = dealerInput.nextLine();
			System.out.println("Today we're going to play the classic card game Black Jack.");
			System.out.println("Aces only count as 11 here, so be careful!");
			play = true;
			}
			public static void generateDeck()
				{
					deck.add(new Card("Spades", "Two", 2));
					deck.add(new Card("Spades", "Three", 3));
					deck.add(new Card("Spades", "Four", 4));
					deck.add(new Card("Spades", "Five", 5));
					deck.add(new Card("Spades", "Six", 6));
					deck.add(new Card("Spades", "Seven", 7));
					deck.add(new Card("Spades", "Eight", 8));
					deck.add(new Card("Spades", "Nine", 9));
					deck.add(new Card("Spades", "Ten", 10));
					deck.add(new Card("Spades", "Jack", 10));
					deck.add(new Card("Spades", "Queen", 10));
					deck.add(new Card("Spades", "King", 10));
					deck.add(new Card("Spades", "Ace", 11));
					deck.add(new Card("Clubs", "Two", 2));
					deck.add(new Card("Clubs", "Three", 3));
					deck.add(new Card("Clubs", "Four", 4));
					deck.add(new Card("Clubs", "Five", 5));
					deck.add(new Card("Clubs", "Six", 6));
					deck.add(new Card("Clubs", "Seven", 7));
					deck.add(new Card("Clubs", "Eight", 8));
					deck.add(new Card("Clubs", "Nine", 9));
					deck.add(new Card("Clubs", "Ten", 10));
					deck.add(new Card("Clubs", "Jack", 10));
					deck.add(new Card("Clubs", "Queen", 10));
					deck.add(new Card("Clubs", "King", 10));
					deck.add(new Card("Clubs", "Ace", 11));
					deck.add(new Card("Hearts", "Two", 2));
					deck.add(new Card("Hearts", "Three", 3));
					deck.add(new Card("Hearts", "Four", 4));
					deck.add(new Card("Hearts", "Five", 5));
					deck.add(new Card("Hearts", "Six", 6));
					deck.add(new Card("Hearts", "Seven", 7));
					deck.add(new Card("Hearts", "Eight", 8));
					deck.add(new Card("Hearts", "Nine", 9));
					deck.add(new Card("Hearts", "Ten", 10));
					deck.add(new Card("Hearts", "Jack", 10));
					deck.add(new Card("Hearts", "Queen", 10));
					deck.add(new Card("Hearts", "King", 10));
					deck.add(new Card("Hearts", "Ace", 11));
					deck.add(new Card("Diamonds", "Two", 2));
					deck.add(new Card("Diamonds", "Three", 3));
					deck.add(new Card("Diamonds", "Four", 4));
					deck.add(new Card("Diamonds", "Five", 5));
					deck.add(new Card("Diamonds", "Six", 6));
					deck.add(new Card("Diamonds", "Seven", 7));
					deck.add(new Card("Diamonds", "Eight", 8));
					deck.add(new Card("Diamonds", "Nine", 9));
					deck.add(new Card("Diamonds", "Ten", 10));
					deck.add(new Card("Diamonds", "Jack", 10));
					deck.add(new Card("Diamonds", "Queen", 10));
					deck.add(new Card("Diamonds", "King", 10));
					deck.add(new Card("Diamonds", "Ace", 11));
		}
		public static void countCards()
		{
		int cardCounter = 0;		
		System.out.println(" ");
		System.out.println("To ensure that I am not cheating, I will now count the number of cards.");
		for (Card n :deck)
			{
			cardCounter++;
			}
		System.out.println(" ");
		System.out.println("There are exactly " + cardCounter + " cards in this deck.");
		}
		public static void shuffleCards()
		{
		Collections.shuffle(deck);
		}
		public static void dealCards()
		{
		System.out.println(" ");
		System.out.println(dealerName + " will now deal out the cards.");
		playerValue = 0;
		dealerValue = 0;
		playerValue = deck.get(0).getValue() + playerValue;
		System.out.println(" ");
		System.out.println("Your first card was the " + deck.get(0).getNumber() + " of " + deck.get(0).getSuit() + ".");
		deck.remove(0);
		dealerValue = deck.get(0).getValue() + dealerValue;
		System.out.println(" ");
		System.out.println(dealerName + "'s first card was the " + deck.get(0).getNumber() + " of " + deck.get(0).getSuit() + ".");
		deck.remove(0);
		playerValue = deck.get(0).getValue() + playerValue;
		System.out.println(" ");
		System.out.println("Your second card was the " + deck.get(0).getNumber() + " of " + deck.get(0).getSuit() + ".");
		deck.remove(0);
		System.out.println(" ");
		System.out.println("You currently have " + playerValue + " points!");
		System.out.println(" ");
		System.out.println("You will now have the opportunity to hit or stay.");
		playerHit = true;
		}
		public static void checkBust()
		{
			if (playerValue > 21)
				{
				playerHit = false;
				dealerHit = false;
				gameContinues = false;
				play = false;
				bust = true;
				}
			else if (dealerValue > 21)
				{
				playerHit = false;
				dealerHit = false;
				gameContinues = false;
				play = false;
				bust = true;
				}
		}
		public static void askForHit()
		{
		Scanner userHit = new Scanner(System.in);
		System.out.println(" ");
		System.out.println("Would you like to hit?");
		System.out.println("(1) Yes, I would like to hit.");
		System.out.println("(2) No, I would not like to hit.");
		hitChoice = userHit.nextInt();
		if (hitChoice == 1)
			{
			playerHit = true;
			}
		else if (hitChoice == 2)
			{
			playerHit = false;
			}
		else
			{
			System.out.println("Please choose either 1 or 2.");
			askForHit();
			}
		}
		public static void executeHit()
		{
		if (playerHit = true)
			{
			System.out.println(" ");
			playerValue = deck.get(0).getValue() + playerValue;
			System.out.println("You drew the " + deck.get(0).getNumber() + " of " + deck.get(0).getSuit() + " from the deck.");
			deck.remove(0);
			System.out.println(" ");
			System.out.println("You currently have " + playerValue + " points!");
			playerHit = true;
			}
		}
		public static void executeStay()
		{
			System.out.println("Okay, you will stay at " + playerValue + ".");
			System.out.println(" ");
		}
		public static void revealDealerCardTwo()
		{
			dealerValue = deck.get(0).getValue() + dealerValue;
			System.out.println(dealerName + "'s second card was the " + deck.get(0).getNumber() + " of " + deck.get(0).getSuit() + ".");
			deck.remove(0);
			System.out.println(" ");
			System.out.println(dealerName + " now has " + dealerValue + " points.");
		}
		public static void checkDealerHit()
		{
			if(dealerValue <= 16)
				{
				dealerHit = true;
				}
			else if (dealerValue >= 17 && dealerValue < 21)
				{
				dealerHit = false;
				}
		}
		public static void executeDealerHit()
		{
		while (gameContinues)
		{
		System.out.println(" ");
		System.out.println("Since " + dealerName + " has " + dealerValue + " points, they will hit.");
		dealerValue = deck.get(0).getValue() + dealerValue;
		System.out.println(" ");
		System.out.println(dealerName + " drew a " + deck.get(0).getNumber() + " of " + deck.get(0).getSuit() + " from the deck.");
		deck.remove(0);
		System.out.println(" ");
		System.out.println(dealerName +  " currently has " + dealerValue + " points!");
		dealerHit = false;
		break;
		}
		}
		public static void executeDealerStay()
		{
			while (gameContinues)
			{
			System.out.println(" ");
			System.out.println("Since " + dealerName + " has " + dealerValue + " points, they will stay.");
			break;
			}
		}
		public static void evaluateWinner()
		{
		while (gameContinues)
		{
		if (playerValue > dealerValue)
			{
			System.out.println(" ");
			System.out.println("Since you are closer to 21 than " + dealerName + ", you win! Congratulations!");
			break;
			}
		else if (playerValue < dealerValue)
			{
			System.out.println(" ");
			System.out.println("Since " + dealerName + " is closer to 21 than you, you lose! Try again!");
			break;
			}
		else
			{
			System.out.println(" ");
			System.out.println("There has been a tie! Please try again!");
			break;
			}
		}
		}
		public static void askForAnotherPlay()
		{
		Scanner userPlay = new Scanner (System.in);
		System.out.println(" ");
		System.out.println("Would you like to play again?");
		System.out.println("(1) Yes!");
		System.out.println("(2) No! (AKA I'm a sore loser and don't want to get beat again.)");
		playChoice = userPlay.nextInt();
		if (playChoice == 1)
			{
			play = true;
			}
		else if (playChoice == 2)
			{
			play = false;
			}
		else
			{
			System.out.println("Please choose either 1 or 2.");
			askForAnotherPlay();
			}
		}
		public static void showBust()
			{
			if (playerValue > 21)
				{
				System.out.println(" ");
				System.out.println("You have busted!");
				System.out.println("You lose! Please try again.");
				}
			else if (dealerValue > 21)
				{
				System.out.println(" ");
				System.out.println(dealerName + " has busted!");
				System.out.println(dealerName + " loses! You win!");
				}
			else if (playerValue > 21 && dealerValue > 21)
				{
				System.out.println(" ");
				System.out.println("You both have busted!");
				System.out.println("Nobody wins! Please try again.");
				}
			}
	}
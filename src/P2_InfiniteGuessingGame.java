/*
	ISYS 320
	Name(s):
	Date: 
*/


import java.util.Random;
import java.util.Scanner;

public class P2_InfiniteGuessingGame {
	
	public static void main(String[] args) {
		int wins = 0;
		int loss = 0;
		int secretNumber = getSecretNumber();
		int numberOfGuessesAllowed = 7;
		//System.out.println("secretNumber : "+secretNumber);
		outputWelcomeMessage();
		
		
		boolean isContinue = true;
		String feedBack = "";
		Scanner input = new Scanner(System.in);
		int totalGuessesTaken = 1;
		int totalGame = 0;
		int sumOfGuess = 0;
		int totalWin = 0 ;
		int totalLoss = 0;
		do{
			int guessesTaken = playGame(secretNumber, numberOfGuessesAllowed);
			boolean hasWon = outputEndingMessage(guessesTaken, numberOfGuessesAllowed, secretNumber);
			totalGuessesTaken = totalGuessesTaken + guessesTaken;
			totalGame ++;
			if(hasWon)
				totalWin = totalLoss + 1;
			else
				totalLoss = totalLoss + 1;
			System.out.println("!!!!! For exit please enter 'quit'  !!!!!!!!");			
			if(input.next().equalsIgnoreCase("quit")){
				isContinue = false;
				System.out.print("Please give your feedback the guessing game is too large or too small : ");
				feedBack = input.nextLine();				
			}
			
		}while(isContinue);
		System.out.println("\nThe secret number was " + secretNumber + ".");
		System.out.println(" feedBack about the guess game is "+feedBack);
		System.out.println("The secret number was " + secretNumber + ".");
		System.out.println("Total guessed token : "+totalGuessesTaken);
		System.out.println("Total number of game played by you : "+totalGame);
		System.out.println("Total number of wins : "+totalGame);
		System.out.println("Total number of losses : "+totalLoss);
		
		
	}

	public static void outputWelcomeMessage() {
		System.out.println("This is a guessing game. Each game will give you seven chances. You can continue the same game until you find the guessed number or you can quit by enter 'quit' at end of the game. ");
		System.out.println("I picked a random number from 1 to 100");
	}

	public static boolean outputEndingMessage(int guessesTaken, int numberOfGuessesAllowed, int secretNumber) {
		boolean flag = false;
		if (guessesTaken < numberOfGuessesAllowed) {
			flag = true;
			System.out.println("Congratuations, you guessed it!");
		} 
		return flag;
		
	}

	public static int getSecretNumber() {
		Random generator = new Random();
		return generator.nextInt(100) + 1;
	}

	public static int getNextGuess() {
		Scanner console = new Scanner(System.in);
		int nextGuess = 0;
		do {
			System.out.println("What is your guess? ");
			if(console.hasNextInt()){
				nextGuess = console.nextInt();
	
				if (nextGuess < 0 || nextGuess > 100) {
					System.out.println("ERROR: Guess should be between 0 and 100");
				}
			} else {
				if(console.next().equals("quit"))
					break;
			}
		} while (nextGuess < 0 || nextGuess > 100);

		return nextGuess;
	}

	public static int playGame(int secretNumber, int allowedGuesses) {
		int numOfGuessesTaken = 0;
		while (numOfGuessesTaken < allowedGuesses) {
			int nextGuess = getNextGuess();

			if (nextGuess == secretNumber) {
				return numOfGuessesTaken;
			} else {
				System.out.println("Nope, guess again. ");
				numOfGuessesTaken++;
			}
		}

		return numOfGuessesTaken;
	}

}

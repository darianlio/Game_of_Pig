/*
 * 			  Name: Darian Lio
 * 			 Title: The Game of Pig
 * 
 * 
 * 		GAME RULES: The rules of the game are:
 * 					1) The first player to accumulate a score of 40 wins.
 * 					2) The human goes first.
 * 					3) After one roll, a player has the choice to "hold" or to roll again.
 * 					4) You roll two dice. Certain conditions apply:
 * 					5) If both dice are ones, then your turn is over and your accumulated score is set to zero (ouch!).
 * 					6) If one dice is one, then your turn is over and your turn score is set to zero.
 * 					7) If both dice match ("doubles") then you must roll again.
 * 					8) For any other dice combination, you just add the dice total to your turn score and you have the choice of rolling again.
 * 					9) When your turn is over, either through your choice or you rolled a one, then your turn sum is added to your accumulated score.
 */

//IMPORTS
import java.util.Scanner;

//CLASS
public class Game_of_Pig {
	
	public static String[] dice = {"zero","one", "two", "three", "four", "five", "six"};	//list of values of the dice

	//GAME FUNCTION
	static void StartGame(){							//Game Function	
		int count = 1;									//counter to track rounds
		
		//Initialize Score
		int score1 = 0;
		int score2 = 0;
		while(true){									//infinite loop until a score is > 40
			System.out.println("Player's turn:");		//player goes first
			score1 = Player(score1);					//roll dice -- see Player method
			System.out.println("Player's sum is: " + score1 + " Computer's sum is: " + score2); //print score
			if(score1 >= 40){							//if player score is >40 exit while loop
				break;
			}	
			System.out.println("Computer's turn:");		//computer goes next
			score2 = Computer(score2);					//roll dice
			count++;									//count round + 1
			System.out.println("Player's sum is: " + score1 + " Computer's sum is: " + score2 + ". Press <enter> to start round " + count); //print round scores and enter next round
			if(score2 >= 40){							//if computer score is >40 exit while loop
				break;
			}		
			Scanner scanner = new Scanner(System.in);	//scan for button press to continue to next round
			scanner.nextLine();
		}
		
		if (score1 >= 40){ 							//if player has 40 or greater points
			System.out.println("******Player wins!******");
		}
		else {				   							//else computer wins
			System.out.println("******Computer wins!******");
		}
	}
	
	//PLAYER METHOD
	static int Player(int score){ 						//Rolling dice function with Scanner
		//Initialize Random Results for Dice
		int res1;		
		int res2;
		while (score < 40){							//while play score < 40
			res1 = (int) (Math.random()*6 + 1);			//roll first dice
			res2 = (int) (Math.random()*6 + 1); 		//roll second dice
			int tsum = 0; 								//declare turn sum
			System.out.println("Player rolled " + dice[res1] + " + " + dice[res2]); //display what player rolled	
			if(res1 == 1 && res2 == 1){ 				//if both dice have a roll of one
				score = 0;								//make player score 0
				tsum = 0;
				System.out.println("TURN OVER!");		//end turn
				break;
			}
			else if (res1 == 1 || res2 == 1){ 			//if one of the dice have a roll of one
				tsum = 0;								//set turn score equal to 0
				System.out.println("TURN OVER! Turn sum is: " + tsum);
				break;									//end turn
			}
			else if (res1 == res2 && (res1 != 1 || res2 != 2)){ //if results are equal and not 1
				score += res1 + res2;					//add results to the score
				tsum = res1 + res2;						//add turn sum
				System.out.println("Player's turn sum is: " + tsum + " and game sum is: " + score +".");
				System.out.println("Player must roll again!");
			}
			else{ 
				score += res1 + res2; 					//add results to score
				tsum = res1 + res2;						//add turn sum
				System.out.println("Player's turn sum is: " + tsum + " and game sum is: " + score +".");		
				if (score < 40) {						//roll again if score < 40
					System.out.println("Roll again? (Enter 'y' or 'n'):"); //ask user if they wish to roll again
					Scanner scanner = new Scanner(System.in); 
					String yn = scanner.nextLine();		//Scan the string: y, n
					if(yn.equals("y")){	 				//if yes
						continue;
					}
					else {								//else end loop
						break;
					}
				}
				else {
					break;
				}
			}
		}
		return score;									//return score to player in game function
	}	
		
	//COMPUTER METHOD
	static int Computer(int score){						//Rolling dice function without scanner
		//Initialization of Random Results of Dice
		int res1;									
		int res2;
		while (score < 40){							//while computer score < 40
			res1 = (int) (Math.random()*6 + 1);			//roll first dice
			res2 = (int) (Math.random()*6 + 1); 		//roll second dice
			int tsum = 0; 								//declare turn sum
			System.out.println("Computer rolled " + dice[res1] + " + " + dice[res2]); //display what computer rolled		
			if(res1 == 1 && res2 == 1){ 				//if both dice have a roll of one
				score = 0;								//make player score 0
				tsum = 0;
				System.out.println("TURN OVER!");		//end turn
				break;
			}
			else if (res1 == 1 || res2 == 1){ 			//if one of the dice have a roll of one
				tsum = 0;								//set turn score equal to 0
				System.out.println("TURN OVER! Turn sum is: " + tsum);
				break;									//end turn
			}
			else if (res1 == res2 && (res1 != 1 || res2 != 1)){ //if results are equal and not 1
				score += res1 + res2;					//add results to the score
				tsum = res1 + res2;						//add turn sum
				System.out.println("Computer's turn sum is: " + tsum + " and game sum is: " + score +".");
				System.out.println("Computer must roll again!"); //reroll
			}
			else{ 
				score += res1 + res2; 					//add results to score
				tsum = res1 + res2;						//add turn sum
				System.out.println("Computer's turn sum is: " + tsum + " and game sum is: " + score +".");
			}
		}
		return score;									//return score to computer in game function
	}

	//MAIN METHOD
	public static void main(String[] args) {
		//GAME START!
		StartGame();									//START GAME FUNCTION
	}
}

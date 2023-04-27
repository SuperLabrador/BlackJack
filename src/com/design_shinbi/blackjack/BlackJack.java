package com.design_shinbi.blackjack;

import java.util.Scanner;

public class BlackJack {
	
	public static final int ACTION_YES = 1;
	public static final int ACTION_NO = 2;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		start(scanner);			
		scanner.close();
	}
	
	public static void start(Scanner scanner) {
		
		Player player = new Player(scanner);
		Dealer dealer = new Dealer();
		Stock stock = new Stock();

		boolean restart = true;
		while(restart) {
			player.initialize();
			dealer.initialize();
			stock.initialize();
			
			if(checkCoin(player)) { break; }

			player.betCoin(scanner);
			
			player.start(stock);
			dealer.start(stock);
			dealer.display();;
			
			player.play(stock);
			dealer.play(stock);
			
			player.addCoin(showResult(dealer, player));
			
			dealer.display();
			player.display();
			
			if(checkCoin(player)) { break; }
			
			restart = askReplay(scanner);
			
		}
		System.out.println("Good Bye...");
	
	}
	
	public static int showResult(Dealer dealer, Player player) {
		int dealerStrength = dealer.calculateStrength();
		int playerStrength = player.calculateStrength();
		
		if (dealerStrength < playerStrength) {
			System.out.println("Win!");
			return 1;
		} else if (dealerStrength == playerStrength){
			System.out.println("Draw");
			return 0;
		}
		System.out.println("Lose...");
		return -1;
	}
	
	public static boolean askReplay(Scanner scanner) {
		System.out.printf("\nもう一度遊びますか？\n");
		System.out.printf("[%d] Yes, [%d] No\n", ACTION_YES, ACTION_NO);
		
		int action = 0;
		while(action != ACTION_YES && action != ACTION_NO) {
			String input = scanner.nextLine();
			try {
				action = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("選択肢から数字で選択してください");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return action == ACTION_YES ? true : false;
	}	

	public static boolean checkCoin(Player player) {
		if (player.getCoin() > 0) {
			return false;
		} else {
			System.out.println("コインがありません");
			return true;
		}
	}
	
}

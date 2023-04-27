package com.design_shinbi.blackjack;

import java.util.Scanner;

public class Player extends Attender {
	public static final int ACTION_HIT = 1;
	public static final int ACTION_STAND = 2;
	
	private Scanner scanner;
	
	private int coin;
	private int bet;
		
	public Player(Scanner scanner) {
		super("You");
		this.coin = 10;
		this.scanner = scanner;
	}
	
	public int getCoin() {
		return this.coin;
	}
	
	public int getBet() {
		return this.bet;
	}
	
	public void addCoin(int result) {
		if (result > 0) {
			System.out.printf("＋%dコイン\n", getBet() * 2);
			this.coin += getBet() * 2;
		} else if (result == 0){
			System.out.printf("＋%dコイン\n", getBet());
			this.coin += getBet();
		}
	}
			
	@Override
	public int calculateStrength() {
		int strength = super.calculateStrength();
		return strength == 0 ? -1 : strength;
	}
	
	@Override
	public void display() {
		System.out.println(this.toString());
		int strength = calculateStrength();
		System.out.printf("あなたの手札は %d です\n",strength);
	}

	@Override
	public void play(Stock stock) {
		boolean standing = false;
		while(!standing) {
			this.display();
			int action = selectAction();
			if(action == ACTION_HIT) {
				this.hit(stock);
				int strength = this.calculateStrength();
				if(strength <= 0) {
					standing = true;
				}
			}
			else {
				standing = true;
			}
		}
	}

	public int selectAction() {
		String selectMessage = String.format("[%d] Hit (カードを引く), [%d] STAND (勝負する)", ACTION_HIT, ACTION_STAND);
		System.out.println(selectMessage);
		
		int action = 0;
		while(action != ACTION_HIT && action != ACTION_STAND) {
			String input = this.scanner.nextLine();
			try {
				action = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("選択肢から数字で選択してください");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return action;
	}
	
	public void betCoin(Scanner scanner) {
		System.out.println("賭けるコインを決めてください");
		System.out.printf("手持ちコイン: %d\n", getCoin());
		
		bet = 0;
		while (bet <= 0) {
			String input = scanner.nextLine();
			try {
				bet = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("数字で入力してください");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(bet <= getCoin()) {
				this.coin -= bet;
			}else if(bet > getCoin()) {
				System.out.println("コインが足りません");
				bet = 0;
			}
		}
		
		System.out.println();
		
	}
	
}

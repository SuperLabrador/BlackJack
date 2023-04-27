package com.design_shinbi.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Attender {
	protected List<Card> hand;
	protected String name;
	
	public Attender(String name) {
		this.name = name;
		initialize();
	}
	
	public void initialize() {
		this.hand = new ArrayList<Card>();
	}
	
	public void start(Stock stock) {
		this.hand.clear();
		for(int i = 0; i < 2; i++) {
			this.hand.add(stock.pickCard());
		}
	}

	public String getName() {
		return name;
	}
	
	public void hit(Stock stock) {
		this.hand.add(stock.pickCard());
	}
	
	public static int calculateStrengthFromList(List<Card> list) {
		int strength = 0;
		int ace = 0;
			for (Card card : list) {
				int number = card.getNumber();
				if (number == 1) {
					ace++;
					strength += 11;
				} else if(number > 10) {
					strength += 10;
				} else {
					strength += number;
				}
				
				if (strength > 21 && ace > 0) {
					ace--;
					strength -= 10;
				}
				
//				if (strength > 21) {
//					break;
//				}
			}
		return strength < 22 ? strength : 0;
	}
	
	public int calculateStrength() {
		int strength = calculateStrengthFromList(this.hand);
		return strength;
	}
	
	public String toString() {
		String string = this.name + ": ";
		for(int i = 0; i < this.hand.size(); i++) {
			Card card = this.hand.get(i);
			string += card.toString();
		}
		return string;
	}
	
	public void display() {
		System.out.println(this.toString());
	}
	
	public abstract void play(Stock stock);
	
	public static void sortHand(List<Card> hand) {
		Collections.sort(hand);
		System.out.println(hand);
	}
}

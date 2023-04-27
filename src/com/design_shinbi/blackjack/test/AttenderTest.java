package com.design_shinbi.blackjack.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.design_shinbi.blackjack.Attender;
import com.design_shinbi.blackjack.Card;
import com.design_shinbi.blackjack.Suit;

class AttenderTest {

	@Test
	void test() {
		List<Card> hand = new ArrayList<>();
		
		hand.add(new Card(Suit.SPADE, 7));
		hand.add(new Card(Suit.HEART, 1));
		hand.add(new Card(Suit.DIAMOND, 12));
		hand.add(new Card(Suit.CLUB, 1));
		hand.add(new Card(Suit.DIAMOND, 13));
		
		int[] strengthArray = {7, 18, 18, 19, 0};
		
		for(int i = 0; i < hand.size(); i++) {
			List<Card> subList = hand.subList(0, i + 1);
			int strength = Attender.calculateStrengthFromList(subList);
			
			System.out.println("Cards: " + subList);
			System.out.println("Strength: " + strength);
			
			if (strength != strengthArray[i]) {
				fail("値が違います");
			}
		}
		
		Attender.sortHand(hand);
	}

}

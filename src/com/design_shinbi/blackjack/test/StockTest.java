package com.design_shinbi.blackjack.test;

import org.junit.jupiter.api.Test;

import com.design_shinbi.blackjack.Stock;

class StockTest {

	@Test
	void test() {
		Stock stock = new Stock();
		int count = 0;
		while(stock.getNumberOfCards() > 0) {
			System.out.println(++count);
			System.out.println(stock.pickCard());
		}
	}

}

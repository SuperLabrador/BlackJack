package com.design_shinbi.blackjack;

import java.util.Collections;
import java.util.List;

/**
 * 山札の管理クラス
 */
public class Stock {
	private List<Card> cards;
	
	/**
	 * コンストラクター
	 * インスタンス化したらすぐにinitialize()を行う。
	 */
	public Stock() {
		initialize();
	}
	
	/**
	 * 52枚のカードをシャッフルした状態にして山札とする。
	 */
	public void initialize() {
		List<Card> list = Card.getAllCards();
		Collections.shuffle(list);
		this.cards = list;
	}
	
	/**
	 * 山札の枚数を取得する。
	 * @return 山札の枚数
	 */
	public int getNumberOfCards() {
		return this.cards.size();
	}
	
	/**
	 * 山札から一枚カードを引く。
	 * @return 山札に入っていたカード一枚
	 */
	public Card pickCard() {
		return this.cards.remove(0);
	}
}

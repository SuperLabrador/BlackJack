package com.design_shinbi.blackjack;

/**
 * スート管理列挙型
 */
public enum Suit {
	/**
	 * スート4種。並び方が変わるとソートのルールも変更される。
	 */
	SPADE("スペード"),
	HEART("ハート"),
	DIAMOND("ダイヤ"),
	CLUB("クラブ");
	
	private final int PRIME = 13;
	
	private String name;
	
	private Suit(String name) {
		this.name = name;
	}
	
	/**
	 * スートの大小関係を表すための数値を返す。
	 * PRIMEが13の場合、
	 * スペード -> 0, ハート -> 13, ダイヤ -> 26, クラブ -> 39
	 * @return スートの数値
	 */
	public int getSortNumber() {
		return this.ordinal() * PRIME;
	}
	
	/**
	 * スートの名前を取得する。
	 * @return スートの名前
	 */
	public String getName() {
		return this.name;
	}
}

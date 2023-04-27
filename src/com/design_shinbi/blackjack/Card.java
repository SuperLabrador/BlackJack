package com.design_shinbi.blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * カード管理クラス
 */
public class Card implements Comparable<Card>{
	private Suit suit;
	private int number;

	/**
	 * コンストラクター
	 * @param suit スート
	 * @param number 数字
	 */
	public Card(Suit suit, int number) {
		this.suit = suit;
		this.number = number;
	}

	/**
	 * カードのスートを取得する。
	 * @return カードのスート
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * カードの数字を取得する。
	 * @return カードの数字
	 */
	public int getNumber() {
		return number;
	}
	
	/**
	 * スートを考慮してカードの大きさを取得する。主にカードのソート用。
	 * スペード < ハート < ダイヤ < クラブ という大小関係になっている。
	 * @return スートを考慮したカードの大きさ
	 */
	public int getSortNumber() {
		return this.getNumber() + this.getSuit().getSortNumber();
	}
	
	/**
	 * 数字からカードに書かれている文字列を取得する。
	 * (例: 1 -> A, 2 -> 2, ... 11 -> J, 12 -> Q, 13 -> K)
	 * @param number 数字
	 * @return 数字の文字列
	 */
	public static String getNumberString(int number) {
		String string = null;
		if (number == 13) {
			string = "K";
		}else if(number == 12) {
			string = "Q";
		}else if(number == 11) {
			string = "J";
		}else if(number == 1) {
			string = "A";
		}else if(number >= 2 && number <= 10){
			string = Integer.toString(number);
		}
		return string;
	}
	
	/**
	 * カードの数字とスートを合わせた文字列を取得する。
	 */
	@Override
	public String toString() {
		return String.format("[%s%s]", this.suit.getName(), getNumberString(this.number));
//		return String.format("[%s%s:%d]", this.suit.getName(), getNumberString(this.number), this.getSortNumber());
	}
	
	/**
	 * 52枚すべてのカードを取得する。
	 * @return 52枚のカードのリスト
	 */
	public static List<Card> getAllCards(){
		List<Card> list = new ArrayList<>();
		for(Suit suit : Suit.values()) {
			for(int i = 1; i <= 13; i++) {
				list.add(new Card(suit, i));
			}
		}
		return list;
	}

	/**
	 * ソート用の比較ルール
	 * @param 比較対象のカード
	 * @return 対象が自身より小さければ1。自身より大きければ-1。同じ大きさなら0。
	 */
	@Override
	public int compareTo(Card card) {
		int n = this.getSortNumber();
		int m = card.getSortNumber();
		
		if (n > m) {
			return 1;			
		} else if ( n == m) {
			return 0;
		}
		return -1;
	}
}

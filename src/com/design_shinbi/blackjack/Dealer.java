package com.design_shinbi.blackjack;

public class Dealer extends Attender {
	private boolean opened;
	
	public Dealer() {
		super("Computer");
	}
	
	@Override
	public void start(Stock stock) {
		super.start(stock);
		this.opened = false;
	}

	@Override
	public String toString() {
		String string = "";
		if (this.opened) {
			string = super.toString();
		}
		else {
			string = this.name + ": ";
			for (int i = 0; i < this.hand.size(); i++) {
				Card card = this.hand.get(i);
				if (i == 0) {
					string += card.toString();
				}
				else {
					string = string + "[#####]";
				}
			}
		}
		return string;
	}

	@Override
	public void play(Stock stock) {
		int strength = this.calculateStrength();
		while (strength < 17 && strength > 0) {
			this.hit(stock);
			strength = this.calculateStrength();
		}
		this.opened = true;
	}

}

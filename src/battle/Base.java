package battle;

import exceptions.InvalidDataException;
import exceptions.InvalidNameException;

public class Base {

	public int STARTING_MONEY = 1000;
	private int currentMoney = STARTING_MONEY;
	public String Name;
	private Division[] divisions = new Division[5];
	private int[] UNIT_PRICE = { 0, 10, 7, 15, 25 };

	public Base(String Name) {

		this.Name = Name;
		divisions[1] = new Division(1, 0);
		divisions[2] = new Division(2, 0);
		divisions[3] = new Division(3, 0);
		divisions[4] = new Division(4, 0);
	}

	public int getCurrentMoney() {
		return currentMoney;
	}

	public void setCurrentMoney(int currentMoney) {
		this.currentMoney = currentMoney;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) throws InvalidNameException {
		if (name.length() > 0)
			this.Name = name;
		else
			throw new InvalidNameException("You must have a name!");
	}

	public Division getDivisions(int type) {
		return this.divisions[type];
	}

	public void buySoldier(int type) {
		if (currentMoney > UNIT_PRICE[type])
			if (divisions[type].addSoldier())
				currentMoney -= UNIT_PRICE[type];

	}

	public void sellSoldier(int type) {
		if (currentMoney < STARTING_MONEY)
			if (divisions[type].killSoldier())
				currentMoney += UNIT_PRICE[type];
	}

	public void checkSoldiers() throws InvalidDataException {
		if (divisions[1].isDead() && divisions[2].isDead() && divisions[3].isDead() && divisions[4].isDead())
			throw new InvalidDataException("You must have soldiers to play!");
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		return stringBuilder.append("\nBase details: ").append("name = ").append(Name).append(", current money = ")
				.append(currentMoney).append(divisions[1].toString()).append(divisions[2].toString())
				.append(divisions[3].toString()).append(divisions[4].toString()).append("\n").toString();
	}

	/*
	 * public class InvalidNameException extends Exception {
	 * 
	 * private static final long serialVersionUID = 1L;
	 * 
	 * public InvalidNameException() { }
	 * 
	 * public InvalidNameException(String msg) { super(msg); } }
	 */

}
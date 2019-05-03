package battle;

public class Division {

	private int type;
	private int MAX_NR_OF_SOLDIERS;
	private int currentNrOfSoldiers;
	private int UNIT_HP;
	private double totalHP;
	private int UNIT_STRENGTH;
	private double totalStrength;
	private boolean dead;

	public Division(Division d) {
		this.type = d.type;
		this.currentNrOfSoldiers = d.currentNrOfSoldiers;
		this.dead = d.dead;
		this.MAX_NR_OF_SOLDIERS = d.MAX_NR_OF_SOLDIERS;
		this.totalHP = d.totalHP;
		this.totalStrength = d.totalStrength;
		this.UNIT_HP = d.UNIT_HP;
		this.UNIT_STRENGTH = d.UNIT_STRENGTH;
	}
	public Division(int type, int currentNrOfSoldiers) {
		this.type = type;
		switch(type)
		{
		case 1:
			MAX_NR_OF_SOLDIERS = 40;// ARCHERS
					UNIT_HP = 50;
					UNIT_STRENGTH = 20;

				break;
		case 2:
			MAX_NR_OF_SOLDIERS = 50;// FOOTSOLDIER
					UNIT_HP = 100;
					UNIT_STRENGTH = 12;

				break;
		case 3:
			MAX_NR_OF_SOLDIERS = 25;// CAVALRY
					UNIT_HP = 200;
					UNIT_STRENGTH = 15;

				break;
		case 4:
			MAX_NR_OF_SOLDIERS = 10;// TREBUCHET , HECK CATAPULTS
					UNIT_HP = 250;
					UNIT_STRENGTH = 25;

				break;	
		}
		if(currentNrOfSoldiers <= MAX_NR_OF_SOLDIERS)
			this.currentNrOfSoldiers = currentNrOfSoldiers;
		this.totalHP = UNIT_HP * currentNrOfSoldiers;
		this.totalStrength = UNIT_STRENGTH * currentNrOfSoldiers;
		if (currentNrOfSoldiers > 0)
			this.dead = false;
		else
			this.dead = true;
	}

	public int getType() {
		return type;
	}

	public int getUNIT_HP() {
		return UNIT_HP;
	}

	public int getCurrentNrOfSoldiers() {
		return currentNrOfSoldiers;
	}

	public void setCurrentNrOfSoldiers(int currentNrOfSoldiers) {
		if (currentNrOfSoldiers > MAX_NR_OF_SOLDIERS)
			this.currentNrOfSoldiers = MAX_NR_OF_SOLDIERS;
		else
		{
			if (currentNrOfSoldiers < 0)
				this.currentNrOfSoldiers = 0;
			else
				this.currentNrOfSoldiers = currentNrOfSoldiers;

		}
		this.totalHP = this.UNIT_HP * this.currentNrOfSoldiers;
		this.totalStrength = this.UNIT_STRENGTH * this.currentNrOfSoldiers;
		if (this.currentNrOfSoldiers > 0)
			this.dead = false;
		else
			this.dead = true;
	}

	public boolean addSoldier() {
		if (this.currentNrOfSoldiers < MAX_NR_OF_SOLDIERS) {
			this.currentNrOfSoldiers++;
			this.totalHP += this.UNIT_HP;
			this.totalStrength += this.UNIT_STRENGTH;
			this.dead = false;
			return true;
		}
		return false;
	}

	public boolean killSoldier() {
		if (this.dead == false) {
			this.currentNrOfSoldiers--;
			this.totalHP -= this.UNIT_HP;
			this.totalStrength -= this.UNIT_STRENGTH;
			if (this.currentNrOfSoldiers == 0)
				this.dead = true;

			return true;
		}
		return false;
	}

	public double getTotalHP() {
		return totalHP;
	}

	public double getTotalStrength() {
		return totalStrength;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public void reset() {
		this.type = 0;
		setCurrentNrOfSoldiers(0);
		this.dead = true;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		return stringBuilder.append("\nDivision details: ").append("type = ").append(type).append(", nrOfSoldiers = ")
				.append(currentNrOfSoldiers).append(", total HP = ").append(totalHP).append(", total strength = ")
				.append(totalStrength).append(", dead =").append(dead)
				.append("\n").toString();
	}

}
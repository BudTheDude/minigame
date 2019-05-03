package battle;

public class Battlefield {

	public Base[] player = new Base[3];
	public Division[][] place;


	public Battlefield() {
		this.player[1] = new Base("Player1");
		this.player[2] = new Base("Player2");
		this.place = new Division[3][5];
		place[1][1] = new Division(0, 0);
		place[1][2] = new Division(0, 0);
		place[1][3] = new Division(0, 0);
		place[1][4] = new Division(0, 0);
		place[2][1] = new Division(0, 0);
		place[2][2] = new Division(0, 0);
		place[2][3] = new Division(0, 0);
		place[2][4] = new Division(0, 0);
	}

	public Base getPlayer(int pl) {
		return player[pl];
	}

	public void setPlayer(Base[] player) {
		this.player = player;
	}

	public Division getPlace(int i, int j) {
		return place[i][j];
	}

	public void setPlace(Division[][] place) {
		this.place = place;
	}

	public boolean sendToBattle(int pl, int type, int nrOfSoldiers, int location)
	{
		if (!this.player[pl].getDivisions(type).isDead() && place[pl][location].isDead()) {
			place[pl][location] = new Division(this.player[pl].getDivisions(type));
			place[pl][location].setCurrentNrOfSoldiers(nrOfSoldiers);
			this.player[pl].getDivisions(type)
					.setCurrentNrOfSoldiers(this.player[pl].getDivisions(type).getCurrentNrOfSoldiers() - nrOfSoldiers);
			return true;
		}
			return false;
	}

	public void attack(Division d1, Division d2, int location) {
		boolean[][] weakness = new boolean[5][5];
		weakness[1][4] = true; // archers have a weakness for trebuchets
		weakness[2][4] = true; // footsoldiers have a weakness for trebuchets
		weakness[3][4] = true; // cavalry have a weakness for trebuchets
		weakness[4][4] = true; // trebuchets have a weakness for trebuchets
		weakness[2][1] = true; // footsoldiers have a weakness for archers
		weakness[1][3] = true; // archers have a weakness for cavalry

		double damage1 = 0;
		double damage2 = 0;
		damage1 = d1.getTotalStrength() * 10;
		damage2 = d2.getTotalStrength() * 10;
		if (weakness[d1.getType()][d2.getType()])
			damage2 += damage2 * 0.2;
		if (weakness[d2.getType()][d1.getType()])
			damage1 += damage1 * 0.2;
		if (!d1.isDead() && !d2.isDead()) {
			for (int i = d1.getUNIT_HP(); i <= damage2; i += d1.getUNIT_HP())
				d1.killSoldier();
			for (int i = d2.getUNIT_HP(); i <= damage1; i += d2.getUNIT_HP())
				d2.killSoldier();
		} else {
			if (!d2.isDead() && d1.isDead()) {
				for (int i = player[1].getDivisions(location).getUNIT_HP(); i <= damage2; i += player[1]
						.getDivisions(location).getUNIT_HP())
					player[1].getDivisions(location).killSoldier();
			}
			if (!d1.isDead() && d2.isDead()) {
				for (int i = player[2].getDivisions(location).getUNIT_HP(); i <= damage1; i += player[2]
						.getDivisions(location).getUNIT_HP())
					player[2].getDivisions(location).killSoldier();
			}

		}
	}

	public void battle() {
		for (int i = 1; i < 5; i++) {
			attack(place[1][i], place[2][i], i);
		}
	}

	public void returnFromBattle()
	{
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j < 5; j++) {
				if (!place[i][j].isDead()) {
					player[i].getDivisions(place[i][j].getType()).setCurrentNrOfSoldiers(
							player[i].getDivisions(place[i][j].getType()).getCurrentNrOfSoldiers()
									+ place[i][j].getCurrentNrOfSoldiers());
					place[i][j].reset();
				}
			}
		}
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j < 5; j++) {
				place[i][j].reset();

			}
		}
	}

	public int endGame() {
		for (int i = 1; i <= 2; i++)
			if (player[i].getDivisions(1).isDead() && player[i].getDivisions(2).isDead()
					&& player[i].getDivisions(3).isDead() && player[i].getDivisions(4).isDead())
				return i;
		return 0;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		return stringBuilder.append("\nBattlefield details: ").append("\n Player 1 ").append(player[1].toString())
				.append("\n Active zone\n ").append(place[1][1].toString()).append(place[1][2].toString())
				.append(place[1][3].toString()).append(place[1][4].toString()).append(place[2][1].toString())
				.append(place[2][2].toString()).append(place[2][3].toString()).append(place[2][4].toString())
				.append("\n Player 2 ").append(player[2].toString()).append("\n").toString();
	}

}
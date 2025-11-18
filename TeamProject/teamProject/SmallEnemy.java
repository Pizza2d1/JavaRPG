package teamProject;
/**
 * SmallEnemy class that divides into Rat, Spider, and Wolf.
 */
public abstract class SmallEnemy extends Enemy{
	private static int count;
	
	protected SmallEnemy(int hp, int def, int att, int move) {
		super(hp, def, att, move);
		if(count < 10) {
			count++;
		}
	}
	
	public int getCount() {
		return count;
	}
}

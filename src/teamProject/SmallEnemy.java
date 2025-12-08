package teamProject;
/**
 * SmallEnemy class that divides into Rat, Spider, and Wolf.
 */
public abstract class SmallEnemy extends Enemy{
	private static int count;
	
	protected SmallEnemy(int hp, int def, int att, int move, boolean resFire, boolean resIce) {
		super(hp, def, att, move, resFire, resIce);
		if(count < 10) {
			count++;
		}
	}
	
	public int getCount() {
		return count;
	}
}

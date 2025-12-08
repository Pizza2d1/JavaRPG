package teamProject;
/**
 * MediumEnemy class that divides into Skeleton, Soldier, and Vampire.
 */
public abstract class MediumEnemy extends Enemy{
	private static int count;
	
	protected MediumEnemy(int hp, int def, int att, int move, boolean resFire, boolean resIce) {
		super(hp, def, att, move, resFire, resIce);
		if(count < 10) {
			count++;
		}
	}
}

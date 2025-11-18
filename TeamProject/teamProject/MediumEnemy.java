package teamProject;
/**
 * MediumEnemy class that divides into Skeleton, Soldier, and Vampire.
 */
public abstract class MediumEnemy extends Enemy{
	private static int count;
	
	protected MediumEnemy(int hp, int def, int att, int move) {
		super(hp, def, att, move);
		if(count < 10) {
			count++;
		}
	}
}

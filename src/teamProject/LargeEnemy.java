package teamProject;
/**
 * LargeEnemy class that divides into Ogre, Werewolf, and Dragon.
 */
public abstract class LargeEnemy extends Enemy{
	private static int count;
	
	protected LargeEnemy(int hp, int def, int att, int move, boolean resFire, boolean resIce) {
		super(hp, def, att, move, resFire, resIce);
		if(count < 10) {
			count++;
		}
	}
}

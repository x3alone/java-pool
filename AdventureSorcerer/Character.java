import java.util.ArrayList;
import java.util.List;

public class Character {
    private final int maxHealth;
    protected int currentHealth;
    private final String name;

    private static final List<Character> allCharacters = new ArrayList<>();

    public Character(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        allCharacters.add(this);
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public String getName() {
        return name;
    }

    public void takeDamage(int amount) {
        currentHealth -= amount;
        if (currentHealth < 0) currentHealth = 0;
    }

    public void attack(Character target) {
        target.takeDamage(9);
    }

    @Override
    public String toString() {
        if (currentHealth == 0) return name + " : KO";
        return name + " : " + currentHealth + "/" + maxHealth;
    }

    public static String printStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------------------------------------\n");
        if (allCharacters.isEmpty()) {
            sb.append("Nobody's fighting right now !\n");
        } else {
            sb.append("Characters currently fighting :\n");
            for (Character c : allCharacters) {
                sb.append(" - ").append(c.toString()).append("\n");
            }
        }
        sb.append("------------------------------------------\n");
        return sb.toString();
    }

    public static Character fight(Character c1, Character c2) {
        while (c1.getCurrentHealth() > 0 && c2.getCurrentHealth() > 0) {
            c1.attack(c2);
            if (c2.getCurrentHealth() == 0) return c1;
            c2.attack(c1);
            if (c1.getCurrentHealth() == 0) return c2;
        }
        return null;
    }
}

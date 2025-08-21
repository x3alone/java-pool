import java.util.ArrayList;
import java.util.List;

public abstract class Character {

    private final int maxHealth;
    private int currentHealth;
    private final String name;
    private final Weapon weapon;

    private static List<Character> allCharacters = new ArrayList<>();

    public Character(String name, int maxHealth, Weapon weapon) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.weapon = weapon;
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

    public Weapon getWeapon() {
        return weapon;
    }

    protected void setCurrentHealth(int health) {
        if (health < 0) {
            this.currentHealth = 0;
        } else if (health > maxHealth) {
            this.currentHealth = maxHealth;
        } else {
            this.currentHealth = health;
        }
    }

    public abstract void takeDamage(int damage) throws DeadCharacterException;

    public abstract void attack(Character other) throws DeadCharacterException;

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
            try {
                c1.attack(c2);
            } catch (DeadCharacterException ignored) {}

            if (c2.getCurrentHealth() == 0) return c1;

            try {
                c2.attack(c1);
            } catch (DeadCharacterException ignored) {}

            if (c1.getCurrentHealth() == 0) return c2;
        }
        return null;
    }
}

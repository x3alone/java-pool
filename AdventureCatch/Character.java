import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private final String name;
    private final int maxHealth;
    private int currentHealth;
    private final Weapon weapon;

    private static final List<Character> allCharacters = new ArrayList<>();

    public Character(String name, int maxHealth, Weapon weapon) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.weapon = weapon;
        allCharacters.add(this);
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    protected void setCurrentHealth(int health) {
        if (health < 0) this.currentHealth = 0;
        else if (health > maxHealth) this.currentHealth = maxHealth;
        else this.currentHealth = health;
    }

    public Weapon getWeapon() {
        return weapon;
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
            try { c1.attack(c2); } catch (DeadCharacterException e) {}
            if (c2.getCurrentHealth() == 0) return c1;
            try { c2.attack(c1); } catch (DeadCharacterException e) {}
            if (c1.getCurrentHealth() == 0) return c2;
        }
        return null;
    }

    public abstract void attack(Character target) throws DeadCharacterException;

    public abstract void takeDamage(int damage) throws DeadCharacterException;

    @Override
    public String toString() {
        if (currentHealth == 0) return name + " : KO";
        return name + " : " + currentHealth + "/" + maxHealth;
    }
}

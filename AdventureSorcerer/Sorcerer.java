public class Sorcerer extends Character implements Healer {

    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public void heal(Character target) {
        int newHealth = target.getCurrentHealth() + healCapacity;
        if (newHealth > target.getMaxHealth()) {
            newHealth = target.getMaxHealth();
        }
        target.currentHealth = newHealth;
    }

    @Override
    public String toString() {
        if (currentHealth == 0) {
            return getName() + " is a dead sorcerer. So bad, it could heal " + healCapacity + " HP.";
        } else {
            return getName() + " is a sorcerer with " + currentHealth + " HP. It can heal " + healCapacity + " HP.";
        }
    }
}

public class Templar extends Character implements Healer, Tank {

    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public void heal(Character target) {
        if (target.getCurrentHealth() == 0) return;
        int newHealth = target.getCurrentHealth() + healCapacity;
        target.setCurrentHealth(newHealth);
    }

    @Override
    public int getShield() {
        return shield;
    }

    @Override
    public void attack(Character other) {
        this.heal(this);
        other.takeDamage(6);
    }

    @Override
    public void takeDamage(int damage) {
        int netDamage = damage - shield;
        if (netDamage < 0) netDamage = 0;
        setCurrentHealth(getCurrentHealth() - netDamage);
    }

    @Override
    public String toString() {
        if (getCurrentHealth() == 0) {
            return getName() + " has been beaten, even with its " + shield +
                   " shield. So bad, it could heal " + healCapacity + " HP.";
        }
        return getName() + " is a strong Templar with " + getCurrentHealth() +
               " HP. It can heal " + healCapacity + " HP and has a shield of " + shield + ".";
    }
}

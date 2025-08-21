public class Templar extends Character implements Healer, Tank {

    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield, Weapon weapon) {
        super(name, maxHealth, weapon);
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
        target.setCurrentHealth(target.getCurrentHealth() + healCapacity);
    }

    @Override
    public int getShield() {
        return shield;
    }

    @Override
    public void attack(Character other) {
        this.heal(this);
        int damage = (getWeapon() != null) ? getWeapon().getDamage() : 6;
        other.takeDamage(damage);
    }

    @Override
    public void takeDamage(int dmg) {
        int actualDamage = Math.max(0, dmg - shield);
        setCurrentHealth(getCurrentHealth() - actualDamage);
    }

    @Override
    public String toString() {
        String s = (getCurrentHealth() == 0)
                ? getName() + " has been beaten, even with its " + shield + " shield. So bad, it could heal " + healCapacity + " HP."
                : getName() + " is a strong Templar with " + getCurrentHealth() + " HP. It can heal " + healCapacity + " HP and has a shield of " + shield + ".";
        if (getWeapon() != null) s += " He has the weapon " + getWeapon().toString();
        return s;
    }
}

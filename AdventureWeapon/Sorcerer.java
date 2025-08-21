public class Sorcerer extends Character implements Healer {

    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
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
    public void attack(Character other) {
        this.heal(this);
        int damage = (getWeapon() != null) ? getWeapon().getDamage() : 10;
        other.takeDamage(damage);
    }

    @Override
    public void takeDamage(int damage) {
        setCurrentHealth(getCurrentHealth() - damage);
    }

    @Override
    public String toString() {
        String s = (getCurrentHealth() == 0)
                ? getName() + " is a dead sorcerer. So bad, it could heal " + healCapacity + " HP."
                : getName() + " is a sorcerer with " + getCurrentHealth() + " HP. It can heal " + healCapacity + " HP.";
        if (getWeapon() != null) s += " He has the weapon " + getWeapon().toString();
        return s;
    }
}

public class Monster extends Character {

    public Monster(String name, int maxHealth, Weapon weapon) {
        super(name, maxHealth, weapon);
    }

    @Override
    public void attack(Character other) {
        int damage = (getWeapon() != null) ? getWeapon().getDamage() : 7;
        other.takeDamage(damage);
    }

    @Override
    public void takeDamage(int damage) {
        int reduced = (int) Math.floor(damage * 0.8);
        setCurrentHealth(getCurrentHealth() - reduced);
    }

    @Override
    public String toString() {
        String s = (getCurrentHealth() == 0)
                ? getName() + " is a monster and is dead"
                : getName() + " is a monster with " + getCurrentHealth() + " HP.";
        if (getWeapon() != null) s += " He has the weapon " + getWeapon().toString();
        return s;
    }
}

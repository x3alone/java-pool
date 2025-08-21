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
    public int getShield() {
        return shield;
    }

    @Override
    public void heal(Character target) throws DeadCharacterException {
        if (getCurrentHealth() == 0) throw new DeadCharacterException(this);
        if (target.getCurrentHealth() == 0) throw new DeadCharacterException(target);
        target.setCurrentHealth(target.getCurrentHealth() + healCapacity);
    }

    @Override
    public void attack(Character target) throws DeadCharacterException {
        if (getCurrentHealth() == 0) throw new DeadCharacterException(this);
        heal(this);
        int damage = getWeapon() != null ? getWeapon().getDamage() : 6;
        target.takeDamage(damage);
    }

    @Override
    public void takeDamage(int damage) throws DeadCharacterException {
        if (getCurrentHealth() == 0) throw new DeadCharacterException(this);
        int reduced = damage - shield;
        if (reduced < 0) reduced = 0;
        setCurrentHealth(getCurrentHealth() - reduced);
    }

    @Override
    public String toString() {
        if (getCurrentHealth() == 0) {
            return getName() + " has been beaten, even with its " + shield + " shield. So bad, it could heal " + healCapacity + " HP" +
                    (getWeapon() != null ? ". He has the weapon " + getWeapon() : "");
        }
        return getName() + " is a strong Templar with " + getCurrentHealth() + " HP. It can heal " + healCapacity + " HP and has a shield of " + shield +
                (getWeapon() != null ? ". He has the weapon " + getWeapon() : "");
    }
}

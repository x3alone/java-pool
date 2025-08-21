public class Monster extends Character {

    public Monster(String name, int maxHealth) {
        super(name, maxHealth);
    }

    @Override
    public void attack(Character other) {
        other.takeDamage(7);
    }

    @Override
    public void takeDamage(int damage) {
        int reduced = (int) Math.floor(damage * 0.8);
        setCurrentHealth(getCurrentHealth() - reduced);
    }

    @Override
    public String toString() {
        if (getCurrentHealth() == 0) {
            return getName() + " is a monster and is dead";
        }
        return getName() + " is a monster with " + getCurrentHealth() + " HP.";
    }
}

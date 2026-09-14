package Exercise01;

public class Mage extends GameCharacter {
    public Mage(String name, int hp) {
        super(name, hp);
    }

    @Override
    public void attack() {
        System.out.println("[Mage " + getName() + " - HP: " + getHp() + "] casts Fireball!");
    }
}

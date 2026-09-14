package Exercise01;

public class Warrior extends GameCharacter {
    public Warrior(String name, int hp) {
        super(name, hp);
    }

    @Override
    public void attack() {
        System.out.println("[Warrior " + getName() + " - HP: " + getHp() + "] slashes with Greatsword!");
    }
}

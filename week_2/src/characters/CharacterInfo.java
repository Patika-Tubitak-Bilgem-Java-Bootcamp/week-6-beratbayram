package characters;

public abstract class CharacterInfo {
    private final String name;
    private final int id;
    private final int damage;
    private final int health;
    private final int wealth;

    public CharacterInfo(String name, int id, int damage, int health, int wealth) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.wealth = wealth;
    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public int getDamage() {
        return damage;
    }
    public int getHealth() {
        return health;
    }
    public int getWealth() {
        return wealth;
    }

}

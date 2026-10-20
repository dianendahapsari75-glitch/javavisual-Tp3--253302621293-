
package model;

import java.util.Objects;

public class Character {
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attack;
    private int mana;

    public Character(String name, CharacterType type) {
        this(name, type, 1);
    }

    public Character(String name, CharacterType type, int level) {
        this.name = name;
        this.type = type;
        this.mana = 0;
        setLevel(level);
    }

    public String getName() {
        return name;
    }

    public CharacterType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttack() {
        return attack;
    }

    public int getMana() {
        return mana;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    public void setLevel(int level) {
        if (level <= 0) {
            throw new IllegalArgumentException(
                "Level harus lebih dari 0"
            );
        }

        this.level = level;
        this.hitPoints = 100 + (level - 1) * 20;
        this.attack = 10 + (level - 1) * 5;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException(
                "Mana tidak boleh negatif"
            );
        }

        this.mana = mana;
    }

    public void levelUp() {
        setLevel(level + 1);
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Character)) {
            return false;
        }

        Character other = (Character) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Character{name='" + name
            + "', type=" + type
            + ", level=" + level
            + ", hitPoints=" + hitPoints
            + ", attack=" + attack
            + ", mana=" + mana + "}";
    }
}

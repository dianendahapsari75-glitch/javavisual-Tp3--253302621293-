package Charactermanager.src.com.unpri.charactermanager;
import Charactermanager.src.com.unpri.charactermanager.model.Character;
import Charactermanager.src.com.unpri.charactermanager.model.CharacterType;

public class Main {
    public static void main(String[] args) {
        // Membuat tiga karakter untuk Bagian A
        Character c1 = new Character(
            "Arthas", CharacterType.WARRIOR
        );

        Character c2 = new Character(
            "Merlin", CharacterType.MAGE, 5
        );

        Character c3 = new Character(
            "Robin", CharacterType.ARCHER
        );

        System.out.println("=== CHARACTER MANAGER ===");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        // Demo level up
        System.out.println("\n=== DEMO LEVEL UP ===");
        System.out.println("Sebelum: " + c1);

        c1.levelUp();

        System.out.println("Sesudah: " + c1);

        // Mini-Challenge Bagian B
        System.out.println("\n=== MINI CHALLENGE ===");

        Character c4 = new Character(
            "Luna", CharacterType.MAGE, 3
        );

        c4.setMana(80);

        System.out.println(c4);
        System.out.println("Mana Luna: " + c4.getMana());
        System.out.println(
            "Apakah Luna masih hidup? " + c4.isAlive()
        );
    }
}

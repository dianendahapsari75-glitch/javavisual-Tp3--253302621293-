import java.util.ArrayList;

import manager.CharacterManager;
import model.Character;
import model.CharacterType;

public class Main {
    public static void main(String[] args) {
        CharacterManager manager = new CharacterManager();

        Character c1 = new Character(
            "Arthas", CharacterType.WARRIOR
        );

        Character c2 = new Character(
            "Merlin", CharacterType.MAGE, 5
        );

        Character c3 = new Character(
            "Robin", CharacterType.ARCHER
        );

        System.out.println("=== TAMBAH KARAKTER ===");
        System.out.println("Arthas: " + manager.addCharacter(c1));
        System.out.println("Merlin: " + manager.addCharacter(c2));
        System.out.println("Robin: " + manager.addCharacter(c3));

        System.out.println("\n=== UJI DUPLIKAT ===");
        Character duplicate = new Character(
            "Arthas", CharacterType.MAGE
        );

        System.out.println(
            "Arthas kedua: " + manager.addCharacter(duplicate)
        );

        System.out.println("\n=== SEMUA KARAKTER ===");
        for (Character c : manager.getAllCharacters()) {
            System.out.println(c);
        }

        System.out.println("\n=== CARI KARAKTER ===");
        System.out.println(manager.findByName("Merlin"));

        System.out.println("\n=== UJI SALINAN LIST ===");
        ArrayList<Character> copy = manager.getAllCharacters();
        copy.clear();

        System.out.println("Jumlah di salinan: " + copy.size());
        System.out.println(
            "Jumlah di manager: " + manager.getTotalCharacters()
        );

        System.out.println("\n=== HAPUS KARAKTER ===");
        System.out.println(
            "Robin dihapus: " + manager.removeCharacter("Robin")
        );

        System.out.println(
            "Total setelah hapus: " + manager.getTotalCharacters()
        );

        System.out.println("\n=== UJI EQUALS ===");
        Character anotherArthas = new Character(
            "Arthas", CharacterType.HEALER
        );

        System.out.println(
            "Nama Arthas sama: " + c1.equals(anotherArthas)
        );

        System.out.println("\n=== BAGIAN B: MINI-CHALLENGE ===");

        // 1. Menguji rata-rata level
        System.out.println(
            "Rata-rata level: " + manager.getAverageLevel()
        );

        // 2. Menguji jumlah dan daftar karakter berdasarkan tipe
        System.out.println(
            "Jumlah Mage: " + manager.countByType(CharacterType.MAGE)
        );

        System.out.println("\nDaftar karakter Mage:");

        for (Character c : manager.findByType(CharacterType.MAGE)) {
            System.out.println(c);
        }

        // 3. Menguji rata-rata jika karakter kosong
        CharacterManager emptyManager = new CharacterManager();

        System.out.println(
            "Rata-rata level saat list kosong: "
            + emptyManager.getAverageLevel()
        );

        System.out.println("\n=== BAGIAN C: FITUR ANALITIK ===");
        Character strongest = manager.findStrongest();
        System.out.println(
            "Karakter dengan attack tertinggi: " + strongest
        );

        // Uji encapsulation: ubah salinan, objek asli harus tetap sama
        strongest.setLevel(99);
        System.out.println(
            "Level Merlin di manager: "
            + manager.findByName("Merlin").getLevel()
        );

        // Uji list kosong
        System.out.println(
            "Strongest saat list kosong: "
            + emptyManager.findStrongest()
        );
    }
}
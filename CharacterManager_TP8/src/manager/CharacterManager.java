package manager;

import java.util.ArrayList;
import java.util.Objects;

import model.Character;
import model.CharacterType;

public class CharacterManager {
    private final ArrayList<Character> characters =
        new ArrayList<>();

    public boolean addCharacter(Character character) {
        if (character == null) {
            return false;
        }

        if (findByName(character.getName()) != null) {
            System.out.println(
                "Nama duplikat ditolak: " + character.getName()
            );
            return false;
        }

        characters.add(character);
        return true;
    }
        // Mengembalikan salinan daftar karakter untuk ditampilkan di View
    public ArrayList<Character> getDaftarKarakter() {
        return new ArrayList<Character>(characters);
    }

    public Character findByName(String name) {
        for (Character character : characters) {
            if (Objects.equals(character.getName(), name)) {
                return character;
            }
        }

        return null;
    }

    public boolean removeCharacter(String name) {
        Character character = findByName(name);

        if (character == null) {
            return false;
        }

        characters.remove(character);
        return true;
    }

    public int getTotalCharacters() {
        return characters.size();
    }

    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }

    public double getAverageLevel() {
        if (characters.isEmpty()) {
            return 0;
        }

        int total = 0;

        for (Character character : characters) {
            total += character.getLevel();
        }

        return (double) total / characters.size();
    }

    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> result = new ArrayList<>();

        for (Character character : characters) {
            if (character.getType() == type) {
                result.add(character);
            }
        }

        return result;
    }

    /**
     * Menghitung jumlah karakter berdasarkan tipe.
     *
     * @param type tipe karakter yang ingin dihitung
     * @return jumlah karakter dengan tipe tersebut
     */
    public int countByType(CharacterType type) {
        int count = 0;

        for (Character character : characters) {
            if (character.getType() == type) {
                count++;
            }
        }

        return count;
    }

    /**
     * Mencari karakter dengan nilai attack tertinggi.
     * Yang dikembalikan adalah salinan, bukan objek asli di dalam list,
     * sehingga data di manager tetap terlindungi (encapsulation).
     *
     * @return salinan karakter terkuat, atau null jika list kosong
     */
    public Character findStrongest() {
        if (characters.isEmpty()) {
            return null;
        }

        Character strongest = characters.get(0);

        for (Character character : characters) {
            if (character.getAttack() > strongest.getAttack()) {
                strongest = character;
            }
        }

        // Membuat salinan supaya objek asli tidak bisa diubah dari luar
        Character salinan = new Character(
            strongest.getName(),
            strongest.getType(),
            strongest.getLevel()
        );
        salinan.setMana(strongest.getMana());

        return salinan;
    }
}
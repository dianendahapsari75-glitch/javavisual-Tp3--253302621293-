package view;

import manager.CharacterManager;
import model.Character;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// INHERITANCE: MainWindow adalah sebuah JFrame (relasi is-a)
public class MainWindow extends JFrame {

    // ASOSIASI: MainWindow memegang CharacterManager (relasi has-a)
    private CharacterManager manajer;

    public MainWindow(CharacterManager manajer) {
        this.manajer = manajer;

        // Pengaturan jendela: judul, ukuran, dan perilaku saat ditutup
        setTitle("Character Manager - Sprint 3");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // jendela muncul di tengah layar
        setLayout(new BorderLayout()); // LAYOUT MANAGER

        // Panel daftar karakter, disusun dari atas ke bawah
        JPanel panelDaftar = new JPanel();
        panelDaftar.setLayout(new BoxLayout(panelDaftar, BoxLayout.Y_AXIS));

        // DATA DINAMIS: JLabel dibuat lewat perulangan, bukan satu per satu
        ArrayList<Character> daftar = this.manajer.getAllCharacters();
        for (int i = 0; i < daftar.size(); i++) {
            Character k = daftar.get(i);
            JLabel labelKarakter = new JLabel((i + 1) + ". " + k.getName()
                    + " | " + k.getType() + " | Level " + k.getLevel());
            panelDaftar.add(labelKarakter);
        }

        // MINI-CHALLENGE: statistik rata-rata level di bawah daftar
        double rataRata = this.manajer.getAverageLevel();
        JLabel labelRataRata = new JLabel("Rata-rata Level: "
                + String.format("%.2f", rataRata));

        add(panelDaftar, BorderLayout.CENTER);
        add(labelRataRata, BorderLayout.SOUTH);
    }
}

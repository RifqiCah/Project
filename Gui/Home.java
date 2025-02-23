package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.*;

public class Home {
    public Home(Player player) {
        JFrame frame = new JFrame("UNITE");
        // Mengatur ukuran frame
        frame.setSize(1920, 1080);
        // Mengatur aksi default saat frame ditutup
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat instance dari JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        frame.add(layeredPane);

        // Memanggil method placeComponents untuk menambahkan gambar
        placeComponents(layeredPane, frame);

        // Membuat JLabel untuk menampilkan pesan selamat datang
        JLabel welcomeLabel = new JLabel("Hello, " + player.getName() + "! Welcome to the game.");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 27));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setBounds(-300, 100, frame.getWidth(), 100);

        // Menambahkan JLabel ke JLayeredPane di tingkat atas
        layeredPane.add(welcomeLabel, Integer.valueOf(2));

        frame.setVisible(true);
        ImageIcon imageIcon2 = new ImageIcon("Aset/backHome.png");
        JLabel imageLabel2 = new JLabel(imageIcon2);
        imageLabel2.setBounds(0, 0, imageIcon2.getIconWidth(), imageIcon2.getIconHeight());
        layeredPane.add(imageLabel2, Integer.valueOf(2));
        JButton backButton = new JButton("wellcome");
        backButton.setBounds(30,35,50,50);
        layeredPane.add(backButton, Integer.valueOf(1));

        // Membuat label untuk tombol explore dungeon
        ImageIcon exploreIcon = new ImageIcon("Aset/explore.png");
        Image image = exploreIcon.getImage(); // Mendapatkan gambar sebagai objek Image
        Image resizedImage = image.getScaledInstance(400, 170, Image.SCALE_SMOOTH); // Mengubah ukuran gambar
        ImageIcon resizedExploreIcon = new ImageIcon(resizedImage); // Mengonversi kembali ke ImageIcon
        JLabel exploreLabel = new JLabel(resizedExploreIcon); // Membuat label dengan gambar yang sudah diresize
        exploreLabel.setBounds(190, 330, 200, 60);
        layeredPane.add(exploreLabel, Integer.valueOf(2));
        JButton submitButton = new JButton("a");
        submitButton.setBounds(200, 348, 130, 25);
        layeredPane.add(submitButton, Integer.valueOf(2));

        // Membuat label untuk tombol save progress
        ImageIcon saveIcon = new ImageIcon("Aset/save.png");
        Image image2 = saveIcon.getImage(); // Mendapatkan gambar sebagai objek Image
        Image resizedImage2 = image2.getScaledInstance(400, 170, Image.SCALE_SMOOTH); // Mengubah ukuran gambar
        ImageIcon resizedSaveIcon = new ImageIcon(resizedImage2); // Mengonversi kembali ke ImageIcon
        JLabel saveLabel = new JLabel(resizedSaveIcon); // Membuat label dengan gambar yang sudah diresize
        saveLabel.setBounds(430, 330, 200, 60);
        layeredPane.add(saveLabel, Integer.valueOf(2));
        JButton saveButton = new JButton("b");
        saveButton.setBounds(440, 348, 130, 25);
        layeredPane.add(saveButton, Integer.valueOf(2));

        // Membuat label untuk tombol upgrade monster
        ImageIcon upIcon = new ImageIcon("Aset/upgrade.png");
        Image image3 = upIcon.getImage(); // Mendapatkan gambar sebagai objek Image
        Image resizedImage3 = image3.getScaledInstance(400, 170, Image.SCALE_SMOOTH); // Mengubah ukuran gambar
        ImageIcon resizedUpIcon = new ImageIcon(resizedImage3); // Mengonversi kembali ke ImageIcon
        JLabel upLabel = new JLabel(resizedUpIcon); // Membuat label dengan gambar yang sudah diresize
        upLabel.setBounds(670, 330, 200, 60);
        layeredPane.add(upLabel, Integer.valueOf(2));
        JButton upButton = new JButton("c");
        upButton.setBounds(680, 348, 130, 25);
        layeredPane.add(upButton, Integer.valueOf(2));

        // Membuat label untuk tombol evolve monster
        ImageIcon evolveIcon = new ImageIcon("Aset/evolve.png");
        Image image4 = evolveIcon.getImage(); // Mendapatkan gambar sebagai objek Image
        Image resizedImage4 = image4.getScaledInstance(400, 170, Image.SCALE_SMOOTH); // Mengubah ukuran gambar
        ImageIcon resizedEvolveIcon = new ImageIcon(resizedImage4); // Mengonversi kembali ke ImageIcon
        JLabel evolveLabel = new JLabel(resizedEvolveIcon); // Membuat label dengan gambar yang sudah diresize
        evolveLabel.setBounds(930, 330, 200, 60);
        layeredPane.add(evolveLabel, Integer.valueOf(2));
        JButton evolveButton = new JButton("d");
        evolveButton.setBounds(940, 348, 130, 25);
        layeredPane.add(evolveButton, Integer.valueOf(2));

        // Membuat label untuk tombol exit monster
        ImageIcon exitIcon = new ImageIcon("Aset/exit.png");
        Image image5 = exitIcon.getImage(); // Mendapatkan gambar sebagai objek Image
        Image resizedImage5 = image5.getScaledInstance(400, 170, Image.SCALE_SMOOTH); // Mengubah ukuran gambar
        ImageIcon resizedExitIcon = new ImageIcon(resizedImage5); // Mengonversi kembali ke ImageIcon
        JLabel exitLabel = new JLabel(resizedExitIcon); // Membuat label dengan gambar yang sudah diresize
        exitLabel.setBounds(560, 472, 200, 60);
        layeredPane.add(exitLabel, Integer.valueOf(2));
        JButton exitButton = new JButton("d");
        exitButton.setBounds(590, 490, 130, 25);
        layeredPane.add(exitButton, Integer.valueOf(2));

        // Menambahkan ActionListener untuk setiap tombol
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("Aset/pika.wav");
                frame.dispose();
                Welcome.main(null);
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("Aset/pika.wav");
                frame.dispose();
                SwingUtilities.invokeLater(() -> {
                    new SellectPokemon(player);
                });
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("Aset/pika.wav");

                player.saveProgress();
                
                // Membuat frame baru
                JFrame newFrame = new JFrame("New Frame");
                newFrame.setSize(315, 262); // Mengubah ukuran frame menjadi 300x250
                newFrame.setLocationRelativeTo(frame); // Menempatkan frame baru di tengah-tengah frame utama
        
                // Membuat panel untuk frame baru
                JPanel newPanel = new JPanel();
                newPanel.setLayout(null); // Menggunakan null layout untuk absolute positioning
                newFrame.add(newPanel);
        
                // Menambahkan gambar ke frame baru
                ImageIcon imageIcon1 = new ImageIcon("Aset/save_success2.png");
                JLabel image1Label = new JLabel(imageIcon1);
                image1Label.setBounds(0, 0, 300, 250); // Menyesuaikan ukuran label dengan ukuran gambar
                newPanel.add(image1Label);
        
                // Membuat tombol "Exit" di frame baru// Membuat label untuk tombol exit monster
                // ImageIcon exitIcon2 = new ImageIcon("Aset/save_exit_btn.png");
                // Image image6 = exitIcon2.getImage(); // Mendapatkan gambar sebagai objek Image
                // Image resizedImage6 = image6.getScaledInstance(100, 30, Image.SCALE_SMOOTH); // Mengubah ukuran gambar
                // ImageIcon resizedExitIcon2 = new ImageIcon(resizedImage6); // Mengonversi kembali ke ImageIcon
                // JLabel exitLabel2 = new JLabel(resizedExitIcon2); // Membuat label dengan gambar yang sudah diresize
                // exitLabel2.setBounds(100, 180, 100, 30);
                // newPanel.add(exitLabel2, Integer.valueOf(2));
                Icon icon = new ImageIcon ("Aset/save_exit_btn.png");
                JButton exitButton = new JButton(icon);
                exitButton.setBackground(null);
                // JButton exitButton = new JButton("Exit");
                exitButton.setBounds(100, 180, 100, 30); // Menentukan posisi dan ukuran tombol
                exitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newFrame.dispose(); // Menutup frame baru
                    }
                });
                newPanel.add(exitButton);
        
                newFrame.setVisible(true);
            }
        });

        upButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("Aset/pika.wav");
                frame.dispose();
                SwingUtilities.invokeLater(() -> {
                    new Upgrade(player);
                });
            }
        });

        evolveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("Aset/pika.wav");
                frame.dispose();
                SwingUtilities.invokeLater(() -> {
                    Evolution.main(null);
                });
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("Aset/pika.wav");
                System.exit(0); // Keluar dari aplikasi
            }
        });
    }

    public static void placeComponents(JLayeredPane layeredPane, JFrame frame) {

        ImageIcon imageIcon1 = new ImageIcon("Aset/bghome1.png");
        Image image1 = imageIcon1.getImage();
        Image resizedImage1 = image1.getScaledInstance(1296, 729, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon1 = new ImageIcon(resizedImage1);
        JLabel image1Label = new JLabel(resizedIcon1);
        image1Label.setBounds(0, 0, 1296, 729);
        layeredPane.add(image1Label, Integer.valueOf(1));

        ImageIcon imageIcon2 = new ImageIcon("Aset/poke2.gif");
        JLabel imageLabel2 = new JLabel(imageIcon2);
        imageLabel2.setBounds(700, 350, imageIcon2.getIconWidth(), imageIcon2.getIconHeight());
        layeredPane.add(imageLabel2, Integer.valueOf(2));
    }

    public static void playSound(String soundFile) {
        try {
            File soundPath = new File(soundFile);
            if (soundPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            } else {
                System.out.println("Sound file not found: " + soundFile);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Membuat objek Home dengan username "Player"
        new Home(new Player("Player"));
    }
}

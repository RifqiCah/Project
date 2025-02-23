package Gui;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.*;

public class Battle {
    private ArrayList<Monster> selected;

    public Battle (ArrayList<Monster> selected) {
        this.selected = selected;
        JFrame frame = new JFrame("UNITE");
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLayeredPane layeredPane = new JLayeredPane();
        frame.add(layeredPane);
      
        placeComponents(layeredPane, frame);
        frame.setVisible(true);


        // Putar musik latar belakang
        playBackgroundMusic("Aset/naruto.wav");
    }

    private static void placeComponents(JLayeredPane layeredPane, JFrame frame) {
        ImageIcon originalIcon = new ImageIcon("Aset/battle.jpg");
        Image originalImage = originalIcon.getImage();
        // Mengubah ukuran gambar sesuai dengan ukuran frame
        Image scaledImage = originalImage.getScaledInstance(1296,729, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(0, 0, 1296,729);
        layeredPane.add(imageLabel, Integer.valueOf(0));

        //icon vs
        
        //nama hero kita
        JLabel pokemon = new JLabel("Chairman");
        pokemon.setBackground(null);
        pokemon.setBounds(20,-290,400,600);
        pokemon.setFont(new Font("Arial", Font.ITALIC,20));
        layeredPane.add(pokemon, Integer.valueOf(2));
        pokemon.setForeground(Color.WHITE);

        ImageIcon BarHp = new ImageIcon("Aset/hp_border.png");
        Image bar2 = BarHp.getImage(); // Mendapatkan gambar sebagai objek Image
        Image resizedBarHp = bar2.getScaledInstance(350, 52, Image.SCALE_SMOOTH); // Mengubah ukuran gambar
        ImageIcon resizedBarHpIcon= new ImageIcon(resizedBarHp); // Mengonversi kembali ke ImageIcon
        JLabel BarHpLabel = new JLabel(resizedBarHpIcon); // Membuat label dengan gambar yang sudah diresize
        BarHpLabel.setBounds(-178, 0, 700, 103);
        layeredPane.add(BarHpLabel, Integer.valueOf(2));

        //nama hero musuh 
        JLabel pokemon2 = new JLabel("Chairman");
        pokemon2.setBackground(null);
        pokemon2.setBounds(1155,-290,400,600);
        pokemon2.setFont(new Font("Arial", Font.ITALIC,20));
        layeredPane.add(pokemon2, Integer.valueOf(2));
        pokemon2.setForeground(Color.WHITE);
        //bar HP musuh
        ImageIcon BarHp2 = new ImageIcon("Aset/hp_border.png");
        Image bar3 = BarHp2.getImage(); // Mendapatkan gambar sebagai objek Image
        Image resizedBarHp2 = bar3.getScaledInstance(350, 52, Image.SCALE_SMOOTH); // Mengubah ukuran gambar
        ImageIcon resizedBarHpIcon2= new ImageIcon(resizedBarHp2); // Mengonversi kembali ke ImageIcon
        JLabel BarHpLabel2 = new JLabel(resizedBarHpIcon2); // Membuat label dengan gambar yang sudah diresize
        BarHpLabel2.setBounds(750, 0, 700, 103);
        layeredPane.add(BarHpLabel2, Integer.valueOf(2));

        ImageIcon atkIcon = new ImageIcon("Aset/elementbg.png");
        Image image = atkIcon.getImage(); // Mendapatkan gambar sebagai objek Image
        Image resizedImage = image.getScaledInstance(400, 300, Image.SCALE_SMOOTH); // Mengubah ukuran gambar
        ImageIcon resizedatkIcon = new ImageIcon(resizedImage); // Mengonversi kembali ke ImageIcon
        JLabel atkLabel = new JLabel(resizedatkIcon); // Membuat label dengan gambar yang sudah diresize
        atkLabel.setBounds(616, 422, 400, 300);
        layeredPane.add(atkLabel, Integer.valueOf(2));

        JButton logokucing = new JButton("1");
        logokucing.setBounds(772, 550, 70, 60);
        layeredPane.add(logokucing, Integer.valueOf(2));

        ImageIcon atkIcon2 = new ImageIcon("Aset/healbg.png");
        Image image2 = atkIcon2.getImage(); // Mendapatkan gambar sebagai objek Image
        Image resizedImage2 = image2.getScaledInstance(400, 300, Image.SCALE_SMOOTH); // Mengubah ukuran gambar
        ImageIcon resizedatkIcon2= new ImageIcon(resizedImage2); // Mengonversi kembali ke ImageIcon
        JLabel atkLabel2 = new JLabel(resizedatkIcon2); // Membuat label dengan gambar yang sudah diresize
        atkLabel2.setBounds(250, 424, 400, 300);
        layeredPane.add(atkLabel2, Integer.valueOf(2));

        JButton item  = new JButton("2");
        item.setBounds(415, 550, 70,60);
        layeredPane.add(item, Integer.valueOf(2));

        
        ImageIcon atkIcon3 = new ImageIcon("Aset/kaburbg.png");
        Image image3 = atkIcon3.getImage(); // Mendapatkan gambar sebagai objek Image
        Image resizedImage3 = image3.getScaledInstance(400, 300, Image.SCALE_SMOOTH); // Mengubah ukuran gambar
        ImageIcon resizedatkIcon3= new ImageIcon(resizedImage3); // Mengonversi kembali ke ImageIcon
        JLabel atkLabel3 = new JLabel(resizedatkIcon3); // Membuat label dengan gambar yang sudah diresize
        atkLabel3.setBounds(336, 425, 400, 300);
        layeredPane.add(atkLabel3, Integer.valueOf(2));

        
        JButton kabur  = new JButton("3");
        kabur.setBounds(510, 550, 70, 60);
        layeredPane.add(kabur, Integer.valueOf(2));

        ImageIcon atkIcon4 = new ImageIcon("Aset/pedangBg.png");
        Image image4 = atkIcon4.getImage(); // Mendapatkan gambar sebagai objek Image
        Image resizedImage4 = image4.getScaledInstance(400, 300, Image.SCALE_SMOOTH); // Mengubah ukuran gambar
        ImageIcon resizedatkIcon4= new ImageIcon(resizedImage4); // Mengonversi kembali ke ImageIcon
        JLabel atkLabel4 = new JLabel(resizedatkIcon4); // Membuat label dengan gambar yang sudah diresize
        atkLabel4.setBounds(523, 422, 400, 300);
        layeredPane.add(atkLabel4, Integer.valueOf(3));

        JButton spesial  = new JButton("A");
        spesial.setBounds(684, 550, 70, 60);
        layeredPane.add(spesial, Integer.valueOf(2));

        ImageIcon atkIcon5 = new ImageIcon("Aset/spessAtbg.png");
        Image image5 = atkIcon5.getImage(); // Mendapatkan gambar sebagai objek Image
        Image resizedImage5 = image5.getScaledInstance(400, 300, Image.SCALE_SMOOTH); // Mengubah ukuran gambar
        ImageIcon resizedatkIcon5= new ImageIcon(resizedImage5); // Mengonversi kembali ke ImageIcon
        JLabel atkLabel5 = new JLabel(resizedatkIcon5); // Membuat label dengan gambar yang sudah diresize
        atkLabel5.setBounds(429,423, 400, 300);
        layeredPane.add(atkLabel5, Integer.valueOf(3));

        //ini untuk spesial attack 
        JButton attack  = new JButton("4");
        attack.setBounds(598, 550, 70, 60);
        layeredPane.add(attack, Integer.valueOf(2));
        
    }

    // Method untuk memutar musik latar belakang
    private static void playBackgroundMusic(String musicPath) {
        try {
            File musicFile = new File(musicPath);
            if (musicFile.exists()) {
                System.out.println("Playing sound from: " + musicFile.getAbsolutePath());
                // Menggunakan Java Sound API untuk memutar musik
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musicFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY); // Loop the background music
            } else {
                System.out.println("File not found: " + musicFile.getAbsolutePath());
            }
        } catch (UnsupportedAudioFileException e) {
            System.err.println("Unsupported audio file: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("Line unavailable: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
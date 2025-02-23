package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class NewGame {
    public static void main(String[] args) {
        // Membuat instance dari JFrame
        JFrame frame = new JFrame("UNITE");

        // Mengatur ukuran frame
        frame.setSize(1920, 1080);

        // Mengatur aksi default saat frame ditutup
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menambahkan komponen ke frame
        JLayeredPane layeredPane = new JLayeredPane();
        frame.add(layeredPane);
        placeComponents(layeredPane, frame);

    }

    private static void placeComponents(JLayeredPane layeredPane, JFrame frame) {
        // Membuat label gambar
        ImageIcon imageIcon = new ImageIcon("Aset/bggif2.gif"); // Ganti dengan path gambar Anda
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        layeredPane.add(imageLabel, Integer.valueOf(0));

        // Menampilkan frame
        frame.setVisible(true);
        InputStream fontStream = null;
        Font retro = null;
        try {
            fontStream = new FileInputStream("Aset/retro.ttf");
            retro = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            retro = retro.deriveFont(40f); // Mengatur ukuran font menjadi 24
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (FontFormatException | IOException e1) {
            e1.printStackTrace();
        } finally {
            if (fontStream != null) {
                try {
                    fontStream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

        // Membuat label untuk username

        JLabel userLabel = new JLabel("ENTER USERNAME!");
        userLabel.setBounds(470, 120, 2000, 100);
        userLabel.setFont(retro);
        userLabel.setForeground(Color.WHITE);
        layeredPane.add(userLabel, Integer.valueOf(2));

        JLabel userLabel1 = new JLabel(
                "<html>\"UNITE\" adalah permainan petualangan berbasis cerita yang mengambil setting di sebuah dunia fiksi yang kaya dengan mitologi dan sejarah.<br>"
                        +
                        "Pemain berperan sebagai seorang karakter utama, Ibni, yang memulai perjalanan epik untuk mengungkap rahasia-rahasia yang tersembunyi di dunia yang penuh dengan makhluk ajaib, teka-teki, dan tantangan.</html>");
        userLabel1.setBounds(400, 50, 500, 500);
        userLabel1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        userLabel1.setForeground(Color.BLACK);

        layeredPane.add(userLabel1, Integer.valueOf(2));

        // Membuat text field untuk input username
        JTextField userText = new JTextField(20);
        userText.setBounds(600, 400, 200, 50);
        userText.setBackground(Color.BLACK);
        userText.setForeground(Color.WHITE);
        // Mengatur font (jenis dan ukuran)
        Font customFont = new Font("Times New Roman", Font.ITALIC, 20); // "Arial", gaya biasa, ukuran 20
        userText.setFont(customFont);

        layeredPane.add(userText, Integer.valueOf(2));

        // Membuat label untuk tombol SUBMIT
        ImageIcon submitIcon = new ImageIcon("Aset/checked.png");
        Image image = submitIcon.getImage(); // Mendapatkan gambar sebagai objek Image
        Image resizedImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Mengubah ukuran gambar
        ImageIcon resizedSubmitIcon = new ImageIcon(resizedImage); // Mengonversi kembali ke ImageIcon
        JLabel submitLabel = new JLabel(resizedSubmitIcon); // Membuat label dengan gambar yang sudah diresize
        submitLabel.setBounds(800, 400, 50, 50);
        layeredPane.add(submitLabel, Integer.valueOf(2));

        //  
        ImageIcon imageIcon2 = new ImageIcon("Aset/backHome.png");
        JLabel imageLabel2 = new JLabel(imageIcon2);
        imageLabel2.setBounds(0, 0, imageIcon2.getIconWidth(), imageIcon2.getIconHeight());
        layeredPane.add(imageLabel2, Integer.valueOf(1));
        JButton backButton = new JButton("wellcome");
        backButton.setBounds(30,35,50,50);
        layeredPane.add(backButton, Integer.valueOf(1));



        // Membuat tombol untuk submit username
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(804, 403, 46, 46);
        layeredPane.add(submitButton, Integer.valueOf(2));

        //
        // Menambahkan event listener untuk tombol submit
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Welcome.main(null);
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String playerName = userText.getText();
                Player player = new Player(playerName);
                frame.dispose();
                SwingUtilities.invokeLater(() -> {
                    new Home(player);
                });
            }
        });

        // Mengatur ukuran dan tata letak layeredPane
        layeredPane.setPreferredSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));
    }
}

package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Evolution {
       public static void main(String[] args) {
        
        JFrame frame = new JFrame("UNITE");
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLayeredPane layeredPane = new JLayeredPane();
        frame.add(layeredPane);
        placeComponents(layeredPane, frame);
        frame.setVisible(true);

    }

    private static void placeComponents(JLayeredPane layeredPane, JFrame frame) {
        ImageIcon imageIcon = new ImageIcon("Aset/bggif5.gif");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, -30, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        layeredPane.add(imageLabel, Integer.valueOf(2));

        //// Membuat label untuk tombol back GAME
        ImageIcon backIcon = new ImageIcon("Aset/back1.png");
        JLabel backLabel = new JLabel(backIcon);
        backLabel.setBounds(0, 0, backIcon.getIconWidth(), backIcon.getIconHeight());
        layeredPane.add(backLabel, Integer.valueOf(3));

        JButton backButton = new JButton("back");
        backButton.setBounds(40, 40, 80, 80);
        layeredPane.add(backButton, Integer.valueOf(1));

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                    new Home(new Player("player"));
                
            }
        });
        
        ImageIcon imageIcon1 = new ImageIcon("Aset/_angin_.gif");
        JLabel imageLabel1 = new JLabel(imageIcon1);
        imageLabel1.setBounds(75, 300, imageIcon1.getIconWidth(), imageIcon1.getIconHeight());
        layeredPane.add(imageLabel1, Integer.valueOf(3));

        ImageIcon imageIcon2 = new ImageIcon("Aset/_es_.gif");
        JLabel imageLabel2 = new JLabel(imageIcon2);
        imageLabel2.setBounds(310, 300, imageIcon2.getIconWidth(), imageIcon2.getIconHeight());
        layeredPane.add(imageLabel2, Integer.valueOf(3));

        ImageIcon imageIcon3 = new ImageIcon("Aset/_api_.gif");
        JLabel imageLabel3 = new JLabel(imageIcon3);
        imageLabel3.setBounds(550, 300, imageIcon3.getIconWidth(), imageIcon3.getIconHeight());
        layeredPane.add(imageLabel3, Integer.valueOf(3));

        ImageIcon imageIcon4 = new ImageIcon("Aset/_air_.gif");
        JLabel imageLabel4 = new JLabel(imageIcon4);
        imageLabel4.setBounds(780, 300, imageIcon4.getIconWidth(), imageIcon4.getIconHeight());
        layeredPane.add(imageLabel4, Integer.valueOf(4));

        ImageIcon imageIcon5 = new ImageIcon("Aset/_tanah_.gif");
        JLabel imageLabel5 = new JLabel(imageIcon5);
        imageLabel5.setBounds(1000, 300, imageIcon5.getIconWidth(), imageIcon5.getIconHeight());
        layeredPane.add(imageLabel5, Integer.valueOf(4));

        JButton sellectButton1 = new JButton("1");
        sellectButton1.setBounds(75, 350, 200, 300);
        sellectButton1.setBackground(Color.GREEN);
        layeredPane.add(sellectButton1, Integer.valueOf(2));

        JButton sellectButton2 = new JButton("2");
        sellectButton2.setBounds(310, 350, 200, 300);
        sellectButton2.setBackground(Color.GREEN);
        layeredPane.add(sellectButton2, Integer.valueOf(2));

        JButton sellectButton3 = new JButton("3");
        sellectButton3.setBounds(540, 350, 200, 300);
        sellectButton3.setBackground(Color.GREEN);
        layeredPane.add(sellectButton3, Integer.valueOf(2));

        JButton sellectButton4 = new JButton("4");
        sellectButton4.setBounds(772, 350, 200, 300);
        sellectButton4.setBackground(Color.GREEN);
        layeredPane.add(sellectButton4, Integer.valueOf(2));

        JButton sellectButton5 = new JButton("5");
        sellectButton5.setBounds(1003, 350, 200, 300);
        sellectButton5.setBackground(Color.GREEN);
        layeredPane.add(sellectButton5, Integer.valueOf(2));

        // Menampilkan frame
        frame.setVisible(true);
        InputStream fontStream = null;
        Font retro = null;
        try {
            fontStream = new FileInputStream("Aset/retro.ttf");
            retro = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            retro = retro.deriveFont(52f); // Mengatur ukuran font menjadi 24
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

        JLabel userLabel = new JLabel("EVOLVE YOUR POKEMON");
        userLabel.setBounds(478, 45, 2000, 100);
        userLabel.setFont(retro);
        userLabel.setForeground(Color.BLACK);
        layeredPane.add(userLabel, Integer.valueOf(3));

        sellectButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEvolutionOptions(frame, "Evolusi Angin", new String[] { "Tanah", "Angin" });
            }
        });

        sellectButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEvolutionOptions(frame, "Evolusi Angin", new String[] { "Tanah", "Api" });
            }
        });

        sellectButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEvolutionOptions(frame, "Evolusi Angin", new String[] { "Tanah", "Api" });
            }
        });

        sellectButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEvolutionOptions(frame, "Evolusi Angin", new String[] { "Tanah", "Api" });
            }
        });

        sellectButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEvolutionOptions(frame, "Evolusi Angin", new String[] { "Tanah", "Api" });
            }
        });

        sellectButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEvolutionOptions(frame, "Evolusi Angin", new String[] { "Tanah", "Api" });
            }
        });

    }

    private static void showEvolutionOptions(JFrame frame, String title, String[] options) {
        int choice = JOptionPane.showOptionDialog(frame,
                "Pilih evolusi:",
                title,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);

        if (choice != -1) {
            String selectedEvolution = options[choice];
            displaySelectedEvolution(frame, selectedEvolution);
        }
    }

    private static void displaySelectedEvolution(JFrame frame, String evolution) {
        JOptionPane.showMessageDialog(frame, "Anda memilih evolusi: " + evolution);
    }
}

package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.*;

public class Welcome {
    public static void main(String[] args) {
        JFrame frame = new JFrame("UNITE");
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLayeredPane layeredPane = new JLayeredPane();
        frame.add(layeredPane);
        placeComponents(layeredPane, frame);
        frame.setVisible(true);

        // Putar musik latar belakang
        playBackgroundMusic("Aset/poke.wav");
    }

    private static void placeComponents(JLayeredPane layeredPane, JFrame frame) {
        ImageIcon imageIcon = new ImageIcon("Aset/g2.jpg");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, -70, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        layeredPane.add(imageLabel, Integer.valueOf(0));

        ImageIcon imageIcon2 = new ImageIcon("Aset/UNITE3a.png");
        JLabel imageLabel2 = new JLabel(imageIcon2);
        imageLabel2.setBounds(0, 0, imageIcon2.getIconWidth(), imageIcon2.getIconHeight());
        layeredPane.add(imageLabel2, Integer.valueOf(2));

        // Membuat label untuk tombol NEW GAME
        ImageIcon playIcon = new ImageIcon("Aset/play.png");
        Image image = playIcon.getImage();
        Image resizedImage = image.getScaledInstance(200, 60, Image.SCALE_SMOOTH);
        ImageIcon resizedPlayIcon = new ImageIcon(resizedImage);
        JLabel playLabel = new JLabel(resizedPlayIcon);
        playLabel.setBounds(600, 315, 200, 60);
        layeredPane.add(playLabel, Integer.valueOf(2));

        JButton playButton = new JButton("NEW GAME");
        playButton.setBounds(610, 330, 180, 30);
        playButton.setBackground(Color.GREEN);
        layeredPane.add(playButton, Integer.valueOf(2));

        // Membuat label untuk tombol LOAD GAME
        ImageIcon LoadIcon = new ImageIcon("Aset/load.png");
        Image imageLoad = LoadIcon.getImage();
        Image resizedImageLoad = imageLoad.getScaledInstance(200, 60, Image.SCALE_SMOOTH);
        ImageIcon resizedLoadIcon = new ImageIcon(resizedImageLoad);
        JLabel LoadLabel = new JLabel(resizedLoadIcon);
        LoadLabel.setBounds(600, 375, 200, 60);
        layeredPane.add(LoadLabel, Integer.valueOf(2));

        JButton loadButton = new JButton("LOAD GAME");
        loadButton.setBounds(610, 390, 180, 30);
        loadButton.setBackground(Color.GREEN);
        layeredPane.add(loadButton, Integer.valueOf(2));

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                NewGame.main(null);

                // stopBackgroundMusic();  // Hentikan musik sebelum membuka frame baru
                // frame.dispose();
                // Battle.main(null);
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner scanner = new Scanner(System.in);

                InputStream fontStream = null;
                Font retro = null;
                try {
                    fontStream = new FileInputStream("Aset/retro.ttf");
                    retro = Font.createFont(Font.TRUETYPE_FONT, fontStream);
                    retro = retro.deriveFont(24f); // Mengatur ukuran font menjadi 24
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
        
                JFrame loadFrame = new JFrame();
                loadFrame.setSize(400, 500); // Mengubah ukuran frame menjadi 400x500
                loadFrame.setLocationRelativeTo(frame); // Menempatkan frame baru di tengah-tengah frame utama
        
                // Membuat panel untuk frame baru
                JPanel loadPanel = new JPanel();
                loadPanel.setLayout(null); // Menggunakan null layout untuk absolute positioning

                ArrayList<String> users = new ArrayList<>();

                try {
                    File myObj = new File("save/user.txt");
                    Scanner myReader = new Scanner(myObj);

                    System.out.println("Select an user:");
                    if (!myReader.hasNext()) {
                        // Membuat dan menambahkan JLabel dengan teks "Users"
                        JLabel notFound = new JLabel("Data save");
                        notFound.setFont(retro); // Menggunakan font retro
                        notFound.setForeground(new Color(105, 52, 8)); // Menyesuaikan warna teks jika diperlukan
                        notFound.setBounds(120, 190, 155, 30); // Menyesuaikan posisi dan ukuran Title
                        loadPanel.add(notFound);
                        
                        JLabel notFound2 = new JLabel("not found");
                        notFound2.setFont(retro); // Menggunakan font retro
                        notFound2.setForeground(new Color(105, 52, 8)); // Menyesuaikan warna teks jika diperlukan
                        notFound2.setBounds(121, 220, 155, 30); // Menyesuaikan posisi dan ukuran Title
                        loadPanel.add(notFound2);
        
                        // Menambahkan gambar ke frame baru
                        ImageIcon imageIcon1 = new ImageIcon("Aset/load_wood.png");
                        JLabel image1Label = new JLabel(imageIcon1);
                        image1Label.setBounds(0, 0, 390, 470); // Menyesuaikan ukuran label dengan ukuran gambar
                        loadPanel.add(image1Label);
                
                        loadFrame.add(loadPanel);
                        loadFrame.setVisible(true);
                    } else {
                        // Membuat dan menambahkan JLabel dengan teks "Users"
                        JLabel usersTitle = new JLabel("Users");
                        usersTitle.setFont(retro); // Menggunakan font retro
                        usersTitle.setForeground(new Color(105, 52, 8)); // Menyesuaikan warna teks jika diperlukan
                        usersTitle.setBounds(150, 30, 100, 30); // Menyesuaikan posisi dan ukuran Title
                        loadPanel.add(usersTitle);

                        LinkedList<JLabel> labels = new LinkedList<>();

                        int y = 60;
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            users.add(data);

                            // Membuat dan menambahkan JLabel dengan teks "Users"
                            JLabel user1 = new JLabel(data);
                            user1.setFont(retro); // Menggunakan font retro
                            user1.setForeground(new Color(105, 52, 8)); // Menyesuaikan warna teks jika diperlukan
                            user1.setOpaque(true);
                            user1.setBackground(new Color(226, 196, 98));
                            user1.setBounds(35, y += 35, 320, 30); // Menyesuaikan posisi dan ukuran Title

                            // Menambahkan MouseListener ke label
                            user1.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseEntered(MouseEvent e) {
                                    user1.setBackground(new Color(255, 232, 158)); // Warna saat di-hover
                                }

                                @Override
                                public void mouseExited(MouseEvent e) {
                                    user1.setBackground(new Color(226, 196, 98));
                                }

                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    // Mengubah background label saat diklik
                                    try {
                                        File myObj2 = new File("save/" + data + ".txt");
                                        Scanner myReader2 = new Scanner(myObj2);
                                        ArrayList<Monster> mons = new ArrayList<>();

                                        while (myReader2.hasNextLine()) {
                                            String data = myReader2.nextLine();
                                            String[] monsData = data.split(" ");
                                            String nm = monsData[0];
                                            int lv = Integer.parseInt(monsData[1]);
                                            int hp = Integer.parseInt(monsData[2]);
                                            int ep = Integer.parseInt(monsData[3]);
                                            String el = monsData[4];
                                            boolean ch = monsData[6].equals("true")? true: false;
                                            
                                            switch (el) {
                                            case "Air":
                                                mons.add(new MonsterAir(nm, lv, hp, ep, ch));
                                                break;
                                            
                                            case "Angin":
                                                mons.add(new MonsterAngin(nm, lv, hp, ep, ch));
                                                break;
                                        
                                            case "Api":
                                                mons.add(new MonsterApi(nm, lv, hp, ep, ch));
                                                break;
                                        
                                            case "Es":
                                                mons.add(new MonsterEs(nm, lv, hp, ep, ch));
                                                break;
                                        
                                            case "Tanah":
                                                mons.add(new MonsterTanah(nm, lv, hp, ep, ch));
                                                break;
                                            }
                                        }
                                        
                                        myReader.close();
            
                                        Player player = new Player(data, mons);
                                        frame.dispose();
                                        loadFrame.dispose();
                                        SwingUtilities.invokeLater(() -> {
                                            new Home(player);
                                        });
                                    } catch (FileNotFoundException er) {
                                        System.out.println("An error occurred.");
                                        er.printStackTrace();
                                    }
                                }
                            });

                            labels.add(user1);
                        }

                        for (JLabel lbl : labels) {
                            loadPanel.add(lbl, Integer.valueOf(1));
                        }
        
                        // Menambahkan gambar ke frame baru
                        ImageIcon imageIcon1 = new ImageIcon("Aset/load_wood.png");
                        JLabel image1Label = new JLabel(imageIcon1);
                        image1Label.setBounds(0, 0, 390, 470); // Menyesuaikan ukuran label dengan ukuran gambar
                        loadPanel.add(image1Label);
                
                        loadFrame.add(loadPanel);
                        // loadFrame.setVisible(true);

                        // System.out.print("Select: ");
                        // int plh2 = scanner.nextInt();

                        
                    }

                    myReader.close();
                } catch (FileNotFoundException er) {
                    System.out.println("Save data not found");
                }
        
                // // Membuat dan menambahkan JLabel dengan teks "Users"
                // JLabel user1 = new JLabel("User1");
                // user1.setFont(retro); // Menggunakan font retro
                // user1.setForeground(new Color(105, 52, 8)); // Menyesuaikan warna teks jika diperlukan
                // user1.setOpaque(true);
                // user1.setBackground(Color.BLACK);
                // user1.setBounds(35, 70, 300, 30); // Menyesuaikan posisi dan ukuran Title
                // loadPanel.add(user1);

                // // Menambahkan MouseListener ke label
                // user1.addMouseListener(new MouseAdapter() {
                //     @Override
                //     public void mouseEntered(MouseEvent e) {
                //         user1.setBackground(Color.GRAY); // Warna saat di-hover
                //     }

                //     @Override
                //     public void mouseExited(MouseEvent e) {
                //         user1.setBackground(Color.BLACK); // Warna saat tidak di-hover
                //     }
                // });
        
                // Menambahkan gambar ke frame baru
                ImageIcon imageIcon1 = new ImageIcon("Aset/load_wood.png");
                JLabel image1Label = new JLabel(imageIcon1);
                image1Label.setBounds(0, 0, 390, 470); // Menyesuaikan ukuran label dengan ukuran gambar
                loadPanel.add(image1Label);
        
                loadFrame.add(loadPanel);
                loadFrame.setVisible(true);
            }
        });
        
        

        layeredPane.setPreferredSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));
    }

    // Method untuk memutar musik latar belakang
    private static void playBackgroundMusic(String musicPath) {
        try {
            File musicFile = new File(musicPath);
            if (musicFile.exists()) {
                System.out.println("Playing sound from: " + musicFile.getAbsolutePath());
                // Menggunakan Java Sound API untuk memutar musik
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musicFile);
                Clip backgroundClip = AudioSystem.getClip();
                backgroundClip.open(audioInputStream);
                backgroundClip.start();
                backgroundClip.loop(Clip.LOOP_CONTINUOUSLY); // Loop the background music
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

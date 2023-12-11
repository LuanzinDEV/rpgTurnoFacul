package rpg_turno_package;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import rpg_turno_modelo_package.Fase;

public class Menu {
    BufferedImage img = null;

    // Tente ler a imagem dentro de um construtor ou método
    public Menu() {
        try {
            img = ImageIO.read(new File("res\\background.jpg"));
        } catch (IOException e) {	
            e.printStackTrace();
        }

        // Configura a imagem de fundo
        Image dimg = img.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        ImageIcon backgroundIcon = new ImageIcon(dimg);

        // Configura janela principal
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1280, 720);	
        mainFrame.setContentPane(new JPanel());
        mainFrame.setLayout(null);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);

        // Configura o botão "SELECIONAR PERSONAGEM" na janela principal
        JButton selecaoPersonagemButton = new JButton("SELECIONAR PERSONAGEM");
        selecaoPersonagemButton.setFont(new Font("ROBOTO", Font.BOLD, 20));
        selecaoPersonagemButton.setContentAreaFilled(false);
        selecaoPersonagemButton.setForeground(Color.white);
        selecaoPersonagemButton.setBounds(480, 320, 320, 80);
        selecaoPersonagemButton.setFocusPainted(false);

        // Adiciona um ActionListener ao botão para abrir a tela de seleção de personagens
        selecaoPersonagemButton.addActionListener(e -> {
            mainFrame.dispose(); // Fecha a janela principal
            new SelecaoPersonagem(); // Abre a tela de seleção de personagens
        });

        // Configura a imagem de fundo no rótulo
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 1280, 720);

        // Adiciona o botão à janela principal
        mainFrame.add(selecaoPersonagemButton);

        // Adiciona o rótulo da imagem de fundo à janela principal
        mainFrame.add(backgroundLabel);

        mainFrame.setVisible(true);
    }

}

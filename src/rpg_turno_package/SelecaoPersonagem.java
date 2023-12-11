package rpg_turno_package;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import rpg_turno_modelo_package.Fase;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Font;
import java.awt.Color;

public class SelecaoPersonagem extends JFrame {
    public SelecaoPersonagem() {
        setTitle("Seleção de Personagem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setResizable(false);

        // Adicionar o fundo preto
        JPanel background = new JPanel();
        background.setBackground(Color.BLACK);
        setContentPane(background);
        setLayout(new GridLayout(1, 3));

        int newWidth = 400; // Nova largura para as imagens
        int newHeight = 600; // Nova altura para as imagens

        // Painel do Mago
        JPanel magoPanel = new JPanel();
        magoPanel.setOpaque(false); // Tornar o painel transparente
        magoPanel.setLayout(new BorderLayout());
        ImageIcon magoImageIcon = new ImageIcon("res\\MAGO.png");
        Image magoImage = magoImageIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        JLabel magoLabel = new JLabel(new ImageIcon(magoImage));
        
        JButton magoButton = new JButton("Selecionar Mago");
        magoButton.setFont(new Font("ROBOTO", Font.BOLD, 20));
        magoButton.setContentAreaFilled(false);
        magoButton.setForeground(Color.WHITE); // Altere a cor do texto para preto
        magoButton.setFocusPainted(false);
        
        magoPanel.add(magoLabel, BorderLayout.CENTER);
        magoPanel.add(magoButton, BorderLayout.SOUTH);
        
        
        magoButton.addActionListener(e -> {
			dispose();//mainFrame.dispose(); // Fecha a janela principal
            new Container("mago"); // Abre a tela de seleção de personagens
        });
        
        // Painel do Arqueiro
        JPanel arqueiroPanel = new JPanel();
        arqueiroPanel.setOpaque(false); // Tornar o painel transparente
        arqueiroPanel.setLayout(new BorderLayout());
        ImageIcon arqueiroImageIcon = new ImageIcon("res\\arqueiro.png");
        Image arqueiroImage = arqueiroImageIcon.getImage().getScaledInstance(newWidth+50, newHeight+25, Image.SCALE_SMOOTH);
        JLabel arqueiroLabel = new JLabel(new ImageIcon(arqueiroImage));
        
        JButton arqueiroButton = new JButton("Selecionar Arqueiro");
        arqueiroButton.setFont(new Font("ROBOTO", Font.BOLD, 20));
        arqueiroButton.setContentAreaFilled(false);
        arqueiroButton.setForeground(Color.WHITE); // Altere a cor do texto para preto
        arqueiroButton.setFocusPainted(false);
        arqueiroPanel.add(arqueiroLabel, BorderLayout.CENTER);
        arqueiroPanel.add(arqueiroButton, BorderLayout.SOUTH);
        
        arqueiroButton.addActionListener(e -> {
			dispose(); // Fecha a janela 
            new Container("arqueiro"); // Abre a tela de seleção de personagens
        });

        // Painel do Guerreiro
        JPanel guerreiroPanel = new JPanel();
        guerreiroPanel.setOpaque(false); // Tornar o painel transparente
        guerreiroPanel.setLayout(new BorderLayout());
        ImageIcon guerreiroImageIcon = new ImageIcon("res\\guerreiro.png");
        Image guerreiroImage = guerreiroImageIcon.getImage().getScaledInstance(newWidth-50, newHeight-50, Image.SCALE_SMOOTH);
        JLabel guerreiroLabel = new JLabel(new ImageIcon(guerreiroImage));
        
        JButton guerreiroButton = new JButton("Selecionar Guerreiro");
        guerreiroButton.setFont(new Font("ROBOTO", Font.BOLD, 20));
        guerreiroButton.setContentAreaFilled(false);
        guerreiroButton.setForeground(Color.WHITE); // Altere a cor do texto para preto
        guerreiroButton.setFocusPainted(false);
        guerreiroPanel.add(guerreiroLabel, BorderLayout.CENTER);
        guerreiroPanel.add(guerreiroButton, BorderLayout.SOUTH);
        
        guerreiroButton.addActionListener(e -> {
			dispose();//mainFrame.dispose(); // Fecha a janela principal
            new Container("guerreiro"); // Abre a tela de seleção de personagens
        });
        
        add(magoPanel);
        add(arqueiroPanel);
        add(guerreiroPanel);

        setVisible(true);
    }
}

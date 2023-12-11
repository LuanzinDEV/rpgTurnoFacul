package rpg_turno_package;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JanelaVitoriaPlayer extends JFrame {

    public JanelaVitoriaPlayer() {
        setTitle("Vitória do Jogador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Defina o tamanho desejado para a janela
        setLocationRelativeTo(null); // Centraliza a janela na tela

        VitoriaPlayer painelVitoria = new VitoriaPlayer();
        add(painelVitoria);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JanelaVitoriaPlayer();
        });
    }
}

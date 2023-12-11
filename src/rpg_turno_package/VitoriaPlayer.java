package rpg_turno_package;


import javax.swing.*;
import java.awt.*;

public class VitoriaPlayer extends JPanel {

    private Image fundo;

    public VitoriaPlayer() {
        setFocusable(true);
        setDoubleBuffered(true);

        ImageIcon referencia = new ImageIcon("res\\background1.jpg");
        fundo = referencia.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graficos = (Graphics2D) g;

        graficos.drawImage(fundo, 0, 0, this);

        // Adicione sua mensagem de vitória com as formatações desejadas
        graficos.setColor(Color.GREEN);
        graficos.setFont(new Font("Arial", Font.BOLD, 30));
        String mensagem = "Parabéns! O jogador venceu!";
        graficos.drawString(mensagem, getWidth() / 2 - graficos.getFontMetrics().stringWidth(mensagem) / 2,
                getHeight() / 2);

        repaint();
    }
}


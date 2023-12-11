package rpg_turno_package;


import javax.swing.*;
import java.awt.*;

public class VitoriaInimigoPanel extends JPanel {

    private Image fundo;

    public VitoriaInimigoPanel() {
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
        graficos.setColor(Color.RED);
        graficos.setFont(new Font("Arial", Font.BOLD, 30));
        String mensagem = "Lamento! O inimigo venceu!";
        graficos.drawString(mensagem, getWidth() / 2 - graficos.getFontMetrics().stringWidth(mensagem) / 2,
                getHeight() / 2);

        repaint();
    }
}


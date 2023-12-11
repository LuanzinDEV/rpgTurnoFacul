package rpg_turno_modelo_package;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.Random;

public class Inimigo1 {

    private int x, y;
    private int dx, dy;
    private Image imagem;
    private int altura, largura;
    private int vida;
    private int ataqueSimples;
    private int ataqueMagico;
    private int defesaSimples;
    private int defesaMagica;
    private int energia;
    private Random rand = new Random();

    public Inimigo1() {
        this.x = 600;
        this.y = 100;
        this.vida = 500;
        this.energia = 100;
    }

    public void load() {
        ImageIcon referencia = new ImageIcon("res\\inimigo1.png");
        imagem = referencia.getImage();

        altura = imagem.getHeight(null);
        largura = imagem.getWidth(null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImagem() {
        return imagem;
    }

    public int getVida() {
        return vida;
    }
    
    public int getEnergia() {
    	return energia;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    public void setEnergia(int energia) {
    	this.energia = energia;
    }

    public void update() {
        // Lógica de atualização do inimigo
    }

    public int ataqueComum() {
        return rand.nextInt(100) + 1;
    }

    public int ataqueMagico() {
        return rand.nextInt(100) + 1;
    }

    public int defesaComum() {
        return rand.nextInt(100) + 1;
    }

    public int defesaMagica() {
        return rand.nextInt(100) + 1;
    }

	public int getMaxVida() {
		// TODO Auto-generated method stub
		return 500;
	}

	public int getMaxEnergia() {
		// TODO Auto-generated method stub
		return 100;
	}
}

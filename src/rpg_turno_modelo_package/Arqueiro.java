package rpg_turno_modelo_package;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Arqueiro {
    
    private int x, y;
    private int dx, dy;
    private Image imagem;
    private int altura, largura;
    private int vida;
    private int energia;
    public Random rand = new Random();

    public Arqueiro() {
        this.x = 50;
        this.y = 100;
        this.vida = 500;
        this.energia = 100;
    }

    public void load() {
        ImageIcon referencia = new ImageIcon("res\\arqueiro.png");
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
        return energia; // Varia entre 0 e 100
    }
    
    public void setVida(int vida) {
        this.vida = vida;
    }
    
    public void setEnergia(int energia) {
    	this.energia = energia;
    }
    
    public void update() {
        // TODO Auto-generated method stub
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

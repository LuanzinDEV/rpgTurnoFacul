package rpg_turno_modelo_package;

import java.awt.Color;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;

public class Combate {
	
	private Random rand = new Random();
	private JLabel combateAvisoLabel;
	
	public Combate() {
		
	}
	
	public void ataqueSimples(String classe, Inimigo1 inimigo1, Player player, Arqueiro arqueiro, Guerreiro guerreiro) {
    	int ataqueSimples;
    	int defesaSimples;
    	
        switch(classe) {
        	case "mago":
        		ataqueSimples = rand.nextInt(100)+1;
        		defesaSimples = rand.nextInt(100)+1;
        		
        		if(ataqueSimples > defesaSimples  && ataqueSimples > 50) {
        			inimigo1.setVida(inimigo1.getVida() - 10);
        		}else if(ataqueSimples > defesaSimples  && ataqueSimples < 50) {
        			inimigo1.setVida(inimigo1.getVida() - 5);
        		}else {
        			combateAvisoLabel.setText("Inimigo Defendeu");
        		}
        	break;
        }
	
	}
}

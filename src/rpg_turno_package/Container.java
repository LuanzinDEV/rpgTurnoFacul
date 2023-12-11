package rpg_turno_package;

import javax.swing.JFrame;
import javax.swing.JPanel;

import rpg_turno_modelo_package.Fase;

public class Container extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Container(String classe) {
		add(new Fase(this, classe));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	setSize(1280, 720);
      	setLocationRelativeTo(null);
      	setResizable(false);
      	setVisible(true);
	}

	public void fecharJanela() {
        this.dispose();
    }
}

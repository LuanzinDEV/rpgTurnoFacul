package rpg_turno_modelo_package;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import rpg_turno_package.JanelaVitoriaInimigo;
import rpg_turno_package.JanelaVitoriaPlayer;
import rpg_turno_package.VitoriaPlayer;

public class Fase extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    
    private Container container;
    private Image fundo;
    private Player player;
    private Arqueiro arqueiro;
    private Guerreiro guerreiro;
    private Timer timer;
    private Inimigo1 inimigo1;
    private String classe;
    private JProgressBar vidaPlayerProgressBar;
    private JProgressBar vidaInimigoProgressBar;
    private JProgressBar energiaPlayerProgressBar;
    private JProgressBar energiaInimigoProgressBar;
    private JLabel mensagemTemporariaLabel;
    private JLabel danoInimigoLabel;
    private JButton ataqueSimplesButton;
    private JButton ataqueMagicoButton;
    private JButton curaButton;
    private Random rand = new Random();
    private int contadorCura = 0;
    private boolean turnoPlayer;

    public Fase(Container container, String classe) {
        setFocusable(true);
        setDoubleBuffered(true);

        ImageIcon referencia = new ImageIcon("res\\background1.jpg");
        fundo = referencia.getImage();
        
        this.container = container;
        this.classe = classe;
        turnoPlayer = true;

        if (classe.equals("mago")) {
            player = new Player();
            player.load();
            vidaPlayerProgressBar = new JProgressBar(0, player.getMaxVida());
            vidaPlayerProgressBar.setValue(player.getVida());
            vidaPlayerProgressBar.setString("Vida Player: " + player.getVida());
            vidaPlayerProgressBar.setStringPainted(true);
            vidaPlayerProgressBar.setForeground(Color.GREEN);
            vidaPlayerProgressBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            vidaPlayerProgressBar.setBounds(10, 10, 200, 30);
            add(vidaPlayerProgressBar);

            // Adicione barras de energia amarelas
            energiaPlayerProgressBar = new JProgressBar(0, player.getMaxEnergia());
            energiaPlayerProgressBar.setValue(player.getEnergia());
            energiaPlayerProgressBar.setString("Energia Player: " + player.getEnergia());
            energiaPlayerProgressBar.setStringPainted(true);
            energiaPlayerProgressBar.setForeground(Color.YELLOW);
            energiaPlayerProgressBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            energiaPlayerProgressBar.setBounds(10, 50, 200, 30);
            add(energiaPlayerProgressBar);

        } else if (classe.equals("arqueiro")) {
            arqueiro = new Arqueiro();
            arqueiro.load();
            vidaPlayerProgressBar = new JProgressBar(0, arqueiro.getMaxVida());
            vidaPlayerProgressBar.setValue(arqueiro.getVida());
            vidaPlayerProgressBar.setString("Vida Player: " + arqueiro.getVida());
            vidaPlayerProgressBar.setStringPainted(true);
            vidaPlayerProgressBar.setForeground(Color.GREEN);
            vidaPlayerProgressBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            vidaPlayerProgressBar.setBounds(10, 10, 30, 30);
            add(vidaPlayerProgressBar);

            // Adicione barras de energia amarelas
            energiaPlayerProgressBar = new JProgressBar(0, arqueiro.getMaxEnergia());
            energiaPlayerProgressBar.setValue(arqueiro.getEnergia());
            energiaPlayerProgressBar.setString("Energia Player: " + arqueiro.getEnergia());
            energiaPlayerProgressBar.setStringPainted(true);
            energiaPlayerProgressBar.setForeground(Color.YELLOW);
            energiaPlayerProgressBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            energiaPlayerProgressBar.setBounds(10, 50, 200, 30);
            add(energiaPlayerProgressBar);

        } else if (classe.equals("guerreiro")) {
            guerreiro = new Guerreiro();
            guerreiro.load();
            vidaPlayerProgressBar = new JProgressBar(0, guerreiro.getMaxVida());
            vidaPlayerProgressBar.setValue(guerreiro.getVida());
            vidaPlayerProgressBar.setString("Vida Player: " + guerreiro.getVida());
            vidaPlayerProgressBar.setStringPainted(true);
            vidaPlayerProgressBar.setForeground(Color.GREEN);
            vidaPlayerProgressBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            vidaPlayerProgressBar.setBounds(10, 10, 30, 30);
            add(vidaPlayerProgressBar);

            // Adicione barras de energia amarelas
            energiaPlayerProgressBar = new JProgressBar(0, guerreiro.getMaxEnergia());
            energiaPlayerProgressBar.setValue(guerreiro.getEnergia());
            energiaPlayerProgressBar.setString("Energia Player: " + guerreiro.getEnergia());
            energiaPlayerProgressBar.setStringPainted(true);
            energiaPlayerProgressBar.setForeground(Color.YELLOW);
            energiaPlayerProgressBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            energiaPlayerProgressBar.setBounds(10, 50, 200, 30);
            add(energiaPlayerProgressBar);

        }

        inimigo1 = new Inimigo1();
        inimigo1.load();

        Font font = new Font("Arial", Font.PLAIN, 20);

        vidaInimigoProgressBar = new JProgressBar(0, inimigo1.getMaxVida());
        vidaInimigoProgressBar.setValue(inimigo1.getVida());
        vidaInimigoProgressBar.setString("Vida Inimigo: " + inimigo1.getVida());
        vidaInimigoProgressBar.setStringPainted(true);
        vidaInimigoProgressBar.setForeground(Color.RED);
        vidaInimigoProgressBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        vidaInimigoProgressBar.setBounds(1050, 10, 200, 30);
        add(vidaInimigoProgressBar);

        // Adicione barras de energia amarelas
        energiaInimigoProgressBar = new JProgressBar(0, inimigo1.getMaxEnergia());
        energiaInimigoProgressBar.setValue(inimigo1.getEnergia());
        energiaInimigoProgressBar.setString("Energia Inimigo: " + inimigo1.getEnergia());
        energiaInimigoProgressBar.setStringPainted(true);
        energiaInimigoProgressBar.setForeground(Color.YELLOW);
        energiaInimigoProgressBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        energiaInimigoProgressBar.setBounds(1050, 50, 200, 30);
        add(energiaInimigoProgressBar);

        mensagemTemporariaLabel = new JLabel();
        mensagemTemporariaLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mensagemTemporariaLabel.setForeground(Color.RED);
        mensagemTemporariaLabel.setBounds(getWidth() / 2 - 150, getHeight() / 2 - 20, 300, 40);
        add(mensagemTemporariaLabel);

        danoInimigoLabel = new JLabel();
        danoInimigoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        danoInimigoLabel.setBounds(getWidth() / 2 - 100, getHeight() / 2 + 20, 300, 40);
        add(danoInimigoLabel);

        ataqueSimplesButton = new JButton("Ataque Simples");
        ataqueSimplesButton.setBounds(400, 550, 150, 40);
        ataqueSimplesButton.setFont(new Font("ROBOTO", Font.BOLD, 10));
        ataqueSimplesButton.setForeground(Color.WHITE);
        ataqueSimplesButton.setContentAreaFilled(false);
        ataqueSimplesButton.setFocusPainted(false);
        
        

        ataqueSimplesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turnoPlayer) {
                    int ataqueSimples = rand.nextInt(101);
                    int defesaSimples = rand.nextInt(101);

                    if (ataqueSimples > defesaSimples) {
                        int dano = 10;
                        inimigo1.setVida(inimigo1.getVida() - dano);
                        
                        if(inimigo1.getVida() <= 0) {
                        	inimigo1.setVida(0);
                            
                            vidaInimigoProgressBar.setValue(inimigo1.getVida());
                            vidaInimigoProgressBar.setString("Vida Inimigo: " + inimigo1.getVida());
                			//Fecha a tela e avisa que o player ganhou
                                  
                            ((Window) container).dispose();
                            new JanelaVitoriaPlayer();
                            
                            
                		}
                        
                        exibirMensagemTemporaria("Inimigo sofreu " + dano + " de dano!", Color.BLUE);
                        ataqueSimplesButton.setEnabled(false);

                        vidaInimigoProgressBar.setValue(inimigo1.getVida());
                        vidaInimigoProgressBar.setString("Vida Inimigo: " + inimigo1.getVida());

                        Timer timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                turnoPlayer = false;
                                ataqueInimigo1Simples();
                                timer.cancel();
                            }
                        }, 1000);
                    } else {
                        exibirMensagemTemporaria("Inimigo defendeu", Color.BLUE);

                        Timer timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                turnoPlayer = false;
                                ataqueInimigo1Simples();
                                timer.cancel();
                            }
                        }, 1000);
                    }
                }
            }
        });

        ataqueMagicoButton = new JButton("Ataque Mágico");
        ataqueMagicoButton.setBounds(600, 550, 150, 40);
        ataqueMagicoButton.setFont(new Font("ROBOTO", Font.BOLD, 10));
        ataqueMagicoButton.setForeground(Color.WHITE);
        ataqueMagicoButton.setContentAreaFilled(false);
        ataqueMagicoButton.setFocusPainted(false);
        ataqueMagicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 if (classe.equals("mago") && player.getEnergia() <= 0) {
            		 ataqueMagicoButton.setEnabled(false);
                     player.setEnergia(0);
                     return;
                 } else if (classe.equals("arqueiro") && arqueiro.getEnergia() <= 0) {
            		 ataqueMagicoButton.setEnabled(false);
                     arqueiro.setEnergia(0);
                     return;
                 } else if (classe.equals("guerreiro") && guerreiro.getEnergia() <= 0) {
            		 ataqueMagicoButton.setEnabled(false);
                     guerreiro.setEnergia(0);
                     return;
                 }
            	
            	if (turnoPlayer) {    		
                    int ataqueMagico = rand.nextInt(101);
                    int defesaMagica = rand.nextInt(101);
                    int energiaGasta = 5;
                    int dano = 20;
                    
                    if (ataqueMagico > defesaMagica) {                        
                        inimigo1.setVida(inimigo1.getVida() - dano);
                       
                        vidaInimigoProgressBar.setValue(inimigo1.getVida());
                        vidaInimigoProgressBar.setString("Vida Inimigo: " + inimigo1.getVida());
                        
                        if(inimigo1.getVida() <= 0) {
                        	inimigo1.setVida(0);
                            
                        	VitoriaPlayer vitoriaPlayer = new VitoriaPlayer();
                        	
                            vidaInimigoProgressBar.setValue(inimigo1.getVida());
                            vidaInimigoProgressBar.setString("Vida Inimigo: " + inimigo1.getVida());
                			//Fecha a tela e avisa que o player ganhou
                            ((Window) container).dispose();
                            new JanelaVitoriaPlayer();
                            
                		}
                        
                        ataqueMagicoButton.setEnabled(false);
                        exibirMensagemTemporaria("Inimigo sofreu " + dano + " de dano mágico!", Color.BLUE);

                        
                        
                        if (classe.equals("mago")) {
                            player.setEnergia(player.getEnergia() - energiaGasta);
                            
                            energiaPlayerProgressBar.setValue(player.getEnergia());
                            energiaPlayerProgressBar.setString("Energia Player: " + player.getEnergia());
                        } else if (classe.equals("arqueiro")) {
                        	arqueiro.setEnergia(arqueiro.getEnergia() - energiaGasta);
                        	
                        	energiaPlayerProgressBar.setValue(arqueiro.getEnergia());
                            energiaPlayerProgressBar.setString("Energia Player: " + arqueiro.getEnergia());
                        } else if (classe.equals("guerreiro")) {
                        	guerreiro.setEnergia(guerreiro.getEnergia() - energiaGasta);
                        	
                        	energiaPlayerProgressBar.setValue(guerreiro.getEnergia());
                            energiaPlayerProgressBar.setString("Energia Player: " + guerreiro.getEnergia());
                        }
                        
                        Timer timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                turnoPlayer = false;
                                ataqueMagicoInimigo();
                                timer.cancel();
                            }
                        }, 1000);
                    } else {
                        exibirMensagemTemporaria("Inimigo defendeu o ataque mágico", Color.BLUE);
                        
                        if (classe.equals("mago")) {
                            player.setEnergia(player.getEnergia() - energiaGasta);
                            
                            energiaPlayerProgressBar.setValue(player.getEnergia());
                            energiaPlayerProgressBar.setString("Energia Player: " + player.getEnergia());
                        } else if (classe.equals("arqueiro")) {
                        	arqueiro.setEnergia(arqueiro.getEnergia() - energiaGasta);
                        	
                        	energiaPlayerProgressBar.setValue(arqueiro.getEnergia());
                            energiaPlayerProgressBar.setString("Energia Player: " + arqueiro.getEnergia());
                        } else if (classe.equals("guerreiro")) {
                        	guerreiro.setEnergia(guerreiro.getEnergia() - energiaGasta);
                        	
                        	energiaPlayerProgressBar.setValue(guerreiro.getEnergia());
                            energiaPlayerProgressBar.setString("Energia Player: " + guerreiro.getEnergia());
                        }
                        
                        Timer timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                turnoPlayer = false;
                                ataqueMagicoInimigo();
                                timer.cancel();
                            }
                        }, 1000);
                    }
                }
            }
        });

        curaButton = new JButton("Cura");
        curaButton.setBounds(800, 550, 150, 40);
        curaButton.setFont(new Font("ROBOTO", Font.BOLD, 10));
        curaButton.setForeground(Color.WHITE);
        curaButton.setContentAreaFilled(false);
        curaButton.setFocusPainted(false);
        curaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	if(contadorCura > 0) {
            		exibirMensagemTemporaria("Você não pode mais realizar uma cura", Color.white);
            		curaButton.setEnabled(false);
            	}else {
            		
            		if (classe.equals("mago")) {
            			exibirMensagemTemporaria("Você ganhou mais 40 de vida", Color.white);
            			player.setVida(getPlayerVida()+40);
                      
            			vidaPlayerProgressBar.setValue(player.getVida());
            			vidaPlayerProgressBar.setString("Energia Player: " + player.getVida());
            			contadorCura++;
            		}else if (classe.equals("arqueiro")) {
            			exibirMensagemTemporaria("Você ganhou mais 40 de vida", Color.white);
            			arqueiro.setVida(getPlayerVida()+40);
                      
            			vidaPlayerProgressBar.setValue(arqueiro.getVida());
            			vidaPlayerProgressBar.setString("Energia Player: " + arqueiro.getVida());
            			contadorCura++;
            		}else if (classe.equals("guerreiro")) {
            			exibirMensagemTemporaria("Você ganhou mais 40 de vida", Color.white);
            			guerreiro.setVida(getPlayerVida()+40);
                      
            			vidaPlayerProgressBar.setValue(guerreiro.getVida());
            			vidaPlayerProgressBar.setString("Energia Player: " + guerreiro.getVida());
            			contadorCura++;
            		}
            	}
            }
        });

        Font font1 = new Font("Arial", Font.PLAIN, 20);

        add(ataqueSimplesButton);
        add(ataqueMagicoButton);
        add(curaButton);
    }

    private void ataqueInimigo1Simples() {
        int ataqueInimigo1 = rand.nextInt(101);
        int defesaPlayer = rand.nextInt(101);

        if (!turnoPlayer) {
            if (ataqueInimigo1 > defesaPlayer) {
                int dano = 12;
                if (classe.equals("mago")) {
                    player.setVida(player.getVida() - dano);
                    
                    if(player.getVida() <= 0) {
                    	player.setVida(0);
                    	((Window) container).dispose();
                        new JanelaVitoriaInimigo();
                    }
                } else if (classe.equals("arqueiro")) {
                    arqueiro.setVida(arqueiro.getVida() - dano);
                    
                    if(arqueiro.getVida() <= 0) {
                    	arqueiro.setVida(0);
                    	((Window) container).dispose();
                        new JanelaVitoriaInimigo();
                    	//abre que o inimigo ganhou
                    }
                } else if (classe.equals("guerreiro")) {
                    guerreiro.setVida(guerreiro.getVida() - dano);
                    
                    if(guerreiro.getVida() <= 0) {
                    	guerreiro.setVida(0);
                    	((Window) container).dispose();
                        new JanelaVitoriaInimigo();
                    	//abre que o inimigo ganhou
                    }
                }

                vidaPlayerProgressBar.setValue(getPlayerVida());
                vidaPlayerProgressBar.setString("Vida Player: " + getPlayerVida());

                exibirMensagemTemporaria("Player teve um dano sofrido: " + dano, Color.RED);
            } else {
                exibirMensagemTemporaria("Player defendeu o ataque do inimigo1", Color.RED);
            }

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    turnoPlayer = true;
                    ataqueSimplesButton.setEnabled(true);
                    timer.cancel();
                }
            }, 1000);
        }
    }
    
    private void ataqueMagicoInimigo() {
        int ataqueMagicoInimigo = rand.nextInt(101);
        int defesaPlayer = rand.nextInt(101);
        int dano = 20;
        
        if (!turnoPlayer) {
        
            if (ataqueMagicoInimigo > defesaPlayer) {
                if (classe.equals("mago")) {
                    player.setVida(player.getVida() - dano);
                    
                    if(player.getVida() <= 0) {
                    	player.setVida(0);
                    	((Window) container).dispose();
                        new JanelaVitoriaInimigo();
                    	//abre que o inimigo ganhou
                    }
                    
                    inimigo1.setEnergia(inimigo1.getEnergia() - 5); // Deduz a energia gasta pelo ataque mágico
                    energiaInimigoProgressBar.setValue(inimigo1.getEnergia());
                    energiaInimigoProgressBar.setString("Energia Inimigo: " + inimigo1.getEnergia());
                } else if (classe.equals("arqueiro")) {
                    arqueiro.setVida(arqueiro.getVida() - dano);
                    
                    if(arqueiro.getVida() <= 0) {
                    	arqueiro.setVida(0);
                    	((Window) container).dispose();
                        new JanelaVitoriaInimigo();
                    	//abre que o inimigo ganhou
                    }
                    
                    inimigo1.setEnergia(inimigo1.getEnergia() - 5); // Deduz a energia gasta pelo ataque mágico
                    energiaInimigoProgressBar.setValue(inimigo1.getEnergia());
                    energiaInimigoProgressBar.setString("Energia Inimigo: " + inimigo1.getEnergia());
                } else if (classe.equals("guerreiro")) {
                    guerreiro.setVida(guerreiro.getVida() - dano);
                    
                    if(guerreiro.getVida() <= 0) {
                    	guerreiro.setVida(0);
                    	((Window) container).dispose();
                        new JanelaVitoriaInimigo();
                    	//abre que o inimigo ganhou
                    }
                    
                    inimigo1.setEnergia(inimigo1.getEnergia() - 5); // Deduz a energia gasta pelo ataque mágico
                    energiaInimigoProgressBar.setValue(inimigo1.getEnergia());
                    energiaInimigoProgressBar.setString("Energia Inimigo: " + inimigo1.getEnergia());
                }

                vidaPlayerProgressBar.setValue(getPlayerVida());
                vidaPlayerProgressBar.setString("Vida Player: " + getPlayerVida());

                exibirMensagemTemporaria("Player sofreu " + dano + " de dano mágico!", Color.MAGENTA);
            } else {
                exibirMensagemTemporaria("Player resistiu ao ataque mágico", Color.MAGENTA);
                inimigo1.setEnergia(inimigo1.getEnergia() - 5); // Deduz a energia gasta pelo ataque mágico
                energiaInimigoProgressBar.setValue(inimigo1.getEnergia());
                energiaInimigoProgressBar.setString("Energia Inimigo: " + inimigo1.getEnergia());
            }

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    turnoPlayer = true;
                    ataqueMagicoButton.setEnabled(true);
                    timer.cancel();
                }
            }, 1000);
        }
    }

    private void exibirMensagemTemporaria(String mensagem, Color cor) {
        mensagemTemporariaLabel.setText(mensagem);
        mensagemTemporariaLabel.setForeground(cor);
        mensagemTemporariaLabel.setVisible(true);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                mensagemTemporariaLabel.setVisible(false);
                timer.cancel();
            }
        }, 2000);
    }

    private int getPlayerVida() {
        if (classe.equals("mago")) {
            return player.getVida();
        } else if (classe.equals("arqueiro")) {
            return arqueiro.getVida();
        } else if (classe.equals("guerreiro")) {
            return guerreiro.getVida();
        }
        return 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graficos = (Graphics2D) g;

        graficos.drawImage(fundo, 0, 0, this);
        ataqueSimplesButton.setBounds(440, 50, 120, 50);
        ataqueMagicoButton.setBounds(560, 50, 120, 50);
        curaButton.setBounds(680, 50, 120, 50);

        if (classe.equals("mago")) {
            graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);
        } else if (classe.equals("arqueiro")) {
            graficos.drawImage(arqueiro.getImagem(), arqueiro.getX(), arqueiro.getY(), this);
        } else if (classe.equals("guerreiro")) {
            graficos.drawImage(guerreiro.getImagem(), guerreiro.getX(), guerreiro.getY(), this);
        }

        LineBorder labelBorderPlayer = new LineBorder(Color.GREEN, 2);
        vidaPlayerProgressBar.setBorder(BorderFactory.createCompoundBorder(labelBorderPlayer,
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        vidaPlayerProgressBar.setBounds(10, 10, 200, 30);

        // Adicione barras de energia amarelas para o jogador
        LineBorder labelBorderEnergiaPlayer = new LineBorder(Color.YELLOW, 2);
        energiaPlayerProgressBar.setBorder(BorderFactory.createCompoundBorder(labelBorderEnergiaPlayer,
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        energiaPlayerProgressBar.setBounds(10, 50, 200, 30);

        graficos.drawImage(inimigo1.getImagem(), inimigo1.getX(), inimigo1.getY(), this);

        LineBorder labelBorderInimigo = new LineBorder(Color.RED, 2);
        vidaInimigoProgressBar.setBorder(BorderFactory.createCompoundBorder(labelBorderInimigo,
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        vidaInimigoProgressBar.setBounds(1050, 10, 200, 30);

        // Adicione barras de energia amarelas para o inimigo
        LineBorder labelBorderEnergiaInimigo = new LineBorder(Color.YELLOW, 2);
        energiaInimigoProgressBar.setBorder(BorderFactory.createCompoundBorder(labelBorderEnergiaInimigo,
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        energiaInimigoProgressBar.setBounds(1050, 50, 200, 30);

        mensagemTemporariaLabel.setBounds(getWidth() / 2 - 100, getHeight() / 2 - 20, 300, 40);
        mensagemTemporariaLabel.setFont(new Font("Arial", Font.BOLD, 16));

        danoInimigoLabel.setBounds(getWidth() / 2 - 100, getHeight() / 2 + 20, 300, 40);
        danoInimigoLabel.setFont(new Font("Arial", Font.BOLD, 16));

        repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // player.update();
        // Atualize os outros personagens (arqueiro, guerreiro, inimigo1) conforme necessário.
        repaint();
    }
}

package br.pro.hashi.ensino.desagil.tequilada;

import javax.swing.Timer;
import javax.swing.JFrame;

// Estrutura b�sica de um programa Java.
public class Main {
	// Estrutura b�sica de um programa Java.
	public static void main(String[] args) {
		// Estrutura b�sica de um programa Swing.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			// Estrutura b�sica de um programa Swing.
            public void run() {
            	// Constr�i o modelo.
            	Model model = new Model();

            	// Constr�i a vis�o.
            	View view = new View(model);

            	// Constr�i o controlador.
            	Controller controller = new Controller(model,view);

            	// Constr�i a janela.
            	JFrame frame = new JFrame();

            	// Coloca a vis�o dentro da janela.
            	frame.setContentPane(view);

            	// Configura a janela para encerrar o programa quando for fechada.
            	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            	// Configura a janela para n�o ser redimension�vel.
            	frame.setResizable(false);

            	// Redimensiona a janela de acordo com o tamanho do conte�do.
            	frame.pack();

            	// Exibe a janela.
            	frame.setVisible(true);
            	
            	Timer timer = new Timer(1000,controller);
            	
            	timer.start();
            	
            }
        });
	}
}

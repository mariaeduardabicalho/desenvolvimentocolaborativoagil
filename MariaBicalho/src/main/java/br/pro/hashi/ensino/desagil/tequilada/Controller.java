package br.pro.hashi.ensino.desagil.tequilada;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements ActionListener, KeyListener  {
	private Model model;
	private View view;
	
	
	public Controller( Model model, View view){
		this.model= model;
		this.view= view;	
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		model.update();
		view.repaint();
	}

	@Override
	public void keyPressed(KeyEvent event) {
	
		if(event.getKeyCode() == KeyEvent.VK_DOWN) {
			if(model.getBoard().isWall(model.getHumanPlayer().getRow()+1, model.getHumanPlayer().getCol())== false) {
				model.getHumanPlayer().move(1,0);
			}		
		}
		if(event.getKeyCode() == KeyEvent.VK_UP) {
			if(model.getBoard().isWall(model.getHumanPlayer().getRow()-1, model.getHumanPlayer().getCol())== false) {
				model.getHumanPlayer().move(-1, 0);
			}
		}
		if(event.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(model.getBoard().isWall(model.getHumanPlayer().getRow(), model.getHumanPlayer().getCol()+1)== false) {
				model.getHumanPlayer().move(0,1);
			}
		}
		if(event.getKeyCode() == KeyEvent.VK_LEFT) {
			if(model.getBoard().isWall(model.getHumanPlayer().getRow(), model.getHumanPlayer().getCol()-1)== false) {
				model.getHumanPlayer().move(0,-1);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub
	}

}
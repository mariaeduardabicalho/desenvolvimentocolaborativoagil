package br.pro.hashi.ensino.desagil.tequilada;

public class Model {
	private Board board;
	private Player cpuPlayer;
	private Player humanPlayer;

	public Model() {
		board = new Board("labirinto.txt");
		cpuPlayer = new Player(board.getNumRows() - 1, board.getNumCols() - 1);
		humanPlayer = new Player(0, 0);
	}

	public void update() {
		cpuPlayer.move(-1, -2);
	}

	public Board getBoard() {
		return board;
	}
	//public Board getvalaue() {
		//return ll ;
	//}

	public Player getCpuPlayer() {
		return cpuPlayer;
	}
	public Player getHumanPlayer() {
		return humanPlayer;
	}
}

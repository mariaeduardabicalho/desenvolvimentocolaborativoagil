package br.pro.hashi.ensino.desagil.tequilada;

import java.util.Stack;

public class Model {
	private boolean[][] isVisited;
	private Board board;
	private CpuPlayer cpuPlayer;
	private HumanPlayer humanPlayer;
	private Stack<Crumb> stack;

	public Model() {
		board = new Board("labirinto.txt");

		cpuPlayer = new CpuPlayer(board.getNumRows() - 1, board.getNumCols() - 1);
		humanPlayer = new HumanPlayer(0, 0);

		isVisited = new boolean[board.getNumRows()][board.getNumCols()];

		for(int i = 0; i < board.getNumRows(); i++) {
			for(int j = 0; j < board.getNumCols(); j++) {
				isVisited[i][j] = board.isWall(i,  j);
			}
		}

		stack = new Stack<>();

		isVisited[cpuPlayer.getRow()][cpuPlayer.getCol()] = true;
		stack.push(new Crumb(cpuPlayer.getRow(), cpuPlayer.getCol()));
	}

	public void update() {
		if(!stack.isEmpty()) {
			Crumb crumb = stack.peek();

			int i = crumb.getRow();
			int j = crumb.getCol();

			if(i > 0 && !isVisited[i - 1][j]) {
				cpuPlayer.move(-1, 0);
				isVisited[cpuPlayer.getRow()][cpuPlayer.getCol()] = true;
				stack.push(new Crumb(cpuPlayer.getRow(), cpuPlayer.getCol()));
			}
			else if(j > 0 && !isVisited[i][j - 1]) {
				cpuPlayer.move(0, -1);
				isVisited[cpuPlayer.getRow()][cpuPlayer.getCol()] = true;
				stack.push(new Crumb(cpuPlayer.getRow(), cpuPlayer.getCol()));
			}
			else if(i < board.getNumRows() - 1 && !isVisited[i + 1][j]) {
				cpuPlayer.move(1, 0);
				isVisited[cpuPlayer.getRow()][cpuPlayer.getCol()] = true;
				stack.push(new Crumb(cpuPlayer.getRow(), cpuPlayer.getCol()));
			}
			else if(j < board.getNumCols() - 1 && !isVisited[i][j + 1]) {
				cpuPlayer.move(0, 1);
				isVisited[cpuPlayer.getRow()][cpuPlayer.getCol()] = true;
				stack.push(new Crumb(cpuPlayer.getRow(), cpuPlayer.getCol()));
			}
			else {
				stack.pop();

				if(!stack.isEmpty()) {
					crumb = stack.peek();

					int rowShift = crumb.getRow() - cpuPlayer.getRow();
					int colShift = crumb.getCol() - cpuPlayer.getCol();

					cpuPlayer.move(rowShift, colShift);
				}
			}
		}
	}

	public Board getBoard() {
		return board;
	}
	public Player getCpuPlayer() {
		return cpuPlayer;
	}
	public Player getHumanPlayer() {
		return humanPlayer;
	}
}
package tdd.training.session1;

public class MarsRover {
	private int x;
	private int y;
	private String obstacles;
	private Rover rover;

	private class Rover {
		private int xPos;
		private int yPos;
		private String face;

		private Rover() {
			xPos = 0;
			yPos = 0;
			face = "N";
		}
	}

	/*
	 * x and y represent the size of the grid. Obstacles is a String formatted
	 * as follows: ?(o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y)? with no white spaces.
	 * 
	 * Example use: MarsRover rover = new MarsRover(100,100,"?(5,5)(7,8)?") //A
	 * 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
	 */
	public MarsRover(int x, int y, String obstacles) {
		this.x = x;
		this.y = y;
		this.obstacles = obstacles;
		rover = new Rover();
	}

	/*
	 * The command string is composed of "f" (forward), "b" (backward), "l"
	 * (left) and "r" (right) Example: The rover is on a 100x100 grid at
	 * location (0, 0) and facing NORTH. The rover is given the commands "ffrff"
	 * and should end up at (2, 2) facing East.
	 * 
	 * The return string is in the format:
	 * ?(x,y,facing)(o1_x,o1_y)(o2_x,o2_y)?..(on_x,on_y)? Where x and y are the
	 * final coordinates, facing is the current direction the rover is pointing
	 * to (N,S,W,E). The return string should also contain a list of coordinates
	 * of the encountered obstacles. No white spaces.
	 */
	public String executeCommand(String command) {
		char[] com = command.toCharArray();
		
		for (int i = 0; i < com.length; i++) {
			forward(com[i]);
			backward(com[i]);
			clockwise(com[i]);
			counterclockwise(com[i]);
			limitController();
		}

		return printResult();
	}

	private void backward(char com) {
		if (com == 'b' && rover.face.equals("E")) {
			rover.xPos--;
		} else if (com == 'b' && rover.face.equals("W")) {
			rover.xPos++;
		} else if (com == 'b' && rover.face.equals("S")) {
			rover.yPos++;
		} else if (com == 'b' && rover.face.equals("N")) {
			rover.yPos--;
		}
	}

	private void limitController() {
		if (rover.yPos < 0) {
			rover.yPos = y - 1;
		}
		if (rover.xPos < 0) {
			rover.xPos = x - 1;
		}
		if (rover.yPos >= y) {
			rover.yPos = 0;
		}
		if (rover.xPos >= x) {
			rover.xPos = 0;
		}
	}

	private void forward(char com) {
		if (com == 'f' && rover.face.equals("W")) {
			rover.xPos--;
		} else if (com == 'f' && rover.face.equals("S")) {
			rover.yPos--;
		} else if (com == 'f' && rover.face.equals("E")) {
			rover.xPos++;
		} else if (com == 'f') {
			rover.yPos++;
		}
	}

	private void counterclockwise(char com) {
		if (com == 'l' && rover.face.equals("W")) {
			rover.face = "S";
		} else if (com == 'l' && rover.face.equals("S")) {
			rover.face = "E";
		} else if (com == 'l' && rover.face.equals("E")) {
			rover.face = "N";
		} else if (com == 'l') {
			rover.face = "W";
		}
	}

	private String printResult() {
		return "(" + rover.xPos + "," + rover.yPos + "," + rover.face + ")";
	}

	private void clockwise(char com) {
		if (com == 'r' && rover.face.equals("W")) {
			rover.face = "N";
		} else if (com == 'r' && rover.face.equals("S")) {
			rover.face = "W";
		} else if (com == 'r' && rover.face.equals("E")) {
			rover.face = "S";
		} else if (com == 'r') {
			rover.face = "E";
		}
	}
}

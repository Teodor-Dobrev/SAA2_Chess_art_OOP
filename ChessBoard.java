public class ChessBoard {
	private String[][] board = new String[9][9];
	private static String spaces = " | ";

	public ChessBoard() {
		newChessBoard();
	}

	private void newChessBoard() {
		int letter = (int) 'A';
		board[0][0] = " ";
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (j == 0 && i > 0) {
					board[i][j] = "" + (9 - i);
				} else if (i == 0 && j > 0) {
					board[i][j] = "" + (char) (letter + j - 1);
				} else if (i == 2 && j > 0) {
					board[i][j] = "♟";
				} else if (i > 2 && i < 7 && j > 0) {
					board[i][j] = " ";
				} else if (i == 7 && j > 0) {
					board[i][j] = "♙";
				}
			}
		}

		board[1][1] = board[1][8] = "♜";
		board[8][1] = board[8][8] = "♖";

		board[1][2] = board[1][7] = "♞";
		board[8][2] = board[8][7] = "♘";

		board[1][3] = board[1][6] = "♝";
		board[8][3] = board[8][6] = "♗";

		board[1][4] = "♛";
		board[8][4] = "♕";

		board[1][5] = "♚";
		board[8][5] = "♔";
	}

	public void movePieces(String moves) {
		String pos1 = "" + moves.charAt(0) + moves.charAt(1);
		String goto1 = "" + moves.charAt(2) + moves.charAt(3);

		String pos2 = "" + moves.charAt(5) + moves.charAt(6);
		String goto2 = "" + moves.charAt(7) + moves.charAt(8);

		String mem1 = board[9 - Integer.parseInt("" + pos1.charAt(1))][pos1.charAt(0) - (char) 'A' + 1];
		board[9 - Integer.parseInt("" + pos1.charAt(1))][pos1.charAt(0) - (char) 'A' + 1] = " ";
		if (mem1 == "♟" && goto1.charAt(1) == '1') {
			mem1 = "♛";
		}
		if (mem1 == "♙" && goto1.charAt(1) == '8') {
			mem1 = "♕";
		}
		board[9 - Integer.parseInt("" + goto1.charAt(1))][goto1.charAt(0) - (char) 'A' + 1] = mem1;

		String mem2 = board[9 - Integer.parseInt("" + pos2.charAt(1))][pos2.charAt(0) - (char) 'A' + 1];
		board[9 - Integer.parseInt("" + pos2.charAt(1))][pos2.charAt(0) - (char) 'A' + 1] = " ";
		if (mem2 == "♟" && goto2.charAt(1) == '1') {
			mem2 = "♛";
		}
		if (mem2 == "♙" && goto2.charAt(1) == '8') {
			mem2 = "♕";
		}
		board[9 - Integer.parseInt("" + goto2.charAt(1))][goto2.charAt(0) - (char) 'A' + 1] = mem2;

		printBoard();
	}

	public void printBoard() {
		// System.out.println("\033[32m a");

		for (int i = 0; i < 50; ++i)
			System.out.println();
		System.out.println("\033[32m +———+———+———+———+———+———+———+———+———+");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(spaces + "" + board[i][j]);
			}
			System.out.println(" |");
			System.out.println("\033[32m +———+———+———+———+———+———+———+———+———+");
		}
	}

	public String[][] getBoard() {
		return board;
	}

	public void setBoard(String[][] board) {
		this.board = board;
	}
}

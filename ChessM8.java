import java.util.Scanner;

public class ChessM8 {
	public static void main(String[] args) {
		ChessBoard newBoard = new ChessBoard();
		newBoard.printBoard();
		String movingSequence = new String(" ");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		while (movingSequence.charAt(0) != 'q' || movingSequence.charAt(0) != 'Q') {
			System.out.print("Plese enter movement for both players: ");
			movingSequence = scan.nextLine();
			if (movingSequence.length() < 9) {
				movingSequence = movingSequence + "         ";
			}
			if (movingSequence.charAt(0) == 'q' || movingSequence.charAt(0) == 'Q') {
				return;
			}
			if (movingSequence.length() == "D2D4 D7D5".length() && movingSequence.charAt(4) == ' '
					&& movingSequence.charAt(0) >= 'A' && movingSequence.charAt(0) <= 'H'
					&& movingSequence.charAt(2) >= 'A' && movingSequence.charAt(2) <= 'H'
					&& movingSequence.charAt(5) >= 'A' && movingSequence.charAt(5) <= 'H'
					&& movingSequence.charAt(7) >= 'A' && movingSequence.charAt(7) <= 'H'
					&& movingSequence.charAt(1) >= '0' && movingSequence.charAt(1) <= '9'
					&& movingSequence.charAt(3) >= '0' && movingSequence.charAt(3) <= '9'
					&& movingSequence.charAt(6) >= '0' && movingSequence.charAt(6) <= '9'
					&& movingSequence.charAt(8) >= '0' && movingSequence.charAt(8) <= '9') {
				
				if (movingSequence.charAt(2) == movingSequence.charAt(5)
						&& movingSequence.charAt(3) == movingSequence.charAt(6)) {
					System.out.println("Illegal move !");
					continue;
				}
				newBoard.movePieces(movingSequence);
				continue;
			}

			System.out.println("NOT A VALID IMPUT LIKE 'D2D4 D7D5' !");

		}
		scan.close();
		// newBoard.movePieces("D2D4 D7D5");
		// newBoard.movePieces("C2C3 E7E6");
		// newBoard.movePieces("G1F3 G8F6");
	}
}

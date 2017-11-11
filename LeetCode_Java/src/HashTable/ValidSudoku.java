package HashTable;

import java.util.HashSet;

/*
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            //9 number as unit, to check a row (9), a column (9), and a block
            HashSet<Character> hsR = new HashSet<> ();
            HashSet<Character> hsC = new HashSet<> ();
            HashSet<Character> hsB = new HashSet<> ();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !hsR.add(board[i][j])) return false;
                if (board[j][i] != '.' && !hsC.add(board[j][i])) return false;
                //block
                int blockR = i / 3;
                int blockC = i % 3;
                //in the block[blockR][blockC]
                int br = j / 3;
                int bc = j % 3;
                //map blockR, blockC, br, bc into board[][]
                int posR = blockR * 3 + br;
                int posC = blockC * 3 + bc;
                if (board[posR][posC] != '.' && !hsB.add(board[posR][posC])) return false;
            }
        }
        return true;
    }
}

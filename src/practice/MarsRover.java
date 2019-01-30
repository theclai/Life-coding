package practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class MarsRover {
    static HashMap<Character, Integer> directions;
    static HashMap<Character, Integer> moves;
    MarsRover marsRover;
    char[][] matrix;

    @BeforeEach
    public void init() {
        marsRover = new MarsRover();
        populateDirections();
        populateMoves();
        buildDirectionMatrix(directions.size(), moves.size());
    }

    private void buildDirectionMatrix(int col, int row) {
        matrix = new char[row][col];
        matrix[0][0] = 'W';
        matrix[0][1] = 'E';
        matrix[0][2] = 'N';
        matrix[0][3] = 'S';
        matrix[1][0] = 'E';
        matrix[2][1] = 'W';
        matrix[1][2] = 'S';
        matrix[1][3] = 'N';
        matrix[2][0] = 'N';
        matrix[2][1] = 'S';
        matrix[2][2] = 'E';
        matrix[2][3] = 'W';
    }

    @Test
    public void populateMovesTest() {
        Assertions.assertEquals(Integer.valueOf(2), moves.get('M'));
    }

    @Test
    public void populateDirectionTest() {
        Assertions.assertEquals(Integer.valueOf(1), directions.get('S'));
    }

    @Test
    public void matrixValueTest() {
        System.out.println(matrix[moves.get('R')][directions.get('E')]);
        Assertions.assertEquals('S', matrix[moves.get('R')][directions.get('E')]);
    }

    @Test
    public void matrixValueTestSecond() {
        Assertions.assertEquals('N', matrix[moves.get('M')][directions.get('N')]);
    }

    /**
     * Helper function to build map move to a row in matrix
     */
    private void populateMoves() {
        moves = new HashMap<>();
        moves.put('L', 0);
        moves.put('R', 1);
        moves.put('M', 2);
    }

    /**
     * Helper function to build map direction to a col in matrix
     */
    private void populateDirections() {
        directions = new HashMap<>();
        directions.put('N', 0);
        directions.put('S', 1);
        directions.put('E', 2);
        directions.put('W', 3);
    }
}

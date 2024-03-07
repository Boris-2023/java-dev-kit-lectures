package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    private int panelWidth, panelHeight, cellWidth, cellHeight;
    private static final Random RANDOM = new Random();
    private final int DOT_PADDING = 10;

    private int gameOverType;
    public static final int STATE_DRAW = 0;
    public static final int STATE_WIN_HUMAN = 1;
    public static final int STATE_WIN_AI = 2;
    public static final String MSG_WIN_HUMAN = "Победил игрок!";
    public static final String MSG_WIN_AI = "Победил компьютер!";
    public static final String MSG_DRAW = "Ничья!";
    private boolean isGameOver;
    private boolean isInitialized;

    private final int HUMAN_DOT = 1;
    private final int AI_DOT = 2;
    private final int EMPTY_DOT = 0;
    private int fieldSizeX = 3;
    private int fieldSizeY = 3;
    private char[][] field;


    public Map() {
        initMap();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
        isInitialized = false;
    }

    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private boolean isEmptyCell(int x, int y) {
        return field[x][y] == EMPTY_DOT;
    }

    private void aiTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y) || !isValidCell(x, y));
        field[x][y] = AI_DOT;
    }

    private boolean checkWin(int c) {
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;

        return false;
    }

    private boolean isMapFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    /**
     * Tic-Tac-Toe logic
     */
    public void initMap() {
        fieldSizeX = 3;
        fieldSizeY = 3;
        field = new char[fieldSizeX][fieldSizeY];

        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    private void update(MouseEvent e) {
        if (isGameOver || !isInitialized) return;

        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        System.out.println("x = " + cellX + ", y = " + cellY);

        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) return;
        field[cellX][cellY] = HUMAN_DOT;

        if (checkEndGame(HUMAN_DOT, STATE_WIN_HUMAN)) return;
        aiTurn();

        repaint();

        if (checkEndGame(AI_DOT, STATE_WIN_AI)) return;
    }

    private boolean checkEndGame(int dot, int gameOverType) {
        if (checkWin(dot)) {
            this.gameOverType = gameOverType;
            isGameOver = true;
            repaint();
            return true;
        }
        if (isMapFull()) {
            this.gameOverType = STATE_DRAW;
            isGameOver = true;
            repaint();
            return true;
        }
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (!isInitialized) return;

        panelHeight = getHeight();
        panelWidth = getWidth();
        cellHeight = panelHeight / 3;
        cellWidth = panelWidth / 3;

        // makes the grid
        g.setColor(Color.BLACK);
        for (int i = 0; i < 3; i++) {
            int x = i * cellWidth;// x-pos of vertical lines
            int y = i * cellHeight; // y-pos of horizontal lines

            g.drawLine(0, y, panelWidth, y);
            g.drawLine(x, 0, x, panelHeight);
        }

        // what to do in a field?
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[x][y] == EMPTY_DOT) continue;
                if (field[x][y] == HUMAN_DOT) {
                    g.setColor(Color.BLUE);
                    g.fillOval(x * cellWidth + DOT_PADDING, y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2, cellHeight - DOT_PADDING * 2);
                } else if (field[x][y] == AI_DOT) {
                    g.setColor(Color.GREEN);
                    g.fillOval(x * cellWidth + DOT_PADDING, y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2, cellHeight - DOT_PADDING * 2);
                } else {
                    throw new RuntimeException("Unexpected value " + field[x][y] +
                            " in cell: x=" + x + ", y=" + y);
                }
            }
        }
        if (isGameOver) showMessageGameOver(g);

    }

    private void showMessageGameOver(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 200, getWidth(), 70);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Times new roman", Font.BOLD, 38));

        switch (gameOverType) {
            case STATE_DRAW:
                g.drawString(MSG_DRAW, 180, getHeight() / 2);
                break;
            case STATE_WIN_HUMAN:
                g.drawString(MSG_WIN_HUMAN, 70, getHeight() / 2);
                break;
            case STATE_WIN_AI:
                g.drawString(MSG_WIN_AI, 20, getHeight() / 2);
                break;
            default:
                throw new RuntimeException("Unexpected gameOver state: " + gameOverType);
        }
    }

    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {

        System.out.printf("Mode: %d;\nSize: x=%d; y=%d;\nWin Length: %d", mode, fSzX, fSzY, wLen);
        initMap();

        isGameOver = false;
        isInitialized = true;

        repaint();
    }

}


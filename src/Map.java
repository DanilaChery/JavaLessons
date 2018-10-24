import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Валентин on 17.10.2018.
 */
public class Map extends JPanel
{
    public static final int MODE_H_V_I = 0;
    public static final int MODE_H_V_H = 1;
    int[][] field;
    int fieldSizeX;
    int fieldSizeY;
    boolean isEnd = false;
    int cellHeight;
    int cellWidth;
    int chipOfWinner;
    int chip = Logic.PLAYER1;
    int mode;
    boolean isInitialize = false;
    Map() {
        setBackground(Color.GRAY);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if(isEnd == false) {
                    update(e);
                    repaint();
                }
            }
        });
    }

    void update(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        if (!Logic.isEmpty(cellY, cellX, field)) {
            return;
        }

        if (mode == MODE_H_V_H) {

            Logic.playerMove(cellY, cellX, field, chip);
            if (Logic.checkWinner(chip, field)) {
                chipOfWinner = chip;
                isEnd = true;
                return;
            } else if (Logic.fullField(field)) {
                chipOfWinner = Logic.FULL_FIELD;
                isEnd = true;
                return;
            }
            if (chip == Logic.PLAYER1) {
                chip = Logic.PLAYER2;
            } else {
                chip = Logic.PLAYER1;
            }
        } else {

            Logic.playerMove(cellY, cellX, field, Logic.PLAYER1);

            if (Logic.checkWinner(Logic.PLAYER1, field)) {
                chipOfWinner = Logic.PLAYER1;
                isEnd = true;
                return;
            } else if (Logic.fullField(field)) {
                chipOfWinner = Logic.FULL_FIELD;
                isEnd = true;
                return;
            }

            Logic.computerMove(field);

            if (Logic.checkWinner(Logic.AI, field)) {
                chipOfWinner = Logic.AI;
                isEnd = true;
                return;
            } else if (Logic.fullField(field)) {
                chipOfWinner = Logic.FULL_FIELD;
                isEnd = true;
                return;
            }
        }
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        render(g);
    }
    void startNewGame(int mode,int fieldSizeX,int fieldSizeY,int winLen){
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        Logic.countToWin = winLen;
        field = new int[fieldSizeY][fieldSizeX];
        Logic.initField(field);
        isInitialize = true;
        isEnd = false;
        this.mode = mode;

        repaint();
    }

    void showMassege(Graphics g){
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        g.setFont(new Font("Arial",Font.BOLD,30));
        g.setColor(Color.RED);

        if (chipOfWinner == Logic.PLAYER1){
            g.drawString(Logic.P1_WIN,panelHeight/2 - 50,panelWidth/2);
        }else if(chipOfWinner == Logic.PLAYER2) {
            g.drawString(Logic.P2_WIN, panelHeight / 2 - 65, panelWidth / 2);
        }else if(chipOfWinner == Logic.AI){
            g.drawString(Logic.COMP_WIN,panelHeight/2 - 65,panelWidth/2);
        }else if(chipOfWinner == Logic.FULL_FIELD){
            g.drawString(Logic.FULL,panelHeight/2 - 60,panelWidth/2);
        }
    }
    void render (Graphics g){
        if(!isInitialize) return;

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellWidth = panelWidth/fieldSizeY;
        cellHeight = panelHeight/fieldSizeX;
        g.setFont(new Font("Arial",Font.BOLD,30));

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i *cellHeight;
            g.drawLine(0,y,panelWidth,y);
        }
        for (int i = 0; i < fieldSizeX; i++) {
            int x = i *cellWidth;
            g.drawLine(x,0,x,panelHeight);
        }

        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] != Logic.EMPTY) {
                    String chip = Logic.getChip(i, j, field);
                    g.drawString(chip, j * cellHeight + cellHeight / 2-10,i * cellWidth + cellWidth / 2+10);
                }else continue;
            }
        }

        if (isEnd) showMassege(g);
    }
}

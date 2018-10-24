import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Валентин on 17.10.2018.
 */
public class GameWindow extends JFrame {

    private static final int WIN_HEIGHT = 555;
    private static final int WIN_WIDTH = 507;
    private static final int WIN_POS_X = 800;
    private static final int WIN_POS_Y = 300;

    private static Map field;
    private static StartNewGameWindow startNewGameWindow;

    public GameWindow(){
        setTitle("TikTakToe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(WIN_POS_X,WIN_POS_Y,WIN_WIDTH,WIN_HEIGHT);
        setResizable(false);


        JPanel bottomJPanel = new JPanel(new GridLayout(1,2));

        JButton btnNewGame = new JButton("Start new game");
        JButton btnClose = new JButton("Close");

        startNewGameWindow = new StartNewGameWindow(this);


        bottomJPanel.add(btnNewGame);
        bottomJPanel.add(btnClose);
        btnNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               startNewGameWindow.setVisible(true   );
            }
        });
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        field = new Map();
        add(field,BorderLayout.CENTER);

        add(bottomJPanel,BorderLayout.SOUTH);

        setVisible(true);
    }

    void startNewGame(int mode,int fieldSizeX,int fieldSizeY,int winLen){
        field.startNewGame(mode,fieldSizeX,fieldSizeY,winLen);

    }
}

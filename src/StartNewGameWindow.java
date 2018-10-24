import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Валентин on 17.10.2018.
 */
public class StartNewGameWindow extends JFrame
{
    private final GameWindow gameWindow;
    private static final int WIN_HEIGHT = 230;
    private static final int WIN_WIDTH = 350;
    private static final int MIN_WIN_LEN = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final int MAX_WIN_LEN = 10;
    private static final String STR_WIN_LEN = "Winning Len: ";
    private static final String STR_FILED_SIZE = "Field Size: ";


    private JRadioButton jrdHumVsAi = new JRadioButton("Human VS Ai", true);
    private JRadioButton jrdHumVsHum = new JRadioButton("Human VS Human");
    private  ButtonGroup  gameMode = new ButtonGroup();

    private JSlider slFieldSize = new JSlider();
    private JSlider slWinLen = new JSlider();


    public StartNewGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setTitle("new game param");
        setSize(WIN_WIDTH,WIN_HEIGHT);

        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int) (gameWindowBounds.getCenterX() - WIN_WIDTH/2);
        int posY = (int) (gameWindowBounds.getCenterY() - WIN_HEIGHT/2);

        setLocation(posX,posY);
        setLayout(new GridLayout(10,1));

        addGameControlsMode();
        addGameControlsFieldWinLen();

        JButton btnStartGame = new JButton("Start");
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStartGame();
            }
        });
        add(btnStartGame);


    }
    void btnStartGame(){
        int gameMode;
        if(jrdHumVsAi.isSelected()) {
            gameMode = Map.MODE_H_V_I;
        } else {
            gameMode = Map.MODE_H_V_H;
        }

        int fieldSize = slFieldSize.getValue();
        int winLen = slWinLen.getValue();

        gameWindow.startNewGame(gameMode, fieldSize, fieldSize, winLen);
        setVisible(false);
    }
    private void addGameControlsMode() {
        add(new JLabel("Choose gaming mode"));
        gameMode.add(jrdHumVsAi);
        gameMode.add(jrdHumVsHum);
        add(jrdHumVsAi);
        add(jrdHumVsHum);

}

    void  addGameControlsFieldWinLen(){
        add(new JLabel("Choose field size"));
        final JLabel lblFieldSize = new JLabel(STR_FILED_SIZE+MIN_FIELD_SIZE);
        add(lblFieldSize);


        slFieldSize = new JSlider(MIN_FIELD_SIZE,MAX_FIELD_SIZE,MIN_WIN_LEN);

        slFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                int currentFileSize = slFieldSize.getValue();
                lblFieldSize.setText(STR_FILED_SIZE +currentFileSize);
                slWinLen.setMaximum(currentFileSize);
            }
        });
        add(slFieldSize);

        add(new JLabel("Choose win len"));
        final JLabel lblWinLen = new JLabel(STR_WIN_LEN+MIN_WIN_LEN);
        add(lblWinLen);

        slWinLen = new JSlider(MIN_WIN_LEN,MAX_WIN_LEN,MIN_WIN_LEN);
        slWinLen.setMaximum(slFieldSize.getValue());
        slWinLen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                lblWinLen.setText(STR_WIN_LEN +slWinLen.getValue());
            }
        });
        add(slWinLen);

    }
}

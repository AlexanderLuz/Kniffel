import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI  extends JFrame implements ActionListener {

    private final Game game = new Game();
    private final Player player = new Player("Saveli");
    private final DiceSet diceSet = new DiceSet();

    private final JSplitPane masterSplitPane;
    private final JSplitPane leftMasterSplitPane;
    private final JSplitPane leftBottomSplitPane;

    private final JPanel leftTopPanel;
    private final JPanel leftMidPanel;
    private final JPanel leftBottomPanel;
    private final JPanel rightPanel;

    private final JButton diceOne;
    private final JButton diceTwo;
    private final JButton diceThree;
    private final JButton diceFour;
    private final JButton diceFive;
    private final JButton enter;

    public final JTextArea resultSheet;
    private final JTextArea consoleOutputField;
    private final JTextArea diceOutput;

    private final JComboBox<Integer> resultMenu;

    public GUI(){

        masterSplitPane = new JSplitPane();
        leftMasterSplitPane = new JSplitPane();
        leftBottomSplitPane = new JSplitPane();

        leftTopPanel = new JPanel();
        leftMidPanel = new JPanel();
        leftBottomPanel = new JPanel();
        rightPanel = new JPanel();

        rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.LINE_AXIS));
        rightPanel.add(Box.createHorizontalGlue());

        setPreferredSize(new Dimension(800, 500));
        getContentPane().setLayout(new GridLayout());
        getContentPane().add(masterSplitPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Kniffel");

        masterSplitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        masterSplitPane.setDividerSize(0);
        masterSplitPane.setLeftComponent(leftMasterSplitPane);
        masterSplitPane.setRightComponent(rightPanel);
        masterSplitPane.setDividerLocation(500);

        leftMasterSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        leftMasterSplitPane.setDividerSize(0);
        leftMasterSplitPane.setDividerLocation(250);
        leftMasterSplitPane.setTopComponent(leftTopPanel);
        leftMasterSplitPane.setBottomComponent(leftBottomSplitPane);

        leftBottomSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        leftBottomSplitPane.setDividerSize(0);
        leftBottomSplitPane.setTopComponent(leftMidPanel);
        leftBottomSplitPane.setBottomComponent(leftBottomPanel);

        diceOne = new JButton("1");
        diceOne.addActionListener(this);
        diceTwo = new JButton("2");
        diceOne.addActionListener(this);
        diceThree = new JButton("3");
        diceOne.addActionListener(this);
        diceFour = new JButton("4");
        diceOne.addActionListener(this);
        diceFive = new JButton("5");
        diceOne.addActionListener(this);
        enter = new JButton("Enter");
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        resultSheet = new JTextArea();
        resultSheet.setFont(new Font(Font.SERIF, Font.BOLD, 14));
        consoleOutputField = new JTextArea("b");
        diceSet.rollAllDice();
        diceOutput = new JTextArea(diceSet.printDiceSet());
        diceOutput.setFont(new Font(Font.SERIF, Font.BOLD, 60));

        resultMenu = new JComboBox<Integer>();

        leftMidPanel.add(diceOutput);
        rightPanel.add(resultSheet);
        leftTopPanel.add(consoleOutputField);
        leftBottomPanel.add(diceOne);
        leftBottomPanel.add(diceTwo);
        leftBottomPanel.add(diceThree);
        leftBottomPanel.add(diceFour);
        leftBottomPanel.add(diceFive);
        leftBottomPanel.add(resultMenu);
        leftBottomPanel.add(enter);

        game.printPointSheet(player, this);

        pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == diceOne) {

        }
        if(e.getSource() == diceTwo) {

        }
        if(e.getSource() == diceThree) {

        }
        if(e.getSource() == diceFour) {

        }
        if(e.getSource() == diceFive) {

        }


    }
}



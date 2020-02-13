package editorfunctions;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import userinterface.MainFrame;

/**
 *
 * @author xperiaW
 */
public class FindText extends JDialog implements ActionListener {

    JTextField searchText;
    JCheckBox cbCase, cbWhole;
    JRadioButton up, down;
    JLabel statusInfo;
    JFrame mainFrame;
    JPanel center, north, south;
    boolean btnEnable = false;
    JButton nextBtn;

    boolean foundOne;

    public FindText(JFrame owner, boolean isReplace) {
        super(owner, true);

        north = new JPanel();
        center = new JPanel();
        south = new JPanel();

        setTitle("Find");
        setFindPanel(north);

        addComponent(center);
        statusInfo = new JLabel("Status Info : ");
        south.add(statusInfo);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                dispose();
            }

        });

        getContentPane().add(north, BorderLayout.NORTH);
        getContentPane().add(center, BorderLayout.CENTER);
        getContentPane().add(south, BorderLayout.SOUTH);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }

    private void setFindPanel(JPanel north) {
        nextBtn = new JButton("Find Next");
        nextBtn.addActionListener(this);
        nextBtn.setEnabled(btnEnable);

        searchText = new JTextField(20);
        searchText.addActionListener(this);

        searchText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                boolean state = (searchText.getDocument().getLength() > 0);
                nextBtn.setEnabled(true);
                foundOne = false;
            }

        });

        north.add(new JLabel("Find word"));
        north.add(searchText);
        north.add(nextBtn);

    }

    private void addComponent(JPanel center) {
        JPanel east = new JPanel();
        JPanel west = new JPanel();
        center.setLayout(new GridLayout(1, 2));
        east.setLayout(new GridLayout(2, 1));
        west.setLayout(new GridLayout(2, 1));

        cbCase = new JCheckBox("Match Case", true);
        cbWhole = new JCheckBox("Match Word", true);

        ButtonGroup group = new ButtonGroup();


        east.add(cbCase);
        east.add(cbWhole);


        center.add(east);
        center.add(west);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        process();
    }

    private void process() {
        statusInfo.setText("Searching " + searchText.getText());

        int caret = MainFrame.getArea().getCaretPosition();
        String word = getWord();
        String text = getAllText();

        caret = search(text, word, caret);

    }

    private int search(String text, String word, int caret) {
        boolean found = false;
        int all = text.length();
        int check = word.length();
        int add = 0;

        for (int i = caret + 1; i < (all - check); i++) {
            String temp = text.substring(i, (i + check));
            if (temp.equals(word)) {
                if (isWholeWordSelect()) {
                    if (checkWholeWord(check, text, add, caret)) {
                        caret = i;
                        found = true;
                        break;
                    } else {
                        caret = i;
                        found = true;
                        break;
                    }
                }
            }

        }

        MainFrame.getArea().setCaretPosition(0);
        if (found) {
            MainFrame.getArea().requestFocus();
            MainFrame.getArea().select(caret, caret + check);

            foundOne = true;
            return caret;
        }

        return -1;
    }

    private boolean isWholeWordSelect() {
        return cbWhole.isSelected();
    }

    private String getAllText() {
        if (caseNotSelected()) {
            return MainFrame.getArea().getText().toLowerCase();
        }
        return MainFrame.getArea().getText();
    }

    private String getWord() {
        if (caseNotSelected()) {
            return searchText.getText().toLowerCase();
        }
        return searchText.getText();
    }

    private boolean caseNotSelected() {
        return !cbCase.isSelected();
    }

    private boolean checkWholeWord(int check, String text, int add, int caret) {
        int offsetLeft = (caret + add) - 1;
        int offsetRight = (caret + add) - check;

        if ((offsetLeft < 0) || offsetRight > text.length()) {
            return true;
        }
        return ((!Character.isLetterOrDigit(text.charAt(offsetLeft))) && (!Character.isLetterOrDigit(text.charAt(offsetRight))));
    }

}

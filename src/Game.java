import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Game extends JPanel implements ActionListener {

    public static String [][] card =  new String[4][4];
    ArrayList<String> comparaison = new ArrayList<>();
    JButton[][] btns = new JButton[4][4];
    int cpt = 0;
    int score =0;
    ImageIcon dos = new ImageIcon("C:\\Users\\PC\\Desktop\\TP_2\\MemoryCardTP2\\src\\DOS.png");

    Game(){
        setLayout(new GridLayout(4,4,10,10));
        setBackground(new Color(192,192,192));
        setBorder(new EmptyBorder(10,10,10,10));


        Random rdn = new Random();
        ArrayList<String> letters = new ArrayList<>();
        letters.add("A");
        letters.add("B");
        letters.add("C");
        letters.add("D");
        letters.add("E");
        letters.add("F");
        letters.add("Z");
        letters.add("H");
        letters.add("A");
        letters.add("B");
        letters.add("C");
        letters.add("D");
        letters.add("E");
        letters.add("F");
        letters.add("Z");
        letters.add("H");


        int lettreRdn;
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                lettreRdn = rdn.nextInt(letters.size());
                card[i][j] = letters.get(lettreRdn);
                letters.remove(lettreRdn);
            }
        }

        // PLANCHE DE JEUX / BUTTONS
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                btns[i][j] = new JButton(dos);
                btns[i][j].setSize(50,50);
                btns[i][j].addActionListener(this);
                this.add(btns[i][j]);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {

        Object btn = e.getSource();

        if (cpt <= 1) {
            showCard(btn);
            if (score == 8) {
                validation(btn);
            }
        } else {
            validation(btn);
        }
    }

    public void showCard(Object btn) {
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (btn == btns[i][j]) {
                    btns[i][j].setText(card[i][j]);
                    btns[i][j].setIcon(null);
                    btns[i][j].setFont(new Font("Rockwell", Font.BOLD, 200));
                    btns[i][j].setEnabled(false);
                    comparaison.add(card[i][j]);
                    cpt++;
                }
            }
        }
    }

    public void validation(Object btn) {
        if (Objects.equals(comparaison.get(0), comparaison.get(1))) {
            score += 1;
            if (score == 7) {
                cpt = 2;
                return;
            }
            if (score == 9) {
                JOptionPane.showMessageDialog(null, "Vous avez gagné!", "Gagnant", JOptionPane.CLOSED_OPTION);
            }
        } else {
            for(int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (Objects.equals(comparaison.get(0), btns[i][j].getText()) || Objects.equals(comparaison.get(1), btns[i][j].getText())) {
                        btns[i][j].setIcon(dos);
                        btns[i][j].setText("");
                        btns[i][j].setEnabled(true);
                    }
                }
            }
        }
        comparaison.clear();
        cpt =0;
        showCard(btn);
    }
}

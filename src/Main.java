import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Main extends JFrame implements ActionListener{

    public static String [][] card =  new String[2][2];
    ArrayList<String> comparaison = new ArrayList<>();
    JButton[][] btns = new JButton[2][2];
    int cpt = 0;

    public Main() {

        // CARTES
        Random rdn = new Random();
        ArrayList<String> letters = new ArrayList<>();
        letters.add("A");
        letters.add("B");
        letters.add("A");
        letters.add("B");

        int index;
        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                index = rdn.nextInt(letters.size());
                card[i][j] = letters.get(index);
                letters.remove(index);
            }
        }

        // FRAME SWING + PANEL
        JFrame frame = new JFrame();
        frame.setTitle("Memory Card Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2,2,5,5));

        // PLANCHE DE JEUX / BUTTONS
        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                btns[i][j] = new JButton("DOS");
                //btns[i][j].setBackground(Color.gray); //
                btns[i][j].addActionListener(this);
                panel.add(btns[i][j]);
            }
        }


        frame.add(panel);
        frame.setVisible(true);


    }


    public void actionPerformed(ActionEvent e) {

        // À l'action performed attribuer la valeur de card[0][0] à btn[0][0] exemple
        Object btn = e.getSource();

        if (cpt <= 1) {
            showCard(btn);
        } else {
            validation(btn);
        }
    }

    public void showCard(Object btn) {
        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (btn == btns[i][j]) {
                    btns[i][j].setText(card[i][j]);
                    btns[i][j].setEnabled(false);
                    comparaison.add(card[i][j]);
                    cpt++;
                }
            }
        }
    }

    public void validation(Object btn) {
        if (Objects.equals(comparaison.get(0), comparaison.get(1))) { // CHECk
            System.out.println("Valide");
        } else {
            for(int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (Objects.equals(comparaison.get(0), btns[i][j].getText()) || Objects.equals(comparaison.get(1), btns[i][j].getText())) {
                        btns[i][j].setText("DOS");
                        btns[i][j].setEnabled(true);
                    }
                }
            }
        }
        comparaison.clear();
        cpt =0;
        showCard(btn);
    }

    public static void main(String[] args) {
//      GameFrame game = new GameFrame();
//       game.setVisible(true);
       Main main = new Main();
    }


}

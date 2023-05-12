import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Main extends JFrame implements ActionListener{

    public static String [][] card =  new String[2][2];
    JButton[][] btns = new JButton[2][2];
    JButton btn;

    public Main() {

        String a = "b";
        a = "e";

        System.out.println(a);

        Random rdn = new Random();
        ArrayList<String> letters = new ArrayList<String>();
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

        JFrame frame = new JFrame();
        frame.setTitle("Memory Card Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2,2,5,5));

        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                btns[i][j] = new JButton(card[i][j]);
            }
        }

        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                btns[i][j].addActionListener(this);
                panel.add(btns[i][j]);
            }
        }


        frame.add(panel);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        //REPRENDRE ICI COMPARER 2 TEXT
        System.out.println(e.getActionCommand());

//        JButton btnTest = (JButton)e.getSource();
//        String a = btnTest.getText();
//        System.out.println(a);


    }

    public static void main(String[] args) {
//      GameFrame game = new GameFrame();
//       game.setVisible(true);
       Main main = new Main();
    }


}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {
    JButton button;
    public GameFrame () {
//        Card cards = new Card();

        button = new JButton();
        button.setText("DOS");
        button.addActionListener(e -> System.out.println("HELLO YOIUIISOAISPOASJ"));

        button.setSize(50,50);


//        JButton btn2 = new JButton();
//        btn2.setText("DOS");
//        btn2.setBounds(250,0,250,250);
//        JButton btn3 = new JButton();
//        btn3.setText("DOS");
//        btn3.setBounds(250,250,50,50);
//        JButton btn4 = new JButton();
//        btn4.setText("DOS");
//        btn4.setBounds(250,250,50,50);
        this.setTitle("MEMORY CARD GAME");
        this.setBackground(Color.lightGray);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.add(button);

//        add(btn3);
//        add(btn4);


//        JPanel field = new JPanel();
//        JButton[] btn = new JButton[3];
//        String[] board = new String[3];
//
//
//        for(int i = 0; i < board.length;i++) {
//            btn[i] = new JButton("");
//            btn[i].setBackground(new Color(220, 220, 220));
//            btn[i].addActionListener((ActionListener) this);
//            btn[i].setEnabled(true);
//            field.add(btn[i]);
//        }
//
//        getContentPane().setLayout(new GridLayout(1,1));

    }
}

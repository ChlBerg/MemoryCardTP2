import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener {

    JPanel panelMenu = new JPanel(new GridLayout(2,2,50,50));
    JButton start = new JButton("Start");
    JButton reset = new JButton("Reset");
    JButton exit = new JButton("Exit");
    Game game;

    GameFrame() {
        setTitle("Memory Card Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,1000);
        setLocationRelativeTo(null);

        start.addActionListener(this);
        reset.addActionListener(this);
        exit.addActionListener(this);

        panelMenu.setBackground(new Color(192,192,192));
        panelMenu.setBorder(new EmptyBorder(new Insets(400,10,400,15)));
        panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.X_AXIS));

        panelMenu.add(reset);
        panelMenu.add(Box.createRigidArea(new Dimension(10, 10)));
        panelMenu.add(exit);

        game = new Game();
        this.add(game);

        this.add(panelMenu, BorderLayout.EAST);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reset) {
            this.remove(game);
            game = new Game();
            this.add(game);
            SwingUtilities.updateComponentTreeUI(this);
        } else if (e.getSource() == exit) {
            System.exit(0);
        }
    }
}

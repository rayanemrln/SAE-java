import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Graphics extends JFrame{
    public static void main(String[] args) throws IOException{
        ManageLists Graph = new ManageLists();
        Graphics Window = new Graphics();
        Window.setIconImage(Toolkit.getDefaultToolkit().getImage("Annexes/logo.png"));
        System.out.println(Graph.getPlacesArray());
        System.out.println(Graph.getRoadsArray());
        /* Matrice Adj = Graph.createMatrice(); */
    }

    private JPanel P = new JPanel();

    Graphics(){
        super("My Graph !");
        this.setVisible(true);
        this.setSize(1280,720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        P.add(Box.createRigidArea(new Dimension(0, 20)));
        JLabel L1 = new JLabel("Bienvenue sur l'application, cliquez sur l'activite de votre choix !");
        P.add(L1);
        P.add(Box.createRigidArea(new Dimension(0, 30)));
        JButton btn1 = new JButton("Operations sur les chaines de caracteres");
        P.add(btn1);
        P.add(Box.createRigidArea(new Dimension(0, 40)));
        JButton btn2 = new JButton("Manipulation Dates et Heures");
        P.add(btn2);
        P.add(Box.createRigidArea(new Dimension(0, 40)));
        JButton btn3 = new JButton("Playing with English Words");
        P.add(btn3);

        L1.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn1.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn2.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn3.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        this.setContentPane(P);

        this.setLayout(new BoxLayout(P, BoxLayout.X_AXIS));
        this.setLayout(new BoxLayout(P, BoxLayout.Y_AXIS));
    }

    


}

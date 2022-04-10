import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Graphics extends JFrame{
    public static void main(String[] args) throws IOException{
        ManageLists Graph = new ManageLists();
        Graphics Window = new Graphics();

        Graph.printRoad("Caluire");
        Graph.printRoad("Rillieux");
        Graph.printRoad("Marie-9e");
        Graph.printRoad("Confluence");
        Graph.printRoad("Appart-Fitness");
        Graph.printPlace("Parc-de-la-tete-d'or");
        Graph.printPlace("La-Marinade");
        Graph.printPlace("Fourvière");
        Graph.printPlace("Avenue-De-La-Honte"); 
    }
    
    private JPanel P = new JPanel();

    Graphics(){
        super("My Graph !");
        this.setVisible(true);
        this.setSize(1280,720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("Annexes/logo.png"));

/*         P.add(Box.createRigidArea(new Dimension(0, 20)));
        JLabel L1 = new JLabel("Bienvenue sur l'application, cliquez sur l'activite de votre choix !");
        P.add(L1);
        L1.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setLayout(new BoxLayout(P, BoxLayout.X_AXIS));
        this.setLayout(new BoxLayout(P, BoxLayout.Y_AXIS));*/

        this.setContentPane(P);
    }
}

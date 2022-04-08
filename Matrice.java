import java.util.*;
import java.lang.*;

public class Matrice {
    public static ArrayList<ArrayList<Roads>> matrice = new ArrayList<ArrayList<Roads>>();

    public Matrice(ArrayList<Roads> mat, ArrayList<Places> PL) {
        for(int i = 0;i<PL.size();i++) {
            ArrayList<Roads> ajout = new ArrayList<Roads>();
            for(int j = 0;j<PL.size();j++)
                ajout.add(null);
            Matrice.matrice.add(ajout);
        }
        for(int ref = 0;ref<PL.size();ref++) {
            
            //ArrayList<Roads> ajout = new ArrayList<>();
            System.out.println("\n\n"+ref+"\n");
            String sommet_ref = PL.get(ref).getName();
            for (Roads route : mat) {
                System.out.println(ref);
                if (route.getPlace1().getName().equals(sommet_ref)) {
                    matrice.get(ref).set(route.getPlace2().getId()-1,route);  
                    matrice.get(route.getPlace2().getId()-1).set(ref,route);
                }
            }
        }
    }

    public String toString() {
        return "La valeur de la matrice est  : " + Matrice.matrice;
    }
}
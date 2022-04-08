import java.io.IOException;
import java.util.*;

public class ManageLists {
    private ArrayList<Places> PlacesArray = new ArrayList<Places>();
    private ArrayList<Roads> RoadsArray = new ArrayList<Roads>();

    public ManageLists() throws IOException{ 
        this.remplirArrayList();
    }

    public int converter(String type){
        switch (type) {
            case "A":
            case "V":
                return 0;
            case "N":
            case "R":
                return 1;
            case "D":
            case "L":
                return 2;
            default: 
                return -1;
        }
    }

    public void remplirArrayList() throws IOException{
        FileReader reader = new FileReader("knots.csv");
        if (reader.filetest()){
            String tmp;
            int index=-1;
            while ((tmp = reader.getLineInString())!=null){
                String[] tab = reader.getStringInArray(tmp);
                for(int i = 0; i < tab.length-2; i+=2){
                    if(i == 0){
                        Places P1 = new Places(tab[i+1] , this.converter(tab[i]));
                        PlacesArray.add(P1);
                        index++;
                    }else{
                        i+=2;
                        Places P1 = new Places(tab[i+1], this.converter(tab[i]));
                        Roads R1 = new Roads(this.converter(tab[i-2]), Integer.valueOf(tab[i-1]), PlacesArray.get(index), P1);
                        if(!RoadsArray.contains(R1))
                            RoadsArray.add(R1);
                    }
                }
            }
        }else{
            new Exception("Erreur à l'ouverture du fichier");
        }
        reader.closeReader();
    }   


    public Matrice createMatrice(){
        Matrice M1 = new Matrice(RoadsArray, PlacesArray);
        return M1;
    }
/*     public void trouverEquivalenceEtRemplacer(){
        //On trouves doublons dans les sommets
        int i = 0;
        int j;
        while(i<PlacesArray.size()){
            j = 0;
            while(j<PlacesArray.size()){
                if(PlacesArray.get(i).equals(PlacesArray.get(j))&&i!=j){
                    PlacesArray.set(i,PlacesArray.get(j));
                }
                j++;
            }
            i++;
        }
        i=0;
        j=0;

        //On modifie les doublons dans les routes
        while(j<PlacesArray.size()){
            j=0;
            while(i<RoadsArray.size()){
                if(RoadsArray.get(i).getPlace1().equals(PlacesArray.get(j))){
                    RoadsArray.get(i).setPlace1(PlacesArray.get(j));
                }
                if(RoadsArray.get(i).getPlace2().equals(PlacesArray.get(j))){
                    RoadsArray.get(i).setPlace2(PlacesArray.get(j));
                }
                i++;
            }
            j++;
        }

    } */

    public ArrayList<Roads> getRoadsArray(){
        return this.RoadsArray;
    }

    public ArrayList<Places> getPlacesArray(){
        return this.PlacesArray;
    }
}



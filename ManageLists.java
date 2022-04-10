import java.io.IOException;
import java.util.*;

public class ManageLists {
    private ArrayList<Places> PlacesArray = new ArrayList<Places>();
    private ArrayList<Roads> RoadsArray = new ArrayList<Roads>();

    public ManageLists() throws IOException{ 
        this.fillArrayList();
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
                return 0;
        }
    }

    public void fillArrayList() throws IOException{
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
        this.deleteDuplicateRoads();
        this.deleteDuplicatePlacesInRoads();
    }   


    public Matrice createMatrice(){
        Matrice M1 = new Matrice(RoadsArray, PlacesArray);
        return M1;
    }

    public void deleteDuplicatePlacesInRoads(){
        int modifs = 0;
        System.out.println("Debut mise a jour des differents lieux dans les routes.");
        for(int i=0; i<PlacesArray.size(); i++)
            for(int j=0; j<RoadsArray.size(); j++){
                if(PlacesArray.get(i).equals(RoadsArray.get(j).getLink(0))){
                    RoadsArray.get(j).setLink(0,PlacesArray.get(i));
                    modifs++;
                }
                if(PlacesArray.get(i).equals(RoadsArray.get(j).getLink(1))){
                    RoadsArray.get(j).setLink(1,PlacesArray.get(i));
                    modifs++;
                }
            }
        System.out.println(modifs+" modifications ont ete effectuees.\n");
    }

    public void deleteDuplicateRoads(){
        System.out.println("Debut suppression des routes doublons.");
        int modifs = RoadsArray.size();
        for(int i=0;i<RoadsArray.size();i++)
            for(int j=RoadsArray.size()-1;j>i;j--)
                if(compareLinks(RoadsArray.get(i),RoadsArray.get(j))){
                    this.RoadsArray.remove(j);
                    if(j!=RoadsArray.size()-1) j++;
                }
        modifs -=RoadsArray.size();
        System.out.println(modifs+" suppressions effectuees apres nettoyage.\n");
    }

/*     public void deleteDuplicateRoads2(){
        System.out.println("Nombre de routes avant suppression des doublons : "+RoadsArray.size());
        for(int i=0; i<RoadsArray.size(); i++)
            for(int j=i+1; j<RoadsArray.size(); j++)
                if(compareLinks2(RoadsArray.get(i),RoadsArray.get(j))&&i!=j){
                    RoadsArray.remove(j); 
                    j--;
                }
        System.out.println("Nombre de routes apres nettoyage : "+RoadsArray.size()+"\n");
    } */

/*     public boolean compareLinks(Roads R1, Roads R2){
        boolean bool = false;
        for(int i=0; i<2;i++)
            for(int j=0; j<2;j++)
                if((R1.getLink(j).equals(R2.getLink(i)))&&(R1.getLink(i).equals(R2.getLink(j)))&&i!=j&&R1.getKilometers()==R2.getKilometers())
                    bool = true;
        return bool;
    } */

    public boolean compareLinks(Roads R1, Roads R2){
        boolean bool = false;
        if(R1.getLink(0).equals(R2.getLink(1)) && R1.getLink(1).equals(R2.getLink(0)) && R1.getKilometers()==R2.getKilometers()) bool = true;
        return bool;
    }

    public ArrayList<Roads> getRoadsArray(){
        return this.RoadsArray;
    }

    public ArrayList<Places> getPlacesArray(){
        return this.PlacesArray;
    }

    public void printRoad(String PL){
        int nbr = 0;
        for (int i = 0; i <this.getRoadsArray().size(); i++){
            if(this.RoadsArray.get(i).getLink(0).getName().equals(PL))
                System.out.println(this.getRoadsArray().get(i));
            if(this.RoadsArray.get(i).getLink(1).getName().equals(PL)){
                System.out.println(this.getRoadsArray().get(i).toStringReversed());
                nbr++;
            }
        }        
        if(nbr==0) System.out.println("Aucune route partant de \""+PL+"\" n\'a ete trouvee, le lieu n'existe peut etre pas");
        System.out.println("\n");
    }

    public void printPlace(String PL){
        int nbr = 0;
        for (int i = 0; i <this.getPlacesArray().size(); i++){
            if(this.getPlacesArray().get(i).getName().equals(PL)){
                System.out.println(this.getPlacesArray().get(i));
                nbr++;
                break;
            }
        }
        if(nbr==0) System.out.println("Aucun lieu du nom de \""+PL+"\" n\'a ete trouve, verifiez l'ortographe et si le lieu existe");
        System.out.println("\n");

    }
}



import java.util.ArrayList;

class Places{
    /* Définition des attributs */
    private String Name;
    private int Type;
    private int Nbr;
    int NbrRelations=0;
    public static int nPlaces=0;
    public static int nPlacesV=0;
    public static int nPlacesR=0;
    public static int nPlacesL=0;
    public static ArrayList <Places> tab = new ArrayList<Places>();
    private static int id_ref = 0;
    private int id; 

    /* Constructeur */
    Places(String Name, int Type) {
        this.Name=Name;
        switch(Type){
            case 0 : nPlacesV++;
                break;
            case 1 : nPlacesR++;
                break;
            case 2 : nPlacesL++;
                break;
            default : nPlacesV++;
                Type = 0;
                break;
        }
        this.Type=Type;
        this.Nbr=++nPlaces;
        Places.tab.add(this);
        this.id = id_ref;
        id_ref++;
    }

    Places(String Name){
        this(Name,0);
    }

    /* Méthodes basiques */
    public int getNbr(){
        return this.Nbr;
    }

    public void setName(String Name){
        this.Name=Name;
    }

    public String getName(){
        return this.Name;
    }

    public String getType(){
        switch (this.Type){
            case 0 : return "Ville";
            case 1 : return "Restaurant";
            case 2 : return "Loisir";
        }
        return "Erreur";
    }

    public int getId() {
        return this.id;
    }

    public void setType(int number){
/*         if(this.Type==number){
            System.out.println("Le lieu "+this.Name+" est déjà de type "+this.getType());
            return;
        } */
        if (number>2 || number<0) {
            this.Type=0;
        }
        switch(this.Type){
            case 0 : nPlacesV--;
                break;
            case 1 : nPlacesR--;
                break;
            case 2 : nPlacesL--;
                break;
        }
        switch(number){
            case 0 : nPlacesV++;
                break;
            case 1 : nPlacesR++;
                break;
            case 2 : nPlacesL++;
                break;
            default : nPlacesV++;
                Type = 0;
                break;
        }        
        this.Type = number;
    }

    public void setType(){
        setType(0);
    }

    /* Fonctions de comptage */
    public static int getnPlaces() {
        return Places.nPlaces;
    }

    public static int getnPlacesV(){
        return Places.nPlacesV;
    }

    public static int getnPlacesR(){
        return Places.nPlacesR;
    }

    public static int getnPlacesL(){
        return Places.nPlacesL;
    }

    public int getNbrRelations(){
        return this.NbrRelations;
    }

    public static Places getPlaceAtIndex(int index){
        return tab.get(index);
    }

    public String toString() {
        String phrase_correcte;
        if(this.Type==0) phrase_correcte = "une";
        else phrase_correcte = "un";
        return "Le lieu "+this.Name+" est "+phrase_correcte+" "+this.getType();
    }
}
public class Roads {
    /* Définition des attributs */
    private int Type;
    private int kilometers;
    private Places[] Link;
    public Places Place1;
    public Places Place2;
    public static int nRoads=0;
    public static int nRoadsA=0;
    public static int nRoadsN=0;
    public static int nRoadsD=0;
    public static int index = 0;
    
    /* Constructeur */
    Roads(int Type, int kilometers, Places Place1, Places Place2){
        this.kilometers=kilometers;
        switch(Type){
            case 0 : nRoadsA++;
                break;
            case 1 : nRoadsN++;
                break;
            case 2 : nRoadsD++;
                break;
            default : nRoadsA++;
                Type = 0;
                break;
        }
        this.Type=Type;
        setLink(Place1, Place2);
        index++;
    }

    /* Méthodes basiques */

    public Places getPlace1() {
        return this.Place1;
    }

    public void setPlace1(Places Place1){
        this.Place1=Place1;
    }

    public void setPlace2(Places Place2){
        this.Place2=Place2;
    }

    public Places getPlace2() {
        return this.Place2;
    }

    public String getType(){
        switch (Type){
            case 0 : return "Autoroute";
            case 1 : return "Nationale";
            case 2 : return "Departementale";
        }
        return "Erreur";
    }

    public Places getLinkName(int a){
        if (a==1){
            return this.Link[0];
        }
        else if (a==2){
            return this.Link[1];
        }
        else {
            return null;
        }

    }

    public String getLinkType(int a){
        if (a==1){
            return this.Place1.getType();
        }
        else if (a==2){
            return this.Place1.getType();
        }
        else {
            return "Error : Uncorrect Number";
        }

    }

    public Places[] getCity(){
        return this.Link;
    }

    public int getKilometers(){
        return this.kilometers;
    }

    public void setKilometers(int kilometers){
        this.kilometers = kilometers;
    }
    public void setLink(Places Place1, Places Place2){
        Places[] tab = {Place1 , Place2};
        this.Link=tab;
        this.Place1=Place1;
        this.Place2=Place2;
    }

    public void setType(int number){
/*         if(this.Type==number){
            System.out.println("La route "+this.Name+" est déjà de type "+this.getType());
            return;
        } */
        switch(this.Type) {
            case 0 : nRoadsA--;
                break;
            case 1 : nRoadsN--;
                break;
            case 2 : nRoadsD--;
                break;
        }
        switch(number){
            case 0 : nRoadsA++;
                break;
            case 1 : nRoadsN++;
                break;
            case 2 : nRoadsD++;
                break;
            default : nRoadsA++;
                number = 0;
                break;
        }
        this.Type=number;
    }

    public void setType(){
        setType(0);
    }

    public String toString() {
        String francais_correct;
        if (this.Type==0)
            francais_correct = "L ";
        else
            francais_correct = "La ";

        return francais_correct+this.getType()+" de "+ this.kilometers +" kilometres va de "+this.Link[0].getName()+" a "+ this.Link[1].getName();
    }
}

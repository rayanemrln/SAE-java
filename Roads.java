public class Roads {
    /* Définition des attributs */
    private int Type;
    private int kilometers;
    private Places[] Link;
    
    /* Constructeur */
    Roads(int Type, int kilometers, Places Place1, Places Place2){
        this.kilometers=kilometers;
        this.Type=Type;
        setLink(Place1, Place2);
    }

    /* Méthodes basiques */

    public void setLink(int index,Places PL){
        if(index>1||index<0) return;
        this.Link[index]=PL;
    }

    public String getType(){
        switch (Type){
            case 0 : return "Autoroute";
            case 1 : return "Nationale";
            case 2 : return "Departementale";
            default : return "Erreur";
        }
    }

    public Places getLink(int a){
        switch(a){
            case 0: return this.Link[0];
            case 1 : return this.Link[1];
            default : return null; 
        }
    }

    public Places[] getLink(){
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
    }

    public void setType(int number){
        if (number>2 || number<0) return;
        this.Type=number;
    }

    public String toString() {
        return "Une "+this.getType().toLowerCase()+" de "+ this.kilometers +" kilometres va de "+this.Link[0].getName()+" a "+ this.Link[1].getName();
    }
    
    public String toStringReversed() {
        return "Une "+this.getType().toLowerCase()+" de "+ this.kilometers +" kilometres va de "+this.Link[1].getName()+" a "+ this.Link[0].getName();
    }
}

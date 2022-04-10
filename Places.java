class Places{
    /* Définition des attributs */
    private String Name;
    private int Type;
    private int Nbr;

    /* Constructeur */
    Places(String Name, int Type) {
        this.Name=Name;
        this.Type=Type;
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

    public void setType(int number){
        if (number>2 || number<0) return;
        this.Type = number;
    }

    public String toString() {
        String phrase_correcte;
        if(this.Type==0) phrase_correcte = "une";
        else phrase_correcte = "un";
        return "Le lieu \""+this.Name+"\" est "+phrase_correcte+" "+this.getType();
    }
}
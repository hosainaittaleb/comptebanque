class Compte{
    private int num;
    private float solde;
    private String propriete;
    public int getNumero() {
        return this.num;
    }    
    //vble de classe =>Compter le nbre de compte ouverts
    public static int nbCompte=0;
    public Compte(){
        nbCompte++;
        this.num=nbCompte;
    }
    public Compte(String propriete, float solde){
        this.propriete=propriete;
        this.solde=solde;
        nbCompte++;
        this.num=nbCompte;
    }
    public Compte(Compte autre){
        this.propriete=autre.propriete;
        this.solde=autre.solde;
        nbCompte++;
        this.num=nbCompte;
    }
    public String getPropriete(){
        return this.propriete;
    }
    public float getSolde(){
        return this.solde;
    }
    public void setSolde(float solde){
        this.solde=solde;
    }
    public boolean retirer(float montant){
        if (solde>=montant)
            {this.solde -=montant;
            return true;}
        else
            {System.out.println("Solde insuffisant!");
            return false;}
    }
    public void deposer(float montant){
        this.solde+=montant;
    }
    public String toString(){
        return "\tCompte:"+this.num+"\t"+this.propriete+"\t"+this.solde;
    }
    public void virerVers(float montant, Compte destinataire){
        if(retirer(montant));
            destinataire.deposer(montant);
    }
}
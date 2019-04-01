package hsl;

public class Kioski {
    public Matkakortti ostaMatkakortti(String nimi) {
        Matkakortti uusiKortti = new Matkakortti(nimi);                        
        return uusiKortti;
    }
    
    public Matkakortti ostaMatkakortti(String nimi, int arvo) {
        Matkakortti uusiKortti = new Matkakortti(nimi);                      
        uusiKortti.kasvataArvoa(arvo);
        return uusiKortti;
    }       
}
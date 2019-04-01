package hsl;

public class Lataajalaite {
    public void lataaArvoa(Matkakortti k, double a) {
        k.kasvataArvoa(a);
    }
    
    public void lataaAikaa(Matkakortti k, int pvm, int kk) {
        k.uusiAika(pvm, kk);
    }
}
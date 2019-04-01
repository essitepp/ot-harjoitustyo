
import javaapplication9.JavaApplication9;

public class Lukijalaite {
    private double RATIKKA = 1.5;
    private double HKL = 2.1;
    private double SEUTU = 3.5;
    
    public boolean ostaLippu(JavaApplication9.Matkakortti k, int tyyppi){
        double hinta = 0;
        if ( tyyppi == 0 ) {
            hinta = RATIKKA;
        } else if ( tyyppi ==1 ) {
            hinta = HKL;
        } else {
            hinta = SEUTU;
        }                        
        
        if ( k.getArvo()<hinta ) { 
            return false;
        }
        k.vahennaArvoa(hinta);
        
        return true;
    }     
}
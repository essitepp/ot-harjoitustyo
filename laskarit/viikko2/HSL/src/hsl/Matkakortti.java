package hsl;

public class Matkakortti {
    String omistaja;
    double arvo;
    int pvm;
    int kk;
    
    public Matkakortti(String n){
        omistaja = n;  
        pvm = 0;  
        kk = 0;  
        arvo = 0;
    }         
    
    public void kasvataArvoa(double a){ 
        arvo += a; 
    }
    
    public void vahennaArvoa(double a){ 
        arvo -= a; 
    }
    
    public double getArvo(){ 
        return arvo; 
    }   

    public void uusiAika(int p, int k){
        kk = k;
        pvm = p;
    }    
}

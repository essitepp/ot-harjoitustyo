package hsl;


import java.util.ArrayList;

public class HKLLaitehallinto { 
        ArrayList<Lataajalaite> lataajat = new ArrayList();
        ArrayList<Lukijalaite> lukijat = new ArrayList();

        void lisaaLataaja(Lataajalaite lataaja){ lataajat.add(lataaja); }

        void lisaaLukija(Lukijalaite lukija){ lukijat.add(lukija); }
}
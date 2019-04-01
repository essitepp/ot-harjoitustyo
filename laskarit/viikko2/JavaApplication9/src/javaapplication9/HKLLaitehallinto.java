
import java.util.ArrayList;
import javaapplication9.JavaApplication9;

public class HKLLaitehallinto { 
        ArrayList<JavaApplication9.Lataajalaite> lataajat = new ArrayList();
        ArrayList<JavaApplication9.Lukijalaite> lukijat = new ArrayList();

        void lisaaLataaja(JavaApplication9.Lataajalaite lataaja){ lataajat.add(lataaja); }

        void lisaaLukija(JavaApplication9.Lukijalaite lukija){ lukijat.add(lukija); }
}
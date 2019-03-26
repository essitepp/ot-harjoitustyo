package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {

    Kassapaate kassa;
    Maksukortti kortti;
    Maksukortti kortti2;

    public KassapaateTest() {
    }

    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(1000);
        kortti2 = new Maksukortti(100);
    }

    @Test
    public void rahamaaraOikeinAlussa() {
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void myydytEdullisetOikeinAlussa() {
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void myydytMaukkaatOikeinAlussa() {
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void rahamaaraOikeinSyodessaEdullisestiKateisellaKunMaksuRiittava() {
        kassa.syoEdullisesti(300);
        assertEquals(100240, kassa.kassassaRahaa());
    }

    @Test
    public void rahamaaraOikeinSyodessaMaukkaastiKateisellaKunMaksuRiittava() {
        kassa.syoMaukkaasti(500);
        assertEquals(100400, kassa.kassassaRahaa());
    }

    @Test
    public void rahamaaraOikeinSyodessaEdullisestiKateisellaKunMaksuEiRiittava() {
        kassa.syoEdullisesti(200);
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void rahamaaraOikeinSyodessaMaukkaastiKateisellaKunMaksuEiRiittava() {
        kassa.syoMaukkaasti(200);
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void vaihtorahaOikeinSyodessaEdullisestiKateisellaKunMaksuRiittava() {
        assertEquals(60, kassa.syoEdullisesti(300));
    }

    @Test
    public void vaihtorahaOikeinSyodessaMaukkaastiKateisellaKunMaksuRiittava() {
        assertEquals(100, kassa.syoMaukkaasti(500));
    }

    @Test
    public void vaihtorahaOikeinSyodessaEdullisestiKateisellaKunMaksuEiRiittava() {
        assertEquals(200, kassa.syoEdullisesti(200));
    }

    @Test
    public void vaihtorahaOikeinSyodessaMaukkaastiKateisellaKunMaksuEiRiittava() {
        assertEquals(200, kassa.syoMaukkaasti(200));
    }

    @Test
    public void myydytEdullisetOikeinKateisostonJalkeenKunMaksuRiittava() {
        kassa.syoEdullisesti(300);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void myydytMaukkaatOikeinKateisostonJalkeenKunMaksuRiittava() {
        kassa.syoMaukkaasti(500);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void myydytEdullisetOikeinKateisostonJalkeenKunMaksuEiRiittava() {
        kassa.syoEdullisesti(200);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void myydytMaukkaatOikeinKateisostonJalkeenKunMaksuEiRiittava() {
        kassa.syoMaukkaasti(200);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kortinSummaOikeinEdullisestiSyodessaKunTarpeeksiRahaa() {
        kassa.syoEdullisesti(kortti);
        assertEquals(760, kortti.saldo());
    }

    @Test
    public void kortinSummaOikeinMaukkaastiSyodessaKunTarpeeksiRahaa() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(600, kortti.saldo());
    }

    @Test
    public void kortinSummaOikeinEdullisestiSyodessaKunEiTarpeeksiRahaa() {
        kassa.syoEdullisesti(kortti2);
        assertEquals(100, kortti2.saldo());
    }

    @Test
    public void kortinSummaOikeinMaukkaastiSyodessaKunEiTarpeeksiRahaa() {
        kassa.syoMaukkaasti(kortti2);
        assertEquals(100, kortti2.saldo());
    }

    @Test
    public void palautusarvoOikeaSyodessaEdullisestiKortillaKunTarpeeksiRahaa() {
        assertEquals(true, kassa.syoEdullisesti(kortti));
    }

    @Test
    public void palautusarvoOikeaSyodessaMaukkaastiKortillaKunTarpeeksiRahaa() {
        assertEquals(true, kassa.syoMaukkaasti(kortti));
    }

    @Test
    public void palautusarvoOikeaSyodessaEdullisestiKortillaKunEiTarpeeksiRahaa() {
        assertEquals(false, kassa.syoEdullisesti(kortti2));
    }

    @Test
    public void palautusarvoOikeaSyodessaMaukkaastiKortillaKunEiTarpeeksiRahaa() {
        assertEquals(false, kassa.syoMaukkaasti(kortti2));
    }

    @Test
    public void myydytEdullisetOikeinKorttiostonJalkeenKunTarpeeksiRahaa() {
        kassa.syoEdullisesti(kortti);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void myydytMaukkaatOikeinKorttiostonJalkeenKunTarpeeksiRahaa() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void myydytEdullisetOikeinKorttiostonJalkeenKunEiTarpeeksiRahaa() {
        kassa.syoEdullisesti(kortti2);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void myydytMaukkaatOikeinKorttiostonJalkeenKunEiTarpeeksiRahaa() {
        kassa.syoMaukkaasti(kortti2);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kassanRahamaaraEiMuutuSyodessaEdullisestiKortilla() {
        kassa.syoEdullisesti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    @Test
    public void kassanRahamaaraEiMuutuSyodessaMaukkaastiKortilla() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void kassanRahamaaraOikeinKortinLatauksenJalkeen() {
        kassa.lataaRahaaKortille(kortti, 2000);
        assertEquals(102000, kassa.kassassaRahaa());
    }
    
    @Test
    public void kassanRahamaaraOikeinKortinLatauksenJalkeenKunSummaNegatiivinen() {
        kassa.lataaRahaaKortille(kortti, -2000);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void kortinSummaOikeinLatauksenJalkeen() {
        kassa.lataaRahaaKortille(kortti, 2000);
        assertEquals(3000, kortti.saldo());
    }
    
    @Test
    public void kortinSummaOikeinLatauksenJalkeenKunSummaNegatiivinen() {
        kassa.lataaRahaaKortille(kortti, -2000);
        assertEquals(1000, kortti.saldo());
    }
}

package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void luodunKortinSaldoOikein() {
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void rahanLataaminenToimiiOikein() {
        kortti.lataaRahaa(5);
        assertEquals(15, kortti.saldo());
    }
    
    @Test
    public void saldonVahennysToimii() {
        kortti.otaRahaa(2);
        assertEquals(8, kortti.saldo());
    }
    
    @Test
    public void saldoEiMuutuJosRahaaEiTarpeeksi() {
        kortti.otaRahaa(15);
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void oikeaPalautusarvoKunTarpeeksiRahaa() {
        assertEquals(true, kortti.otaRahaa(5));
    }
    
    @Test
    public void oikeaPalautusarvoKunEiTarpeeksiRahaa() {
        assertEquals(false, kortti.otaRahaa(15));
    }
    
    @Test
    public void toStringToimiiOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
}

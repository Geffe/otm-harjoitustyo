package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;
    Kassapaate kassapaate;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoOikein(){
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void saldoOikeinLataamisenJälkeen(){
        kortti.lataaRahaa(100);
        assertEquals("saldo: 1.10",kortti.toString());
    }
    
    @Test
    public void saldoVäheneeOikein(){
        assertTrue(kortti.otaRahaa(5));
        
        kortti.otaRahaa(10);
        assertEquals("saldo: 0.00",kortti.toString());
    }
}

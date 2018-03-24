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
        kortti.otaRahaa(5);
        assertEquals(5,kortti.saldo());
    }
    
    @Test
    public void saldoEiVähene(){
        kortti.otaRahaa(11);
        assertEquals(10,kortti.saldo());
    }
    
    @Test
    public void TrueFalseVäheneeOikein(){
        assertTrue(kortti.otaRahaa(5));
        assertTrue(kortti.otaRahaa(5));
        assertFalse(kortti.otaRahaa(1));
    }
}


package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class KassapaateTest {
    
    Kassapaate kassapaate;
    Maksukortti kortti;
    
    
    @Before
    public void setUp() {
        kassapaate = new Kassapaate();
        kortti = new Maksukortti(1000);
        
    }
    
    @Test
    public void maaratOikein(){
        assertEquals(100000, kassapaate.kassassaRahaa());
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
        
    }
    
    @Test
    public void käteisostoToimiiOikeinEdullisesti(){
        assertEquals(100,kassapaate.syoEdullisesti(100));
        assertEquals(260,kassapaate.syoEdullisesti(500));
        assertEquals(100240,kassapaate.kassassaRahaa());
    }
    
    @Test
    public void käteisostoToimiiOikeinMaukkaasti(){
        assertEquals(100,kassapaate.syoMaukkaasti(100));
        assertEquals(100,kassapaate.syoMaukkaasti(500));
        assertEquals(100400,kassapaate.kassassaRahaa());
    }
    
    @Test
    public void myytyjenLounaidenMaaraKasvaaOikein(){
        kassapaate.syoEdullisesti(300);
        kassapaate.syoEdullisesti(0);
        kassapaate.syoEdullisesti(300);
        kassapaate.syoMaukkaasti(0);
        kassapaate.syoMaukkaasti(500);
        assertEquals(2,kassapaate.edullisiaLounaitaMyyty());
        assertEquals(1,kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void rahamaaraEiMuutu(){
        assertEquals(200,kassapaate.syoEdullisesti(200));
        assertEquals(200,kassapaate.syoMaukkaasti(200));
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void veloitetaanKortiltaOikeinJosTarpeeksiRahaa(){
        assertTrue(kassapaate.syoEdullisesti(kortti));
        assertTrue(kassapaate.syoMaukkaasti(kortti));
        assertEquals(360,kortti.saldo());
    }
    
    @Test
    public void myytyjenLounaidenMaaraKasvaaKortillaOstettaessa(){
        kassapaate.syoEdullisesti(kortti);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(1,kassapaate.edullisiaLounaitaMyyty());
        assertEquals(1,kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void EiTarpeeksiRahaaKortillaToimiiOikein(){
        kortti.otaRahaa(900);
        assertFalse(kassapaate.syoEdullisesti(kortti));
        assertFalse(kassapaate.syoMaukkaasti(kortti));
        assertEquals(100, kortti.saldo());
        assertEquals(0,kassapaate.edullisiaLounaitaMyyty());
        assertEquals(0,kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kassanRahaMaaraEiMuutuKortillaMaksaessa(){
        kassapaate.syoEdullisesti(kortti);
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void kortinLatausToimiiOikein(){
        kassapaate.lataaRahaaKortille(kortti, 500);
        kassapaate.lataaRahaaKortille(kortti, -100);
        assertEquals(1500,kortti.saldo());
        assertEquals(100500,kassapaate.kassassaRahaa());
    }
    


}

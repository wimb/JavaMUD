/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.factories;
    
import be.vdab.entities.Gebruiker;
import be.vdab.entities.Karakter;
import be.vdab.entities.Lokatie;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 0.1: 02-10-2013 (tmtvl): Initial version.
 */
public final class TestObjectsFactory {
    private static final Gebruiker TEST_GEBRUIKER = new Gebruiker();
    private static final Karakter TEST_KARAKTER = new Karakter();
    private static final Lokatie TEST_LOKATIE = new Lokatie();
    
    private static boolean gebruikerInitialized = false;
    private static boolean karakterInitialized = false;
    private static boolean lokatieInitialized = false;
    
    private TestObjectsFactory(){
        
    }
    
    private static void initGebruiker(){
        TEST_GEBRUIKER.setVoornaam("Jonathan");
        TEST_GEBRUIKER.setNaam("Test");
        TEST_GEBRUIKER.setEmailAdres("J0n@than@nick.com");
        TEST_GEBRUIKER.setPaswoord("MUD");
        gebruikerInitialized = true;
    }
    
    private static void initKarakter(){
        if(!gebruikerInitialized){
            initGebruiker();
        }
        if(!lokatieInitialized){
            initLokatie();
        }
        TEST_KARAKTER.setId(1);
        TEST_KARAKTER.setNaam("Testaenar");
        TEST_KARAKTER.setGebruiker(TEST_GEBRUIKER);
        TEST_KARAKTER.setLokatie(TEST_LOKATIE);
        karakterInitialized = true;
    }
    
    private static void initLokatie(){
        TEST_LOKATIE.setId(1);
        TEST_LOKATIE.setBeschrijving("Test lokatie 1");
        lokatieInitialized = true;
    }
    
    public static Gebruiker getGebruiker(boolean metKarakter){
        if(!gebruikerInitialized){
            initGebruiker();
        }
        if(metKarakter){
            if(!karakterInitialized){
                initKarakter();
            }
        }
        return TEST_GEBRUIKER;
    }
    
    public static Karakter getKarakter(){
        if(!karakterInitialized){
            initKarakter();
        }
        return TEST_KARAKTER;
    }
    
    public static Lokatie getLokatie(boolean metKarakter){
        if(!lokatieInitialized){
            initLokatie();
        }
        if(metKarakter){
            if(!karakterInitialized){
                initKarakter();
            }
        }
        return TEST_LOKATIE;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2018;

import java.io.File;

/**
 *
 * @author Merry Xmas
 */
public class Muveletekbejegyzesekkel {

    static void fileletrehozas(String utvonal, String nev) {

        File file = new File(utvonal, nev);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("a fájl létrejött" + file.getPath());
                };
            } catch (Exception e) {
                System.out.println("A fájl nem jött létre" + file.getPath());
            }
        } else {
            System.out.println("a fájl már létezik:" + file.getPath());
        }
    }

    static void mappaletrehozas(String utvonal, String nev) {
        File mappa = new File(utvonal, nev);
        if (!mappa.exists()) {
            if (mappa.mkdir()) {
                System.out.println("a mappa létrejött: " + mappa.getPath());

            }
        } else {
            System.out.println("a mappa már létezik" + mappa.getPath());
        }
    }

    static void mappallista(String utvonal) {
        File mappa = new File(utvonal);
        System.out.println("A " + mappa.getPath() + " mappa tartalma: ");
        if (mappa.isDirectory()) {
            String[] mappatartalom = mappa.list();
            if (mappatartalom == null) {
                System.out.println("a mappa üres");
            } else {
                for (String bejegyzesek : mappatartalom) {
                    System.out.print(bejegyzesek + " ,");
                    System.out.println("");

                }
            }

        } else {
            System.out.println("német létezik a mappa");
        }
    }
    static void fileatnevezes(String ut,String reginev, String ujnev){
        File regifile=new File(ut, reginev);
        File ujfile=new File(ut, ujnev);
        System.out.println("a regi file neve: "+regifile.getPath());
        System.out.println("az uj file neve: "+ujfile.getPath());
        if(regifile.exists()&!ujfile.exists()){
            if(regifile.renameTo(ujfile)){
                System.out.println("a fájl átnevezése sikeres");
            }else
                System.out.println("a fájl átnevezése nem sikerült");
        }
        
    }
    static void filetorles(String utvonal, String nev){
        File file=new File(utvonal,nev);
        if(file.exists()){
            if(file.delete()){
                System.out.println("a fájl törlése sikeres."+file.getPath());
            }else
                System.out.println("a fájl törlése nem sikerült"+file.getPath());
        }else
            System.out.println("a file már nem létezik"+file.getPath());
        
    }
    static void mappatorles(String utvonal){
        File mappa=new File(utvonal);
        if(mappa.exists()){
            File[]mappatartalom=mappa.listFiles();
            if(mappatartalom!=null){
                for (File file : mappatartalom) {
                    filetorles(utvonal, file.getName());
                    
                    
                }
                if(mappa.delete()){
                    System.out.println("a mappa törlése sikerült "+mappa.getPath());
                }
                else
                    System.out.println("a mappa törlése nem sikerült "+mappa.getPath());
                    
            }
        }else
            System.out.println("a mappa nem létezik"+mappa.getPath());
        
    }
    
    
    
    

    public static void main(String[] args) {
        fileletrehozas("C:\\Users\\Merry Xmas\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup", "haha.txt");
        mappaletrehozas("C:\\Users\\Merry Xmas\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Indítópult", "thahaárol");
////        mappallista("C:\\Users\\Merry Xmas\\Desktop");
//        mappallista("C:\\Users\\Merry Xmas\\Desktop\\tárol");
//        fileatnevezes("C:\\Users\\Merry Xmas\\Desktop", "file1.txt" , "file2.txt");
//        System.out.println("\n Most megtekinthető Intézőben a C:\\Users\\Merry Xmas\\Desktop\\tárol");
//        extra.Console.pressEnter();
//        filetorles("C:\\Users\\Merry Xmas\\Desktop\\tárol", "file1.txt");
//        mappatorles("C:\\Users\\Merry Xmas\\Desktop\\tárol");
        
        
        
    }

}


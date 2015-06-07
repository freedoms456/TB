/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas_b;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author eL
 */
public class Keamananruangkelas extends kelasabstrak{
    Scanner input;
  
    int Kekokohan;
       int Kuncipintudanjendela;
       int Bahaya;
int HasilKeamanan;
    public int getKekokohan() {
        return Kekokohan;
    }

    public void setKekokohan(int Kekokohan) {
        this.Kekokohan = Kekokohan;
    }

    public int getKuncipintudanjendela() {
        return Kuncipintudanjendela;
    }

    public int getHasilKeamanan() {
        return HasilKeamanan;
    }

    public void setHasilKeamanan(int HasilKeamanan) {
        this.HasilKeamanan = HasilKeamanan;
    }

    public void setKuncipintudanjendela(int Kuncipintudanjendela) {
        this.Kuncipintudanjendela = Kuncipintudanjendela;
    }

    public int getBahaya() {
        return Bahaya;
    }

    public void setBahaya(int Bahaya) {
        this.Bahaya = Bahaya;
    }
       
    void Input(){
        input= new Scanner (System.in);
        System.out.println("pilih Kekokohan: 1.lapuk 2.Sedang 3.Baik");
         setKekokohan(input.nextInt())  ;
        System.out.println("pilih Kunci Pintu dan Jendela: 1.Rusak 2.Baik");
         setKuncipintudanjendela(input.nextInt())  ;
        System.out.println("pilih Tingkat Bahaya : 1.Berbahaya 2.Waspada 3.Aman");
         setBahaya(input.nextInt())  ;
    }
    int Analisis(){
         setHasilKeamanan( getKekokohan()+ getKuncipintudanjendela()+ getBahaya());
        if(  getHasilKeamanan()>6){
        System.out.println("Keamanan kelas yang baik");  
        return 1;
        }
        else{
        System.out.println("Keamanan kelas yang buruk");
        }   
        return 0;
    }
    void Output(){
        System.out.println("Kelasi ini memiliki");
        Analisis();
    }
    
    void Save(){
        
     
		try{
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(namafile));
			os.writeObject("Kekokohan "+getKekokohan());
                        os.writeObject("Kuncipintudanjendela "+getKuncipintudanjendela());
                        os.writeObject("Bahaya "+getBahaya());
                        
			
			os.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
    String namafile = "Keamanan.txt";
    void Load(){
        try {
           
			ObjectInputStream b = new ObjectInputStream(new FileInputStream(namafile));
			b.readObject();
			System.out.println("kekokohan : "+getKekokohan());
			System.out.println("KuncipintudanJendela : "+getKuncipintudanjendela());
			System.out.println("Bahaya : "+getBahaya());
                       
                        
			b.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
}

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
public class Lingkunganruangkelas extends kelasabstrak{
    Scanner input;
    
    int KondisiLantai;
       int KondisiDinding;
       int KondisiAtap;
       int KondisiPintu;
       int KondisiJendela;
       int HasilLingkungan;

    public int getKondisiLantai() {
        return KondisiLantai;
    }

    public void setKondisiLantai(int KondisiLantai) {
        this.KondisiLantai = KondisiLantai;
    }

    public int getKondisiDinding() {
        return KondisiDinding;
    }

    public void setKondisiDinding(int KondisiDinding) {
        this.KondisiDinding = KondisiDinding;
    }

    public int getKondisiAtap() {
        return KondisiAtap;
    }

    public void setKondisiAtap(int KondisiAtap) {
        this.KondisiAtap = KondisiAtap;
    }

    public int getKondisiPintu() {
        return KondisiPintu;
    }

    public void setKondisiPintu(int KondisiPintu) {
        this.KondisiPintu = KondisiPintu;
    }

    public int getKondisiJendela() {
        return KondisiJendela;
    }

    public void setKondisiJendela(int KondisiJendela) {
        this.KondisiJendela = KondisiJendela;
    }

    public int getHasilLingkungan() {
        return HasilLingkungan;
    }

    public void setHasilLingkungan(int HasilLingkungan) {
        this.HasilLingkungan = HasilLingkungan;
    }
       
       
    
    public void Input(){
        
    input = new Scanner (System.in);
    System.out.println("pilih Kondisi Lantai : 1.Kotor 2.Sedang 3.Bersih");
     setKondisiLantai(input.nextInt())  ;
    System.out.println("pilih Kondisi Dinding : 1.Kotor 2.Sedang 3.Bersih");
     setKondisiDinding(input.nextInt())  ;
    System.out.println("pilih Kondisi Atap : 1.Kotor 2.Sedang 3.Bersih");
     setKondisiAtap(input.nextInt())  ;
    System.out.println("pilih Kondisi Pintu : 1.Kotor 2.Sedang 3.Bersih");
     setKondisiPintu(input.nextInt())  ;
    System.out.println("pilih Kondisi Jendela : 1.Kotor 2.Sedang 3.Bersih");
    }
    int Analisis(){
         setHasilLingkungan(  getKondisiLantai()+  getKondisiDinding()+  getKondisiAtap()+  getKondisiPintu()+  getKondisiJendela());
        if(  getHasilLingkungan()>9){
            System.out.println("Lingkungan kelas = Baik  ");
            return 1;
        }
        else{
            System.out.println("Lingkungan kelas =buruk");
            }
        return 0;
    }
    void Output(){
       Analisis();
    }
    void Save(){
        
      
		try{
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(namafile));
			os.writeObject("KondisiAtap : "+getKondisiAtap());
                        os.writeObject("KondisiDinding : "+getKondisiDinding());
                        os.writeObject("KondisiPintu : "+getKondisiPintu());
                        os.writeObject("KondisiJendela : "+getKondisiJendela());
                        os.writeObject("kondisi Lantai : "+getKondisiLantai());
                       
			
			os.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
	
                }}
    String namafile = "Lingkungan.txt";
     void Load(){
        try {
           
			ObjectInputStream b = new ObjectInputStream(new FileInputStream(namafile));
			b.readObject();
			System.out.println("KondisiAtap: "+getKondisiAtap());
			System.out.println("Kondisi Dinding : "+getKondisiDinding());
			System.out.println("Kondisi Pintu: "+getKondisiPintu());
                                System.out.println("KondisiJendela : "+getKondisiJendela());
                                System.out.println("Kondisi Lantai : "+getKondisiLantai());
                       
                        
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

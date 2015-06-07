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
public class Kebersihanruangkelas extends kelasabstrak{
    Scanner input;
    int SirkulasiUdara;
       int NilaiPencahayaan;
        int Kelembapan;
       int Suhu;
       int HasilKebersihan;

    public int getSirkulasiUdara() {
        return SirkulasiUdara;
    }

    public void setSirkulasiUdara(int SirkulasiUdara) {
        this.SirkulasiUdara = SirkulasiUdara;
    }

    public int getNilaiPencahayaan() {
        return NilaiPencahayaan;
    }

    public void setNilaiPencahayaan(int NilaiPencahayaan) {
        this.NilaiPencahayaan = NilaiPencahayaan;
    }

    public int getKelembapan() {
        return Kelembapan;
    }

    public void setKelembapan(int Kelembapan) {
        this.Kelembapan = Kelembapan;
    }

    public int getSuhu() {
        return Suhu;
    }

    public void setSuhu(int Suhu) {
        this.Suhu = Suhu;
    }

    public int getHasilKebersihan() {
        return HasilKebersihan;
    }

    public void setHasilKebersihan(int HasilKebersihan) {
        this.HasilKebersihan = HasilKebersihan;
    }
      
    
    public void Input(){
        input= new Scanner (System.in);
        System.out.println("pilih Sirkulasi Udara: 1.tersendat 2.Sedang 3.lancar");
         setSirkulasiUdara(input.nextInt())  ;
        System.out.println("pilih Nilai Pencahayaan: 1.<250 2.249<x<351");
         setNilaiPencahayaan(input.nextInt())  ;
        System.out.println("pilih Kelembapan(%) : 1.<70 atau >80 2.69<x<81");
         setKelembapan(input.nextInt())  ;
        System.out.println("pilih Suhu(celcius) : 1.1-19 C 2.>35 C 3.25-35 C");
         setSuhu(input.nextInt())  ;
}
    int Analisis(){
         setHasilKebersihan(  getSirkulasiUdara()+  getNilaiPencahayaan()+  getKelembapan()+  getSuhu());
        if(  getHasilKebersihan()>9){
        System.out.println("Kebersihan kelas yang Baik");
        return 1;
        }
        else{
            System.out.println("Kebersihan kelas yang Buruk");
        }
        return 0;
    }
    void Output(){
        System.out.println("Kebersihan kelas memiliki ");Analisis();
    }
    void Save(){
        
		try{
                  
     
    
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(namafile));
			os.writeObject("SirkulasiUdara: "+getSirkulasiUdara() );
                        os.writeObject("NilaiPencahayaan): "+getNilaiPencahayaan() );
                        os.writeObject("Kelembapan: "+getKelembapan() );
                        os.writeObject("Suhu: "+getSuhu() );
                        
			
			os.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
    }
    String namafile = "Kebersihan.txt";
    void Load(){
        try {
           
			ObjectInputStream b = new ObjectInputStream(new FileInputStream(namafile));
			b.readObject();
			System.out.println("kenyamanan : "+Analisis());
			System.out.println("Sirkulasi Udara : "+getSirkulasiUdara());
			System.out.println("Nilai Pencahayaan : "+getNilaiPencahayaan());
                        System.out.println("Kelembapan="+getKelembapan());
                        System.out.println("Suhu ="+getSuhu());
                        
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


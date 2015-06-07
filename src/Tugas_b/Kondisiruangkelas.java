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
public class Kondisiruangkelas extends kelasabstrak{
    Scanner input;
  
       int JumlahPintu;
       int JumlahJendela;
       int PanjangRuang;
       int LebarRuang;
       int JumlahKursi;
       int HasilKondisi;

    public int getHasilKondisi() {
        return HasilKondisi;
    }

    public void setHasilKondisi(int HasilKondisi) {
        this.HasilKondisi = HasilKondisi;
    }

    public int getJumlahPintu() {
        return JumlahPintu;
    }

    public void setJumlahPintu(int JumlahPintu) {
        this.JumlahPintu = JumlahPintu;
    }

    public int getJumlahJendela() {
        return JumlahJendela;
    }

    public void setJumlahJendela(int JumlahJendela) {
        this.JumlahJendela = JumlahJendela;
    }

    public int getPanjangRuang() {
        return PanjangRuang;
    }

    public void setPanjangRuang(int PanjangRuang) {
        this.PanjangRuang = PanjangRuang;
    }

    public int getLebarRuang() {
        return LebarRuang;
    }

    public void setLebarRuang(int LebarRuang) {
        this.LebarRuang = LebarRuang;
    }

    public int getJumlahKursi() {
        return JumlahKursi;
    }

    public void setJumlahKursi(int JumlahKursi) {
        this.JumlahKursi = JumlahKursi;
    }
       int Luas;
    public void Input(){
        input = new Scanner (System.in);
       
    System.out.println("Input Panjang Ruang:");
     setPanjangRuang(input.nextInt());
    System.out.println("Input Lebar Ruang ");
     setLebarRuang(input.nextInt()); 
    System.out.println("Input Jumlah Kursi");
     setJumlahKursi(input.nextInt());
    System.out.println("Input jumlah Pintu :1.1 pintu 2.2pintu");
     setJumlahPintu(input.nextInt());
    System.out.println("Input Jumlah jendela :1.tidak ada 2.1");
     setJumlahJendela(input.nextInt()); 
    }
    int Analisis(){
        if(getPanjangRuang() != getLebarRuang()){
            System.out.println("Ruangan ini berbentuk Persegi panjang dengan: ");
            Luas = getLebarRuang()*getPanjangRuang();
            System.out.println("Luas ="+Luas);
            
            
        }
        else{System.out.println("Ruangan ini tidak berbentuk Persegi panjang dengan: ");
            Luas = getLebarRuang()*getPanjangRuang();
            System.out.println("Luas ="+Luas);
            
        }
        double Rasio;
        Rasio = Luas/getJumlahKursi();
        System.out.println("Rasio="+Rasio);
        
        if(Rasio >= 0.5){
            System.out.println("Rasio = Sesuai");   
        }
        else{
            System.out.println("Rasio = Tidak Sesuai");
        }
       
        
        if(  getJumlahJendela() >1){
        System.out.println("Jumlah jendela Sesuai");
        return 1;
    }else {
        System.out.println("Jumlah Jendela tidak Sesuai");
    }
        if(getJumlahPintu() > 1){
            System.out.println("Jumlah Pintu Sesuai");
            return 1;
        }
        else{
            System.out.println("Jumlah Pintu Tidak Sesuai");
            
        }
        return 0;
    }
    void Output(){
        Analisis();
    }
    void Save(){
      
		try{
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(namafile));
			os.writeObject("panjang kelas : "+getPanjangRuang());
			os.writeObject("lebar kelas : "+getLebarRuang());
			os.writeObject("jumlah kursi : "+getJumlahKursi());
			os.writeObject("jumlah pintu : "+getJumlahPintu());
			os.writeObject("jumlah jendela : "+getJumlahJendela());
			os.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
    }
    String namafile = "kondisikelas.txt";
    void Load(){
        try {
           
			ObjectInputStream b = new ObjectInputStream(new FileInputStream(namafile));
			b.readObject();
			System.out.println("Panjang Ruang : "+getPanjangRuang());
			System.out.println("Lebar Kelas : "+getLebarRuang());
			System.out.println("Jumlah Kursi: "+getJumlahKursi());
                                System.out.println("Jumlah Pintu : "+getJumlahPintu());
                                System.out.println("Jumlah Jendela : "+getJumlahJendela());
                       
                        
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

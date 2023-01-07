import java.util.Scanner;

public class main{
	
	public static String[] Numbers;
	
	public static void main(String[] args){
		Scanner myObj = new Scanner(System.in);  
	    System.out.println("Enter Number");
	    String Number = myObj.nextLine();
		Numbers = Number.split(" ");
		
		MaxDeger max = new MaxDeger(Numbers);
		MinDeger min = new MinDeger(Numbers);
		ortalamaHesapla ort = new ortalamaHesapla(Numbers);
		
		max.start();
		min.start();
		ort.start();
	}
	
}

class MaxDeger extends Thread{
	
	private String[] Numbers;
	public MaxDeger(String[] Numbers){
		this.Numbers = Numbers;
	}
	public void run() {
		int degisken =  Integer.parseInt(Numbers[0]);
		
		for(int i = 0; i<Numbers.length; i++) {
			if(degisken < Integer.parseInt(Numbers[i])) {
				degisken = Integer.parseInt(Numbers[i]);
			}
		}
		System.out.println("Maximum Değer = " + degisken);
	}
}

class MinDeger extends Thread{
	private String[] Numbers;
	public MinDeger(String[] Numbers){
		this.Numbers = Numbers;
	}
	
	 public void run() {
		int degisken =  Integer.parseInt(Numbers[0]);
		for(int i = 0; i<Numbers.length; i++) {
			if(degisken > Integer.parseInt(Numbers[i])) {
				degisken = Integer.parseInt(Numbers[i]);
			}
		}
		System.out.println("Minimum Değer = " + degisken);
	 }
}

class ortalamaHesapla extends Thread{
	
	private String[] Numbers;
	public ortalamaHesapla(String[] Numbers){
		this.Numbers = Numbers;
	}
	public void run() {
		int toplam = 0;
		int sayi;
		for(int i = 0; i<Numbers.length; i++) {
			sayi = Integer.parseInt(Numbers[i]);
			toplam+=sayi;
		}
		System.out.println("Ortalama Değer = " + toplam / Numbers.length);
	}
}

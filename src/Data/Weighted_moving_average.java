package Data;

import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

public class Weighted_moving_average {

	static Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		double value = -1;
		Vector<Double> H = new Vector<Double>();
		Vector<Double> WHA = new Vector<Double>();
		
		while(value != 0.0) {
			value = sc.nextDouble();			
			H.add(value);
		}
		
//		H.add(24.0);
//		H.add(23.7);
//		H.add(24.5);
//		H.add(25.0);
//		H.add(24.7);
//		H.add(25.5);
//		H.add(25.6);
//		H.add(25.0);
//		H.add(25.8);
//		H.add(26.3);
//		H.add(25.9);
//		H.add(26.8);
//		H.add(27.2);
//		H.add(26.5);
//		H.add(28.0);
//		H.add(0.0);
		
		
//		System.out.println("Vector: "+ H);
		
		CoutWHA(H,WHA);

		H.remove(H.size()-1);
		
		for(int i=0; i<= H.size()-1;i++) {
			if(i<3) {
				System.out.format("%d;%.2f;%n", i+1, H.get(i));
			}
			else {			
				System.out.format("%d;%.2f;%.2f%n", i+1, H.get(i), WHA.get(i-3));
			}
		}	
	}
	
	static void CoutWHA(Vector<Double> H, Vector<Double> WHA) {
		for(int i=3; i<= H.size()-1;i++) {
			WHA.add((4*H.get(i)+3*H.get(i-1)+2*H.get(i-2)+H.get(i-3))/10); 
		}
		
	}
}
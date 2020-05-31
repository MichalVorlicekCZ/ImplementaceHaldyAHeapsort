package cz.spsejecna.c2a.vorlicek.halda;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Halda heap = new Halda();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Pridej do haldy prvky: ");
		int cislo = sc.nextInt();
		while(cislo >= 0) {
			heap.insert(cislo);
			cislo = sc.nextInt();
		}
		
		System.out.println(heap.min());
		System.out.println(heap.size());
		System.out.println(heap.extractMin());
		System.out.println(heap.size());
/*		System.out.println(heap.min());
/*		System.out.println(heap.size());
		System.out.println(heap.extractMin());
		System.out.println(heap.extractMin());
*/
	}

}

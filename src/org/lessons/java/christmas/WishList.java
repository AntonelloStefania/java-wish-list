package org.lessons.java.christmas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import org.lessons.java.christmas.pojo.Regalo;

public class WishList {
	public static void main(String[] args) {
		
		List<Regalo> regali = new ArrayList<>();
		
		Scanner in = new Scanner(System.in);
		
		while(true) {
			System.out.print("\nvuoi aggiungere un regalo? ");
			String strAdd = in.nextLine();
			
			if (!strAdd.equals("si")) {
				System.out.print("vuoi ordinare la lista in ordine alfabetico per nome del regalo o destinatario? ");
				String strOrder= in.nextLine();
				
				
				if(strOrder.equals("regalo")) {
					System.out.println("\n----ordine alfabetico per nome regalo----\n");
					Collections.sort(regali, Comparator.comparing(Regalo::getNome));
				}else if(strOrder.equals("destinatario")) {
					System.out.println("\n----ordine alfabetico per nome destinatario----\n");

					Collections.sort(regali, Comparator.comparing(Regalo::getDestinatario));
				}
				
				break;
			}
			
			System.out.print("che regalo vuoi fare? ");
			String strRegalo = in.nextLine();
			
			System.out.print("a chi vuoi destinarlo? ");
			String strDestinatario = in.nextLine();
			
			System.out.println("numero regali: " + (regali.size()+1));
			
			Regalo e = new Regalo(strRegalo, strDestinatario);
			regali.add(e);
			
			
		}
		
		for(Regalo regalo: regali) {			
			System.out.println(regalo);	
		}
		System.out.println("totale numero regali: " + regali.size());
	}
	
	
}

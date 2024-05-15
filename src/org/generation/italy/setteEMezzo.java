package org.generation.italy;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.HashSet;

public class setteEMezzo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		// dichiarazione dati e arrayList
		String risposta="";
		float bilancio, punteggio=0, puntata;
		ArrayList<Integer> carte = new ArrayList<Integer>();
		HashSet<Integer> carteEstratte = new HashSet<Integer>();

		// generazione mazzo carte
		for (int i = 0; i < 40; i++) {
			carte.add(i);
		}
		System.out.println("Benvenuto al tavolo di 7 e 1/2");
		//richiesta inserimento saldo attuale
		do {
			System.out.println("Inserisci il tuo bilancio:");
			bilancio = sc.nextFloat();
			if (bilancio < 0)
				System.out.println("Impossibile sedersi al tavolo con un bilancio negativo");
		} while (bilancio < 0);
		do {
			//richiesta puntata
			System.out.println("Inserisci la tua puntata:");
			puntata = sc.nextFloat();
			sc.nextLine();
			if (puntata < 0)
				System.out.println("Impossibile puntare una somma di denaro pari o inferiore a zero");
			else if(puntata>bilancio)
				System.out.println("Impossibile puntare una somma di denaro maggiore di quella che possiedi già");
		} while (puntata < 0||puntata>bilancio);
		bilancio=bilancio-puntata;
		
		//estrazione carta utente carta computer
		do {
		int randomCard;
		String seme;
			do {
				//estrazione carta e attribuzione seme
				randomCard=r.nextInt(40); //generazione num da 0 a 39	
			}while(carteEstratte.contains(randomCard));
			carteEstratte.add(randomCard);
			if(randomCard+1<=10) {
				randomCard=randomCard+1;
				seme="bastoni";
			}else if(randomCard+1<=20) {
				randomCard=(randomCard+1)%10;
				seme="denari";
			}else if(randomCard+1<=30) {
				randomCard=(randomCard+1)%10;
				seme="spade";
			}else {
				randomCard=(randomCard+1)%10;
				seme="coppe";
			}
			System.out.println("la tua carta è "+carte.get(randomCard)+" di "+seme);
			
			//punteggio
			if(randomCard<=7) {
				punteggio=punteggio+randomCard;
			}else if(randomCard>7) {
				punteggio=punteggio+0.5f;
			}
			System.out.println("il tuo punteggio attuale è "+punteggio);
			if(punteggio>7.5f) {
				System.out.println("Hai sballato!");
			}else if(punteggio<7.5f) {
				System.out.println("vuoi un'altra carta?");
				risposta=sc.nextLine();
			}else if (punteggio==7.5f) {
				System.out.println("hai raggiunto il punteggio massimo");
			}
		}while(risposta.equalsIgnoreCase("si")||risposta.equalsIgnoreCase("sì")&&punteggio<=7.5f);
		
		
		
	}//fine main
	
}

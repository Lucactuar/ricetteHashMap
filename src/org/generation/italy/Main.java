package org.generation.italy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
        HashMap<String, Float> elencoIngredienti = new HashMap<>();
        elencoIngredienti.put("Farina", 364f);     //calorie per 100g
        elencoIngredienti.put("Latte", 42f);
        elencoIngredienti.put("Zucchero", 387f);
        elencoIngredienti.put("Uova", 155f);

        // Creazione della mappa per tenere traccia degli ingredienti e delle relative quantità
        HashMap<String, Float> ricetta = new HashMap<>();

        System.out.print("Inserisci il nome della ricetta: ");
        String nomeRicetta = sc.nextLine();

        System.out.println("Ingredienti disponibili:");
        for (String ingrediente : elencoIngredienti.keySet()) {
            System.out.println("- " + ingrediente);
        }

        // Inserimento degli ingredienti nella ricetta
        while (true) {
            System.out.print("Inserisci il nome dell'ingrediente: ");
            String nomeIngrediente = sc.nextLine();

            if (!elencoIngredienti.containsKey(nomeIngrediente)) {
                System.out.println("Ingrediente non valido. Riprova.");
                continue;
            }

            System.out.print("Inserisci la quantità di " + nomeIngrediente + " in grammi: ");
            float quantita = Float.parseFloat(sc.nextLine());
              
            ricetta.put(nomeIngrediente, quantita);

            System.out.print("Vuoi aggiungere un altro ingrediente? (sì/no): ");
            String risposta = sc.nextLine();
            if (risposta.equalsIgnoreCase("no")) {
                break;
            }
        }
        
        float caloriePer100g=0f;
        float calorieTotali=0f;
        // Calcolo delle calorie totali della ricetta
        for (String ingrediente : ricetta.keySet()) {
            float quantita = ricetta.get(ingrediente);

            caloriePer100g = elencoIngredienti.get(ingrediente);
            calorieTotali += (caloriePer100g*quantita)/1000;
            
            

            // Aggiunta delle calorie all'importo totale
                    }
        System.out.println("La ricetta '" + nomeRicetta + "' ha un totale di " + calorieTotali + " calorie.");
        
        sc.close();
    }
}
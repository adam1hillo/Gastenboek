package be.vdab;

import be.vdab.gastenboek.Gastenboek;
import be.vdab.gastenboek.GastenboekEntry;
import be.vdab.gastenboek.GastenboekManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        GastenboekManager manager = new GastenboekManager();
        Gastenboek gastenboek = manager.leesGastenBoek();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Maak uw keuze (T - tonen, S - schrijven, E - stop)");
        String keuze;
        while (!(keuze = scanner.nextLine()).equalsIgnoreCase("E")) {
            switch (keuze.toUpperCase()) {
                case "T" -> System.out.println(gastenboek);
                case "S" -> {
                    System.out.println("Wie is de schrijver?");
                    String schrijver = scanner.nextLine();
                    System.out.println("Schrijf uw boodschap:");
                    String boodschap = scanner.nextLine();
                    gastenboek.add(new GastenboekEntry(schrijver, boodschap));
                    manager.schrijfGastenboek(gastenboek);
                }
                default -> System.out.println("Onjuiste keuze, probeer opnieuw");
            }
            System.out.println("Maak uw keuze (T - tonen, S - schrijven, E - eindigen)");
        }

    }
}

package org.example.sodaslurper;

import java.util.Scanner;

public class Sodaslurper {

    public static void main(String[] args) {
        Sodaslurper sodaslurper = new Sodaslurper();
        sodaslurper.sodaslurper();
    }

    public void sodaslurper(){
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");

        int totalBottles = Integer.parseInt(inputs[0]) + Integer.parseInt(inputs[1]);;
        int bottlesRequired = Integer.parseInt(inputs[2]);

        int currentBottlesDrank = 0;
        while (totalBottles >= bottlesRequired) {
            
        }

        System.out.println(currentBottlesDrank);
    }
}

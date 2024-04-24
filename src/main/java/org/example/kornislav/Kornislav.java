package org.example.kornislav;

import java.util.Arrays;
import java.util.Scanner;

public class Kornislav {

    public static void main(String[] args) {
        Kornislav k = new Kornislav();
        k.Kornislav();
    }


    public void Kornislav(){
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] inputAsInt = new int[input.length];

        for(int i = 0; i < input.length; i++){
            inputAsInt[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(inputAsInt);

        System.out.println(inputAsInt[0] * inputAsInt[2]);

    }
}

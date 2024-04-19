package org.example.oddmanout;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class OddManOut {
    public static void main(String[] args) {
        OddManOut oddManOut = new OddManOut();
        oddManOut.OddManOut();
    }

    public void OddManOut(){
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for(int i = 0; i < numberOfCases; i++) {
            scanner.nextInt();
            scanner.nextLine();
            String peopleCodes = scanner.nextLine();

            String[] individualCodesSplit = peopleCodes.split(" ");
            Map<String, Integer> codeFrequencies = new HashMap<>();

            for(String code : individualCodesSplit){
                if (codeFrequencies.get(code) == null){
                    codeFrequencies.put(code, 1);
                } else {
                    codeFrequencies.put(code, codeFrequencies.get(code) + 1);
                }
            }

            for(Map.Entry<String, Integer> data : codeFrequencies.entrySet()){
                if(data.getValue() == 1){
                    System.out.println("Case #" + (i + 1) + ": " + data.getKey());
                }
            }
        }
    }
}

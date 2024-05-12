package org.example.relay;

import java.util.*;

public class BestRelayTeam {

    public static void main(String[] args) {
        BestRelayTeam b = new BestRelayTeam();
        b.bestRelay();
    }

    public void bestRelay() {
        Scanner scanner = new Scanner(System.in);
        int numberOfPlayer = scanner.nextInt();
        scanner.nextLine();

        Map<Double, String> firstLap = new TreeMap<>();
        Map<Double, String> otherLaps = new TreeMap<>();

        for (int i = 0; i < numberOfPlayer; i++) {
            String[] input = scanner.nextLine().split(" ");
            firstLap.put(Double.parseDouble(input[1]), input[0]);
            otherLaps.put(Double.parseDouble(input[2]), input[0]);
        }

        double smallest = Double.MAX_VALUE;
        List<String> names = new ArrayList<>();

        for (Map.Entry<Double, String> firstLaps : firstLap.entrySet()) {
            String name = firstLaps.getValue();
            Double speed = firstLaps.getKey();
            List<String> currentNames = new ArrayList<>();

            double currentSpeed = speed;
            currentNames.add(name);
            int count = 1;
            for (Map.Entry<Double, String> otherLapsDate : otherLaps.entrySet()) {
                Double speedTwo = otherLapsDate.getKey();
                String nameTwo = otherLapsDate.getValue();

                if (!name.equals(nameTwo)) {
                    currentSpeed += speedTwo;
                    currentNames.add(nameTwo);
                    count++;
                }

                if(count == 4){
                    if (currentSpeed < smallest){
                        smallest = currentSpeed;
                        names.clear();
                        names.addAll(currentNames);
                    }
                    break;
                }
            }
        }

        System.out.println(smallest);
        for(String name : names){
            System.out.println(name);
        }


    }
}

package org.example.relay;

import java.util.*;

class BestRelayTeam {

    public static void main(String[] args) {
        BestRelayTeam b = new BestRelayTeam();
        b.bestRelay();
    }

    public void bestRelay() {
        LapTime l = createLapDataFromInput();
        Map<String, Double> sortedFirstLaps = sortByLapTime(l.firstLap);
        Map<String, Double> sortedOtherLaps = sortByLapTime(l.otherLap);

        double smallestLapTime = Double.MAX_VALUE;
        List<String> relayTeam = new ArrayList<>();

        for(Map.Entry<String, Double> lap : sortedFirstLaps.entrySet()){
            List<String> currentTeam = new ArrayList<>(Collections.singletonList(lap.getKey()));
            double currentLapTime = lap.getValue();
            int currentTeamSize = 1;

            for(Map.Entry<String, Double> otherLap : sortedOtherLaps.entrySet()){
                if(!lap.getKey().equals(otherLap.getKey())){
                    currentTeam.add(otherLap.getKey());
                    currentLapTime += otherLap.getValue();
                    currentTeamSize++;
                }

                if(currentTeamSize == 4){
                    if (currentLapTime < smallestLapTime){
                        smallestLapTime = currentLapTime;
                        relayTeam.clear();
                        relayTeam.addAll(currentTeam);
                    }
                    break;
                }
            }
        }

        System.out.println(smallestLapTime);
        for(String name : relayTeam){
            System.out.println(name);
        }
    }

    public LapTime createLapDataFromInput(){
        Scanner scanner = new Scanner(System.in);
        LapTime l = new LapTime();

        int numberOfPlayer = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfPlayer; i++) {
            String[] input = scanner.nextLine().split(" ");
            l.firstLap.put(input[0], Double.parseDouble(input[1]));
            l.otherLap.put(input[0], Double.parseDouble(input[2]));
        }

        return l;
    }

    public Map<String, Double> sortByLapTime(Map<String, Double> map){
        List<Map.Entry<String, Double>> lapTimes = new LinkedList<>(map.entrySet());
        lapTimes.sort(Map.Entry.comparingByValue());

        Map<String, Double> sortedLapTimes = new LinkedHashMap<>();
        for(Map.Entry<String, Double> entry : lapTimes){
            sortedLapTimes.put(entry.getKey(), entry.getValue());
        }

        return sortedLapTimes;
    }

    static class LapTime {
        public Map<String, Double> firstLap;
        public Map<String, Double> otherLap;

        public LapTime(){
            this.firstLap = new TreeMap<>();
            this.otherLap = new TreeMap<>();
        }
    }
}

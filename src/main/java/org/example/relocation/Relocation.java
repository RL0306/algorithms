package org.example.relocation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Relocation {

    public static void main(String[] args) throws IOException {
        Relocation r = new Relocation();
        r.Relocation();
    }

    public void Relocation() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int capacity = Integer.parseInt(st.nextToken());
        int requests = Integer.parseInt(st.nextToken());

        int[] initialLocations = new int[capacity];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < capacity; i++) {
            initialLocations[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> companyLocations = new HashMap<>();

        for (int i = 0; i < capacity; i++) {
            companyLocations.put(i + 1, initialLocations[i]);
        }

        for (int i = 0; i < requests; i++) {
            st = new StringTokenizer(reader.readLine());
            int operation = Integer.parseInt(st.nextToken());
            int company = Integer.parseInt(st.nextToken());
            if (operation == 1) {
                int newLocation = Integer.parseInt(st.nextToken());
                companyLocations.put(company, newLocation);
            } else {
                int companyTwo = Integer.parseInt(st.nextToken());
                System.out.println(Math.abs(companyLocations.get(company) - companyLocations.get(companyTwo)));
            }
        }
    }
}

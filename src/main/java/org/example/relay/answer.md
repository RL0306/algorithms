## Step 1: Solving things by hand

#### Athletes and Lap Times
* ASHMEADE:
    * Best lap times from others: Bolt (8.43), Powell (8.61), Blake (8.72)
    * Combined score: 9.90 + 8.43 + 8.61 + 8.72 = 35.66
* BLAKE:
    * Best lap times from others: Bolt (8.43), Powell (8.61), Ashmeade (8.85)
    * Combined score: 9.69 + 8.43 + 8.61 + 8.85 = 35.58
* BOLT:
    * Best lap times from others: Powell (8.61), Blake (8.72), Ashmeade (8.85)
    * Combined score: 9.58 + 8.43 + 8.72 + 8.85 = 35.76
* CARTER:
    * Best lap times from others: Bolt (8.43), Powell (8.61), Blake (8.72)
    * Combined score: 9.78 + 8.43 + 8.61 + 8.72 = 35.54
* FRATER:
    * Best lap times from others: Bolt (8.43), Powell (8.61), Blake (8.72)
    * Combined score: 9.88 + 8.43 + 8.61 + 8.72 = 35.64
* POWELL:
    * Best lap times from others: Bolt (8.43), Powell (8.61), Ashmeade (8.85)
    * Combined score: 9.72 + 8.43 + 8.61 + 8.85 = 35.61
#### Optimal Team Selection The shortest combined time is 35.54 achieved with the following athletes:
* Carter
* Blake
* Powell
* Ashmeade

## Step 2: Abstract Formulation

Given a set of x strings separated by name, 1st lap time, other lap times, find the best four people that will have the minimum time.
The first person times should be considered from first lap times and the rest from the other lap times.

## Step 3: Pseudocode solution

```pseudo
    void bestRelay():
    // Initialize variables
    numberOfPlayer = readIntegerFromInput()
    firstLap = TreeMap<Double, String>()
    otherLaps = TreeMap<Double, String>()
    smallest = Double.MAX_VALUE
    names = List<String>()

    // Loop to read input for each player
    for i from 1 to numberOfPlayer:
        input = readLineFromInput()
        playerData = splitString(input, " ")
        name = playerData[0]
        speedFirstLap = parseDouble(playerData[1])
        speedOtherLap = parseDouble(playerData[2])

        // Store data in maps
        firstLap.put(speedFirstLap, name)
        otherLaps.put(speedOtherLap, name)

    // Loop through each player's first lap data
    for entry in firstLap:
        currentSpeed = entry.getKey()
        name = entry.getValue()
        currentNames = List<String>()
        currentNames.add(name)
        count = 1

        // Calculate combined speed for 4 players
        for otherEntry in otherLaps:
            speedTwo = otherEntry.getKey()
            nameTwo = otherEntry.getValue()

            if name != nameTwo:
                currentSpeed += speedTwo
                currentNames.add(nameTwo)
                count += 1

            // If we have 4 players, check for smallest combined speed
            if count == 4:
                if currentSpeed < smallest:
                    smallest = currentSpeed
                    names.clear()
                    names.addAll(currentNames)
                break

    // Output the result
    print(smallest)
    for name in names:
        print(name)
```

The aim is to tie together parts 2 and 3: part 2 says what you want to do, part 3 suggests a solution,
and part 4 should show that part 3 is really a solution to part 2.

Right now your proof is just a restatement in plain language of what part 3 does, but it doesn't explain the connection to part 2.

## Step 4: Proof of correctness

Iterating through the entire one lap list and then combining their lap time with the next three fastest lap times (from otherLaps map) to form a team of four athletes.
If this results in a smaller time we then update the smallest value for the next iterations to check again.

Once all iterations are done we then know we have the smallest result as every possible case is determined.
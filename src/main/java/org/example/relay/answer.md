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
// Main function to determine the best relay team
function bestRelay()
    // Create LapTime object by reading input data
    LapTime lapData = createLapDataFromInput()

    // Sort the lap times for first laps and other laps
    Map sortedFirstLaps = sortByLapTime(lapData.firstLap)
    Map sortedOtherLaps = sortByLapTime(lapData.otherLap)

    // Initialize the smallest lap time to a large value
    double smallestLapTime = MAX_VALUE
    // Initialize the best relay team as an empty list
    List relayTeam = []

    // Iterate through each runner's first lap time
    for each entry in sortedFirstLaps
        // Get the current runner's name and lap time
        String currentRunner = entry.key
        double currentFirstLapTime = entry.value

        // Initialize current team with the first lap runner
        List currentTeam = [currentRunner]
        double currentLapTime = currentFirstLapTime
        int currentTeamSize = 1

        // Iterate through other laps to find additional team members
        for each otherEntry in sortedOtherLaps
            // Get the current runner's name and other lap time
            String otherRunner = otherEntry.key
            double otherLapTime = otherEntry.value

            // Skip if the runner is already in the team
            if currentRunner != otherRunner
                // Add the runner to the current team
                currentTeam.add(otherRunner)
                currentLapTime += otherLapTime
                currentTeamSize++

                // Check if the team has 4 members
                if currentTeamSize == 4
                    // Update the smallest lap time and best team if a better team is found
                    if currentLapTime < smallestLapTime
                        smallestLapTime = currentLapTime
                        relayTeam = copy(currentTeam)
                    
                    // Break as we found a complete team
                    break

    // Output the smallest lap time and the names of the best relay team members
    print(smallestLapTime)
    for each name in relayTeam
        print(name)

```
## Step 4: Proof of correctness

We initialise the `smallestLapTime` to the largest value, this ensures that any smaller value will be smaller than this. We have an empty list `relayTeam` which will hold the names of the relay team.

After parsing the input the two maps will hold date of every person from smallest to largest.

Iterating through `sortedFirstLaps` and then sequentially iterating through `sortedOtherLaps` we keep updating the currentTeamSize till it gets to 4 at which point we check if we got the fastest lap time for that possible first lap.

Once we reach the end of the loops we know by iterating through every possible persons first lap time we know that we return we obtained the fastest relay team.

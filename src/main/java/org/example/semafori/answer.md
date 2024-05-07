## Step 1: Solving things by hand

- **Case 1:**

  Input:
    2 10
    3 5 5
    5 2 2

- travels 3 (3 seconds) - end of traffic light
    Traffic lights after each second:
    2 4 5 (1 second)
    5 1 2
    
    1 3 5 (2 seconds)
    5 0 2
    
    0 2 5 (3 seconds)
    5 2 1


- wait 2 seconds for green light
    Traffic lights after each second:
    0 1 5 (1 second)
    5 2 0
    
    0 0 5 (2 second)
    5 1 2


- travels 2 (2 seconds) - reach new traffic light
    Traffic lights after each second:
    5 0 2 (1 second)
    
    5 2 1 (2 seconds)


- travels 5 (5 second) end of road

Total = 12


## Step 2: Abstract Formulation

Given a number of traffic lights and distance to reach the end of the road work out how long it takes to get to the get off the road encountering red and green lights. 
Each measurement takes a second. 
We can only move on a green and must wait for the red light to finish.

## Step 3: Pseudocode solution

```pseudo
    void semafori(){
        currentTime = 0;
        int trafficLights = input...
        int totalDistance = input...
        
        for
    }
```
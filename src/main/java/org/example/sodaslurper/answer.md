## Step 1: Solving things by hand

e = number of empty soda bottles at start of day
f = number of empty soda bottles found during the day
c = number of empty bottles required to buy a new soda

- **Case 1:**

  Input = 9 0 3

  Bottles = 9 + 0 = 9

  Buying bottles:

    - 9 / 3 = 3 bottles, remainder 0
    - 3 / 3 = 1 bottle, remainder 0

  Total bottles = 3 + 1 = 4

<br>

- **Case 2:**

  Input = 5 5 2

  Bottles = 5 + 5 = 10

  Buying bottles:

    - 10 / 2 = 5 bottles, remainder 0
    - 5 / 2 = 2 bottles, remainder 1
    - 3 / 2 = 1 bottle, remainder 1
    - 2 / 2 = 1 bottle, remainder 0

  Total bottles = 5 + 2 + 1 + 1 = 9


## Step 2: Abstract Formulation

Given three integers e (number of empty bottles), f (number of empty bottles found during the day), c (number of empty bottles required to buy a new soda)
work out total number of bottles can that can be bought (e + f / c) including using the empty bottles that are gathered after drinking.

When bottleCounter < c then we know we cannot buy anymore.

## Step 3: Pseudocode solution

```pseudo
   void sodaslurper(){
        bottlesStart = input ...         
        bottlesDuringDay = input ...
        bottlesReq = input ...
        
        totalBottles = bottlesStart + bottlesDuringDay 10
        currentBottlesDrank = 0
        
        while(totalBottles > bottlesReq) {
          bottlesDrank = totalBottles / bottlesReq 5
          currentBottlesDrank += bottlesDrank 5

          
          if remainder > 0
            totalBottles += remainder
          
          totalBottles -= bottlesDrank * bottlesRequired;  
        }
        
        print currentBottlesDrank
   }
```

## Step 4: Proof of correctness

CurrentBottlesDrank is initially set to 0. This will be our tracker value to know how many drinks have been drank.
TotalBottles will initially hold the value of e and f 

Once we break out our condition we know that we are no longer able to buy anymore as we don't have enough to meet the minimum required to buy another.
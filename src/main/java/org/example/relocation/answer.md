## Step 1: Solving things by hand

Given:
- 5 companies
- Initial locations: 5 2 8 1 4
- Requests:
    - Relocation: 1 2 10 (Company 2 moves to location 10)
    - Distance calculation: 2 4 5 (Company 4 location = 1, Company 5 location = 4. Answer = 4 - 1 = 3)
    - Distance calculation: 2 1 3 (Company 1 location = 5, Company 3 location = 8. Answer = 8 - 5 = 3)
    - Relocation: 1 4 3 (Company 4 moves to location 3)
    - Distance calculation: 2 1 5 (Company 1 location = 5, Company 5 location = 4. Answer = 5 - 4 = 1)
    - Distance calculation: 2 5 2 (Company 5 location = 4, Company 2 location = 10. Answer = 10 - 4 = 6)
    - Relocation: 1 4 1 (Company 4 moves to location 1)
    - Distance calculation: 2 2 4 (Company 2 location = 10, Company 4 location = 1. Answer = 10 - 1 = 9)
    - Relocation: 1 3 15 (Company 3 moves location to 15)
    - Distance calculation: 2 4 1 (Company 4 location = 1, Company 1 location = 5. Answer = 5 - 1 = 4)



## Step 2: Abstract Formulation

Given a set of initial locations for x amount of companies we will handle two sets of requests. 
    1. To move a companies location to another position (it can be moved to the same location as another)
    2. To work out the distance from one company location to another companies location. CompanyX location - CompanyY location.

## Step 3: Pseudocode solution

```pseudo
function location():
    // Read capacity and amount of requests
    capacityAndRequestsInfo = readLine()
    capacity = capacityAndRequestsInfo[0]
    amountOfRequests = capacityAndRequestsInfo[1]
    
    // Read initial locations
    initialLocations = readLine().split()
    
    // Initialize map to store company locations
    companyLocation = new Map
    
    // Store initial company locations in the map
    for i from 1 to capacity:
        companyLocation[i] = parseInt(initialLocations[i-1])  // Parse initial location to integer
    
    // Process requests
    for each request in range(amountOfRequests):
        requestInfo = readLine().split()
        
        // Relocation request
        if requestInfo[0] == 1:
            companyId = parseInt(requestInfo[1])
            newLocation = parseInt(requestInfo[2])
            companyLocation[companyId] = newLocation
        
        // Distance calculation request
        else:
            companyOne = parseInt(requestInfo[1])
            companyTwo = parseInt(requestInfo[2])
            distance = companyLocation[companyOne] - companyLocation[companyTwo]
            print(distance)
```

## Step 4: Proof of correctness

Before executing the request the companyLocation map is empty. When handling the requests we set the maps key to the company and the value as the location. After processing all relocation requests, the companyLocation map accurately represents the final locations of all companies.
The algorithm correctly computes the distance between the specified companies locations. When processing a distance calculation request, the algorithm subtracts the locations of the specified companies to calculate the distance.

The algorithm iterates through all requests. There is an x number of requests, and each request is processed once, the algorithm will terminate after processing all requests.

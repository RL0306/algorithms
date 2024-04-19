## Step 1: Solving things by hand

- **Case 1:**
    - **Input:** 3
        - values = 1 2147483647 2147483647
        - **Answer:** 1

- **Case 2:**
    - **Input:** 5
        - values = 3 4 7 4 3
        - **Answer:** 7

- **Case 3:**
    - **Input:** 5
        - values = 2 10 2 10 5
        - **Answer:** 5


## Step 2: Abstract Formulation

Given a list of values which are odd and where an input can only appear twice, find which number from the input values 
occurs only once.

## Step 3: Pseudocode solution

```pseudo
numberFrequencies = empty map
for int num : nums
    count = numberFrequencies[num]
    numberFrequencies[num] = count + 1

for key : numberFrequencies
    if key.getValue == 1
        return key.getKey()
unreachable
```

## Step 4: Proof of correctness

Consider a run of the algorithm with input values. We prove one thing:

Initially the map is empty, during each iteration of the loop we store the frequencies of each number we come across. After doing so we then loop through the map
till we come across a key that has a value of 1 indicating that it only appeared one in the input array since we iterated through the entire input.




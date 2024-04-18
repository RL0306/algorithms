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

Given values, find which number does not have a matching pair such that the count of `values[i] = 0`.

## Step 3: Pseudocode solution

```pseudo
numberFrequencies = empty map
for int num : nums
count = numberFrequencies[num]
numberFrequencies[num] = count + 1

for map.entry key : numberFrequencies.entrySet
if key.getValue == 1
    return key.getKey()
unreachable
```

## Step 4: Proof of correctness

Consider a run of the algorithm with input values. We prove one thing:

1. If the algorithm returns, the answer is correct.
    - For part 1, if the algorithm returns `key.getKey()`, we know that we found a value which does not have a matching pair and therefore came by itself. Hence, the result is correct as for it to have a pair, it would need a value of 2.
    - We range over the entire entry set till we find a valid result with a value of 1

**Conclusion:**
In this algorithm, we will always get a return result, therefore meaning this algorithm is correct.



## Step 1: Solving things by hand

- **Case 1:**
    - **Input:** 1 2 3 4
        - **Answer:** 3, since 1 will be the longest width and 3 will be the longest length without any overlapping (1 * 3)

- **Case 2:**
    - **Input:** 4 4 3 4
        - **Answer:** 12, since 3 will be the longest width and 4 will be the longest length without any overlapping (3 * 4)

## Step 2: Abstract Formulation

Given only four integers work out the maximum area. Using each number once and ensuring that both widths and lengths are the same.
The rectangle must be enclosed so the lengths must be the same size and the widths must be the same size.

## Step 3: Pseudocode solution

```pseudo
int maximumArea([]nums){
    sortedNums = arrays.sort(nums)
    return sortedNums[0] * sortedNums[2]
}
```

## Step 4: Proof of correctness

We sort the input array of integers `nums`, ensuring that the smallest and third integers are multiplied in order to get the maximum area.

Assume that the first two indexes sortedNums refers to the width (sortedNums[0], sortedNums[1]) the width would have to be sortedNums[0] in order to make sure there was no overlapping.
Assume that the last two indexes sortedNums refers to the length (sortedNums[2], sortedNums[3]) the length would have to be sortedNums[2] in order to make sure there was no overlapping.

Sorting the input ensures that the first and third value will maximize the area and ensure that the rectangle is enclosed overall meaning that our algorithm will work and will return the maximum area.

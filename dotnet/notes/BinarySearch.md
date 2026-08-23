# Binary Search
The classic, general-purpose algorithm for binary search is the `lower_bound` / `upper_bound` pair — this is literally what C++'s `std::lower_bound`/`std::upper_bound` and Python's `bisect_left`/`bisect_right` are built on. It's the half-open (j = n) template from earlier, and it naturally handles both of your requirements at once.

```csharp
// First index where nums[index] >= target ("lower_bound")
private int LowerBound(int[] nums, int target)
{
    var i = 0;
    var j = nums.Length;
    while (i < j)
    {
        var mid = i + (j - i) / 2;
        if (nums[mid] < target) i = mid + 1;
        else j = mid;
    }
    return i;
}

// First index where nums[index] > target ("upper_bound")
private int UpperBound(int[] nums, int target)
{
    var i = 0;
    var j = nums.Length;
    while (i < j)
    {
        var mid = i + (j - i) / 2;
        if (nums[mid] <= target) i = mid + 1;
        else j = mid;
    }
    return i;
}
```

Notice the two functions differ by exactly one character — < vs <=. That's the whole "tweak between first and last".

Here's the full breakdown of `LowerBound`, with the "why" for each piece — this ties together everything from this conversation into one coherent picture.

```csharp
private int LowerBound(int[] nums, int target)
{
    var i = 0;
    var j = nums.Length;
    while (i < j)
    {
        var mid = i + (j - i) / 2;
        if (nums[mid] < target) i = mid + 1;
        else j = mid;
    }
    return i;
}
```

1. The interval [i, j) and its invariant

i and j aren't just "pointers" — they encode a claim that's true at every point in the loop:

Everything in nums[0..i-1] is < target. Everything in nums[j..n-1] is >= target. Everything in between ([i, j)) is still undetermined.

Initially i=0, j=n — both halves of the claim are vacuously true (there's nothing outside [0, n) to check). This invariant is the thing every other piece exists to preserve.

2. Why i = 0, j = n (half-open, not j = n-1)

j is deliberately allowed to be a position past the last real index. That's what lets the invariant — and therefore the final answer — represent "target is bigger than everything, doesn't exist" as i = n, instead of that case being structurally impossible.

3. Why the loop condition is i < j

While i < j, there's still at least one undetermined candidate — keep narrowing. The moment i == j, the invariant itself finishes the job: everything before i is < target and everything from i onward is >= target, so i is the first index >= target, by definition, with no further testing needed. That's why the loop can stop exactly there rather than needing an extra check.

4. Why mid = i + (j - i) / 2 (floor)

Two jobs at once:

i + (j-i) instead of (i+j) avoids integer overflow for huge arrays (minor, but standard practice).
Floor division guarantees i <= mid < j whenever i < j — so mid is always a real, valid array index (never j itself, which might be out of bounds when j = n), and critically, mid is always strictly less than j. That last part is what guarantees progress on the j = mid branch (see #6).

5. Why the branches are nums[mid] < target → i = mid+1 / else → j = mid

This is where the invariant gets proven, one step at a time:

If nums[mid] < target, we've just learned mid belongs in the "too small" region — so it's safe to move i past it (i = mid+1), extending the "everything before i is < target" side of the invariant to include mid.
Otherwise (nums[mid] >= target), mid belongs in the "big enough" region — but it might be the very first one, so it can't be discarded. Setting j = mid (not mid - 1) keeps it as a live candidate while extending the "everything from j onward is >= target" side of the invariant down to mid.

6. Why this always terminates (progress guarantee)

Each iteration strictly shrinks [i, j): either i jumps to mid+1, which is > mid >= i (strictly bigger), or j drops to mid, which is < j (guaranteed by floor mid from #4). Either way the interval gets strictly smaller every iteration, so it must reach i == j — no infinite loop is possible, and it takes O(log n) iterations since the interval roughly halves each time.

7. Why the return value needs a follow-up check

return i gives you the position satisfying the invariant, not a promise that target is actually there — i could be n (nothing qualifies), or nums[i] could be some value > target (target has a gap where it would go, but isn't present). That's why existence requires the explicit i < nums.Length && nums[i] == target check afterward — the function's contract is "insertion point," and "does it exist" is a separate question layered on top.

Every piece is load-bearing for one of two things: maintaining the invariant (interval bounds, branch updates) or guaranteeing termination (loop condition, mid formula). That's the whole algorithm.
#!/usr/bin/env dotnet

public interface IHeap<T>
{
    public void Enqueue(T item);
    public T Dequeue();
    public T Peek();
}

public class Heap<T>(Comparer<T> comparer) : IHeap<T>
{
    private readonly Comparer<T> _comparer = comparer;
    private readonly List<T> _content = new List<T>();

    public T Dequeue()
    {
        var result = _content[0];

        var lastIndex = _content.Count - 1;
        Swap(0, lastIndex);
        _content.RemoveAt(lastIndex);

        FixDownwards();

        return result;
    }

    public void Enqueue(T item)
    {
        _content.Add(item);

        FixUpwards();
    }

    public T Peek()
    {
        return _content.First();
    }

    private void FixDownwards()
    {
        var i = 0;
        while (i < _content.Count)
        {
            var leftChildIndex = GetLeftChildIndex(i);
            var rightChildIndex = leftChildIndex + 1;

            // Exit when no children
            if (leftChildIndex >= _content.Count)
            {
                return;
            }

            // Default swapIndex to leftChildIndex
            var swapIndex = leftChildIndex;
            // Use rightChildIndex if "right child comes before left child" according to comparer
            if (rightChildIndex < _content.Count)
            {
                var useRight =
                    _comparer.Compare(_content[rightChildIndex], _content[leftChildIndex]) < 0;
                if (useRight)
                {
                    swapIndex = rightChildIndex;
                }
            }

            // Swap if "swap (child) comes before curr" according to comparer
            var toSwap = _comparer.Compare(_content[swapIndex], _content[i]) < 0;
            // Exit if no swap
            if (!toSwap)
            {
                return;
            }

            // Swap
            Swap(i, swapIndex);
            i = swapIndex;
        }
    }

    private void FixUpwards()
    {
        var i = _content.Count - 1;
        while (i > 0)
        {
            // Set swapIndex to parentIndex
            var swapIndex = GetParentIndex(i);

            // Swap if "curr comes before swap (parent)" according to comparer
            var toSwap = _comparer.Compare(_content[i], _content[swapIndex]) < 0;
            // Exit if no swap
            if (!toSwap)
            {
                return;
            }

            // Swap
            Swap(i, swapIndex);
            i = swapIndex;
        }
    }

    private int GetParentIndex(int i)
    {
        return (i + 1) / 2 - 1;
    }

    private int GetLeftChildIndex(int i)
    {
        return (i + 1) * 2 - 1;
    }

    private void Swap(int a, int b)
    {
        (_content[a], _content[b]) = (_content[b], _content[a]);
    }
}

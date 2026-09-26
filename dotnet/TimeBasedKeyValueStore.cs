#!/usr/bin/env dotnet
// https://leetcode.com/problems/time-based-key-value-store/description/

public class TimeMap
{
    private readonly Dictionary<string, List<(string value, int timestamp)>> _store;

    public TimeMap()
    {
        _store = new Dictionary<string, List<(string value, int timestamp)>>();
    }

    public void Set(string key, string value, int timestamp)
    {
        var newItem = (value, timestamp);
        if (_store.TryGetValue(key, out var items))
        {
            items.Add(newItem);
        }
        else
        {
            _store[key] = [newItem];
        }
    }

    public string Get(string key, int timestamp)
    {
        var result = "";
        if (_store.TryGetValue(key, out var items))
        {
            // Find last element where item.timestamp <= timestamp
            var firstIndexWithTsLargerThanTarget = BinarySearch(items, timestamp);
            if (firstIndexWithTsLargerThanTarget > 0)
            {
                var lastIndexWithTsLesserOrEqualToTarget = firstIndexWithTsLargerThanTarget - 1;
                return items[lastIndexWithTsLesserOrEqualToTarget].value;
            }
        }

        return result;
    }

    private int BinarySearch(List<(string value, int timestamp)> items, int targetTs)
    {
        var i = 0;
        var j = items.Count;

        while (i < j)
        {
            var mid = i + (j - i) / 2;
            var midTs = items[mid].timestamp;

            if (midTs <= targetTs) i = mid + 1;
            else j = mid;
        }

        return i;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.Set(key,value,timestamp);
 * string param_2 = obj.Get(key,timestamp);
 */
#!/usr/bin/env dotnet
// https://leetcode.com/problems/accounts-merge/description/
#:include utils/ConsoleUtil.cs

public class Solution
{
    public IList<IList<string>> AccountsMerge(IList<IList<string>> accounts)
    {
        var parent = accounts.Select((item, index) => index).ToArray();
        var size = new int[parent.Length];
        Array.Fill(size, 1);

        int Find(int i)
        {
            if (parent[i] == i)
            {
                return i;
            }
            parent[i] = Find(parent[i]);
            return parent[i];
        }
        void Union(int i, int j)
        {
            var rootOfI = Find(i);
            var rootOfJ = Find(j);
            if (rootOfI == rootOfJ)
            {
                return;
            }
            if (size[rootOfI] > size[rootOfJ])
            {
                parent[rootOfJ] = rootOfI;
                size[rootOfI] += size[rootOfJ];
            }
            else
            {
                parent[rootOfI] = rootOfJ;
                size[rootOfJ] += size[rootOfI];
            }
        }

        var emailToAccountIndex = new Dictionary<string, int>();
        for (var accountIndex = 0; accountIndex < accounts.Count; accountIndex++)
        {
            var account = accounts[accountIndex];
            for (var emailIndex = 1; emailIndex < accounts[accountIndex].Count; emailIndex++)
            {
                var email = account[emailIndex];
                if (emailToAccountIndex.TryGetValue(email, out var foundAccountIndex))
                {
                    Union(foundAccountIndex, accountIndex);
                }
                else
                {
                    emailToAccountIndex[email] = accountIndex;
                }
            }
        }

        var rootAccountIndexToAllAccountIndexListMap = new Dictionary<int, IList<int>>();
        for (var accountIndex = 0; accountIndex < accounts.Count; accountIndex++)
        {
            var rootAccountIndex = Find(accountIndex);
            if (rootAccountIndexToAllAccountIndexListMap.TryGetValue(rootAccountIndex, out var accountIndexList))
            {
                accountIndexList.Add(accountIndex);
            }
            else
            {
                rootAccountIndexToAllAccountIndexListMap[rootAccountIndex] = [accountIndex];
            }
        }

        var results = new List<IList<string>>();
        foreach (var accountIndexList in rootAccountIndexToAllAccountIndexListMap.Values)
        {
            var name = accounts[accountIndexList[0]][0];
            var emails = new HashSet<string>();
            foreach (var accountIndex in accountIndexList)
            {
                var account = accounts[accountIndex];
                for (var emailIndex = 1; emailIndex < account.Count; emailIndex++)
                {
                    emails.Add(account[emailIndex]);
                }
            }
            var sortedEmails = emails.OrderBy(i => i, StringComparer.Ordinal).ToList();
            sortedEmails.Insert(0, name);
            results.Add(sortedEmails);
        }

        return results;
    }
}
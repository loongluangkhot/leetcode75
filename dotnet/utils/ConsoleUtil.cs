public static class ConsoleUtil
{
    public static string GetFormattedStrOfArr<T>(this IEnumerable<T> arr)
    {
        return $"[{string.Join(",", arr)}]";
    }

    public static void PrintArr<T>(this IEnumerable<T> arr)
    {
        Console.WriteLine(arr.GetFormattedStrOfArr());
    }

    public static string GetFormattedStrOfJaggedArr<T>(this IEnumerable<IEnumerable<T>> arr)
    {
        return $"[{string.Join(", ", arr.Select(GetFormattedStrOfArr))}]";
    }

    public static void PrintJaggedArr<T>(this IEnumerable<IEnumerable<T>> arr)
    {
        Console.WriteLine(arr.GetFormattedStrOfJaggedArr());
    }
}
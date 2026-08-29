#!/usr/bin/env dotnet
// https://leetcode.com/problems/course-schedule/description/

// // DFS with coloring (cycle detection)
// public class Solution {
//     public bool CanFinish(int numCourses, int[][] prerequisites) {
//         var state = new int[numCourses]; // 0 unvisited; 1 visiting; 2 visited
//         var graph = new List<int>[numCourses];
//         foreach (var c in prerequisites)
//         {
//             var course = c[0];
//             var prereq = c[1];
//             if (graph[course] == null)
//             {
//                 graph[course] = [prereq];
//             }
//             else
//             {
//                 graph[course].Add(prereq);
//             }
//         }

//         for (int i = 0; i < numCourses; i++)
//         {
//             if (state[i] == 0 && HasCycle(i, state, graph))
//             {
//                 return false;
//             }
//         }

//         return true;
//     }

//     private bool HasCycle(int i, int[] state, List<int>[] graph)
//     {
//         if (state[i] == 1)
//         {
//             return true;
//         }

//         if (state[i] == 2)
//         {
//             return false;
//         }

//         state[i] = 1;
//         var prereqs = graph[i];
//         if (prereqs != null)
//         {
//             foreach (var j in prereqs)
//             {
//                 if (HasCycle(j, state, graph))
//                 {
//                     return true;
//                 }
//             }
//         }

//         state[i] = 2;

//         return false;
//     }
// }

// Kahn's algorithm (BFS topological sort)
// Intuition: peel off the outer layer, repeat.
public class Solution
{
    public bool CanFinish(int numCourses, int[][] prerequisites)
    {
        var courseDegrees = new int[numCourses];
        var prereqToCourseGraph = new List<int>[numCourses];
        foreach (var courseAndPrereq in prerequisites)
        {
            var course = courseAndPrereq[0];
            var prereq = courseAndPrereq[1];

            courseDegrees[course]++;
            if (prereqToCourseGraph[prereq] == null)
            {
                prereqToCourseGraph[prereq] = [course];
            }
            else
            {
                prereqToCourseGraph[prereq].Add(course);
            }
        }

        var q = new Queue<int>();
        for (var i = 0; i < numCourses; i++)
        {
            if (courseDegrees[i] == 0)
            {
                q.Enqueue(i);
            }
        }

        while (q.Count > 0)
        {
            var courseToTake = q.Dequeue();
            if (prereqToCourseGraph[courseToTake] != null)
            {
                foreach (var courseWithPrereq in prereqToCourseGraph[courseToTake])
                {
                    courseDegrees[courseWithPrereq]--;
                    if (courseDegrees[courseWithPrereq] == 0)
                    {
                        q.Enqueue(courseWithPrereq);
                    }
                }
            }
        }

        return courseDegrees.All(i => i == 0);
    }
}

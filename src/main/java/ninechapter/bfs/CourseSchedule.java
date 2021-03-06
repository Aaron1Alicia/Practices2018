package ninechapter.bfs;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites==null || prerequisites.length==0 || numCourses==0) {
            return true;
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for(int i=0; i<numCourses; i++) {
            indegree.put(i, 0);
            graph.put(i, new HashSet<>());
        }

        for(int[] prerequisite: prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];

            indegree.put(to, indegree.get(to)+1);
            graph.get(from).add(to);
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i=0; i<numCourses; i++) {
            if(indegree.get(i)==0) {
                queue.offer(i);
            }
        }

        int cnt = 0;

        while(queue.size()>0) {
            int cur = queue.poll();
            cnt++;

            for(int neighbor: graph.get(cur)) {
                indegree.put(neighbor, indegree.get(neighbor)-1);
                if(indegree.get(neighbor)==0) {
                    queue.offer(neighbor);
                }
            }
        }

        return cnt==numCourses;
    }

    public boolean canFinishUsingDFS(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for(int i=0; i<numCourses; i++){
            graph.put(i, new HashSet<>());
        }

        for(int[] prerequisite: prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        int[] courses = new int[numCourses];

        for(int i=0; i<numCourses; i++) {
            if(!canFinish(i, courses, graph)) {
                return false;
            }
        }

        return true;
    }

    private boolean canFinish(int course, int[] courses, Map<Integer, Set<Integer>> graph) {
        if(courses[course]==1) {
            return true;
        }

        if(courses[course]==-1) {
            return false;
        }

        courses[course] = -1;

        for(int neighbor: graph.get(course)) {
            if(!canFinish(neighbor, courses, graph)) {
                return false;
            }
        }

        courses[course] = 1;
        return true;
    }
}

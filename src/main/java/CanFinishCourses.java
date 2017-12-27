import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 现在你总共有 n 门课需要选，记为 0 到 n - 1.
 一些课程在修之前需要先修另外的一些课程，比如要学习课程 0 你需要先学习课程 1 ，表示为[0,1]
 给定n门课以及他们的先决条件，判断是否可能完成所有课程？
 本质就是拓扑排序
 */
public class CanFinishCourses {

	/*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// write your code here
		Map<Integer, List<Integer>> graph = buildGraph(numCourses, prerequisites);

		return ifCanFinish(numCourses, graph);
	}

	private  static  Map<Integer, List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {

		Map<Integer, List<Integer>> result = new HashMap<>();

		for (int i = 0; i < prerequisites.length; i++) {

			int[] conditions = prerequisites[i];

			List<Integer> temp = result.computeIfAbsent(conditions[1], x -> new ArrayList<>());
			temp.add(conditions[0]);
		}

		return result;
	}

	private static boolean ifCanFinish(int numCourses, Map<Integer, List<Integer>> graph) {

		Queue<Integer> preNodes = new LinkedList<>();
		int[] pres = new int[numCourses];

		for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {

			for (Integer i : entry.getValue()) {
				pres[i]++;
			}
		}

		for (int i = 0; i < numCourses; i++) {
			if (pres[i] == 0) {
				preNodes.add(i);
			}
		}

		int count = 0;
		while(!preNodes.isEmpty()) {
			int visit = preNodes.poll();
			if (graph.get(visit) != null) {
				for (Integer i : graph.get(visit)) {
					pres[i]--;
					if (pres[i] == 0) {
						preNodes.add(i);
					}
				}}
			count++;

		}

		return count == numCourses;
	}
}

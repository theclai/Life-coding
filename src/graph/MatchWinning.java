package graph;

import java.util.*;

public class MatchWinning {
    public static class MatchResult {
        public String winning;
        public String losing;

        public MatchResult(String winning, String losing) {
            this.winning = winning;
            this.losing = losing;
        }
    }

    public static boolean canTeamABeatTeamB(List<MatchResult> matches,
                                            String teamA,
                                            String teamB) {
        Map<String, Set<String>> graph = buildGraph(matches);
        return isReachableByUsingDFS(graph, teamA, teamB, new HashSet<String>());

    }

    private static boolean isReachableByUsingDFS(
            Map<String, Set<String>> graph,
            String teamA,
            String teamB,
            HashSet<String> visited) {
        if (teamA.equals(teamB)) {
            return true;
        } else if (visited.contains(teamA) || graph.get(teamA) == null) { // team did not win anything
            return false;
        }
        visited.add(teamA);

        return graph.get(teamA).stream().anyMatch(team -> isReachableByUsingDFS(graph, team, teamB, visited));
    }

    private static Map<String, Set<String>> buildGraph(List<MatchResult> matches) {
        Map<String, Set<String>> graph = new HashMap<>();
        if (matches != null) {
            for (MatchResult match : matches) {
                graph.putIfAbsent(match.winning, new HashSet<>()).add(match.losing);

            }
        }
        return graph;
    }
}

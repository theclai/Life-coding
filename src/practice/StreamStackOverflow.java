package practice;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamStackOverflow {
    public static void main(String[] args) {

        List<Game> games = new ArrayList<>();
        Game g1 = new Game();
        List<Outcome> o1 = new ArrayList<>();
        o1.add(new Outcome(0));
        o1.add(new Outcome(1));
        g1.setOutcomes(o1);
        games.add(g1);

        Game g2 = new Game();
        List<Outcome> o2 = new ArrayList<>();
        o2.add(new Outcome(0));
        o2.add(new Outcome(0));
        g2.setOutcomes(o2);
        games.add(g2);
        printStatistics(games);
    }

    public static class Game {
        List<Outcome> outcomes;

        public List<Outcome> getOutcomes() {
            return outcomes;
        }

        public void setOutcomes(List<Outcome> outcomes) {
            this.outcomes = outcomes;
        }
    }

    static class Outcome {
        public Outcome(float outcome) {
            if (outcome == 0)
                WIN = outcome;
            else if (outcome == 1)
                LOSE = outcome;
            else if (outcome == 2)
                DRAW = outcome;
            else
                ALL = outcome;
        }

        public static float WIN;
        public static float LOSE;
        public static float DRAW;
        public static float ALL;

    }

    public static void printStatistics(List<Game> games) {
        float win = 0;
        float lose = 0;
        float draw = 0;
        float all = 0;


        Map<Outcome,Long> map= games.stream().flatMap(game -> game.outcomes.stream()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        long w = map.get(Outcome.WIN);
        long l = map.get(Outcome.LOSE);
        System.out.println(w);
        System.out.println(l);
    }
}

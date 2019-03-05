package practice;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClimateOfficeStackoverflow {

    static class Calculations {
        int time;
        int temp;


        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getTemp() {
            return temp;
        }

        public void setTemp(int temp) {
            this.temp = temp;
        }

        public Calculations(int time, int temp) {
            this.time = time;
            this.temp = temp;
        }
    }

    private ArrayList<Calculations> calculation = new ArrayList<>();
    public static ArrayList<Climate_Office> office = new ArrayList<>();
    private String town;

    public Stream<Calculations> getStream() {
        return this.calculation.stream();
    }

    public static class Climate_Office {
        List<Calculations> calculation;
        String town;

        public Climate_Office(String town) {
            calculation = new ArrayList<>();
            this.town = town;
        }

        public String getTown() {
            return town;
        }

        public List<Calculations> getCalculation() {
            return calculation;
        }

        public void setCalculation(List<Calculations> calculation) {
            this.calculation = calculation;
        }

        public double avgTemp(int beginTime, int finishTime) {

            Predicate<Calculations> cals = me -> me.getTime() >= beginTime && me.getTime() <= finishTime;
            OptionalDouble avgTempCal = this.getCalculation()
                    .parallelStream()
                    .filter(cals)
                    .mapToDouble(me -> me.getTemp())
                    .average();
            return avgTempCal.getAsDouble();
        }

        public double median(int beginTime, int finishTime) {

            Predicate<Calculations> cals = me -> me.getTime() >= beginTime && me.getTime() <= finishTime;
            List<Calculations> filtered = this.getCalculation()
                    .stream()
                    .filter(cals)
                    .collect(Collectors.toList());
            Collections.sort(filtered, Comparator.comparingInt(Calculations::getTemp));

            double median;
            int len = filtered.size();
            if (len % 2 == 0)
                median = ((double) filtered.get(len / 2).getTemp() + (double) filtered.get(len / 2 - 1).getTemp()) / 2;
            else
                median = (double) filtered.get(len / 2).getTemp();
            return median;
        }
    }


    public static void main(String[] args) {

        Climate_Office office1 = new Climate_Office("York");
        Climate_Office office2 = new Climate_Office("Bath");

        Calculations cal1 = new Calculations(5853, 18);
        Calculations cal2 = new Calculations(340, 9);
        List<Calculations> calcs1 = new ArrayList<>();
        calcs1.add(cal1);
        calcs1.add(cal2);
        office1.setCalculation(calcs1);

        Calculations cal3 = new Calculations(2381, 18);
        Calculations cal4 = new Calculations(439, 4);
        List<Calculations> calcs2 = new ArrayList<>();
        calcs2.add(cal3);
        calcs2.add(cal4);
        office2.setCalculation(calcs2);
        office.add(office1);
        office.add(office2);


        for (int n = 0; n < office.size(); n++) {
            System.out.println(office.get(n).getTown() + " avg temp is" + office.get(n).avgTemp(0, 2300));
            System.out.println(office.get(n).getTown() + " median temp is" + office.get(n).median(0, 2300));
        }

    }
}

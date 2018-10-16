package ds_algo_course.algorithms_on_graphs.week3;

public class CelebrationPartyProblem {
    public static void main(String[] args) {
        // Just assume data is sorted, if not just sort it out
        double[] ages = new double[]{2.5, 3.2, 3.5, 4.0, 4.8, 5.2, 6.0};
        double min = ages[0];
        double max = ages[ages.length - 1];
        System.out.println(minimumTeacherRequired(ages, min, max));
    }

    private static int minimumTeacherRequired(double[] ages, double min, double max) {
        int teacher_count = 0;
        int i = 0;
        while (i <= ages.length - 1) {
            if (ages[i] > min + 1) {
                // make it as a group
                teacher_count++;
                min = ages[i];
            }
            i++;
        }
        return teacher_count + 1;//
    }
}

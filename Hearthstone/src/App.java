//import java.lang.reflect.Method;
import java.util.*;
//import commons-math3-62.jar;

public class App {
    public static void main(String[] args) throws Exception {
   
        //System.out.println(combination(24, 6));
        List<int[]> combinations = generate(24, 6);

        double highest = 0;
        String remember = "";

        /*
    K i the number of cards of a certain cost
    k is the number of K cards drawn
    N is the population size
    n is the number of draws
    */

        for (int[] combination : combinations) {
                //System.out.println(Arrays.toString(combination));
                double temp = 0;
                int max = 0;
                for(int i=0; i<combination.length; i++)
                {
                    //System.out.print(combination[i]);
                    max+= combination[i];
                    //System.out.println(1- hyperGeo(combination[i]+1, 0, 10, i+4));
                    //temp+= (1- hyperGeo(combination[i]+1, 0, 10, i+4));
                }
                System.out.println(Arrays.toString(combination));
                if(max==30){
                    for(int i=0; i<combination.length; i++)
                        {
                            //System.out.println(combination[i]);
                            //System.out.println(1- hyperGeo(combination[i], 0, 30, i+4));
                            temp+= (1- hyperGeo(combination[i], 0, 10, i+4));
                        }
                }
                //System.out.println();
                if(temp>highest) {
                highest = temp;
                    remember = Arrays.toString(combination);
                    //System.out.println("Current highest: " + highest + " using: "+ remember);
                }
                
            }
        System.out.println();
        System.out.println("highest: " + highest + " using: "+ remember);
        
        System.out.printf("generated %d combinations of %d items from %d ", combinations.size(), 30, 6);

    }

    private static void helper(List<int[]> combinations, int data[], int start, int end, int index) {
        if (index == data.length) {
            int[] combination = data.clone();
            combinations.add(combination);
        } else {
            int max = Math.min(end, end + 1 - data.length + index);
            for (int i = start; i <= max; i++) {
                data[index] = i;
                helper(combinations, data, i + 1, end, index + 1);
            }
        }
    }

    public static List<int[]> generate(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        helper(combinations, new int[r], 0, n-1 , 0);
        return combinations;
    }


    static double factorial(double n) {
        double fact = 1;
        double i = 1;
        while(i <= n) {
           fact *= i;
           i++;
        }
        return fact;
     }

    static double combination(double n, double r) {
        double num = factorial(n);
        double dem = factorial(r)*factorial(n-r);
        return Math.ceil(num/dem);
    }



    /*
    K i the number of cards of a certain cost
    k is the number of K cards drawn
    N is the population size
    n is the number of draws
    */
    static double hyperGeo(double K, double k, double N, double n) {
        return (combination(K, k)*combination(N-K, n-k))/combination(N, n);
    }


    /*
    6 card costs
    preset 1 of each card cost
    24 remaing cards for deck
    144 total cards
    
    sum of probabilities for each 144 choose 24

    */

    
}

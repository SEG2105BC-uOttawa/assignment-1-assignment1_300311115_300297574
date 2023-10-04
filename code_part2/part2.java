import java.util.Random;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Iterator;

public class part2 {

    public static void arrayTest(int testSize) {

        long start = System.currentTimeMillis();

        Random r = new Random();

        int array[] = new int[testSize];

        for (int i = 0; i < testSize; i++) {
            array[i] = r.nextInt(10);
        }

        Long finishPopulation = System.currentTimeMillis();

        int sum = 0;

        for (int i = 0; i < testSize; i++) {
            sum += array[i];
        }

        Long finishIteration = System.currentTimeMillis();

        System.out.println("Time elapsed (population) (array): " + (finishPopulation - start) / 1000.0 + " seconds");
        
        System.out.println("Time elapsed (iteration) (array): " + (finishIteration - finishPopulation) / 1000.0 + " seconds");
    }

    public static void arrayListTest(int testSize) {

        long start = System.currentTimeMillis();

        Random r = new Random();

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < testSize; i++) {
            arrayList.add(r.nextInt(10));
        }

        Long finishPopulation = System.currentTimeMillis();

        Iterator<Integer> iterator = arrayList.iterator();

        int sum = 0;

        while(iterator.hasNext()) {
            sum += iterator.next();
        }

        Long finishIteration = System.currentTimeMillis();

        System.out.println("Time elapsed (population) (arrayList): " + (finishPopulation - start) / 1000.0 + " seconds");
    
        System.out.println("Time elapsed (iteration) (arrayList): " + (finishIteration - finishPopulation) / 1000.0 + " seconds");
    }

    public static void vectorTest(int testSize) {

        long start = System.currentTimeMillis();

        Random r = new Random();

        Vector<Integer> vector = new Vector<>();

        for (int i = 0; i < testSize; i++) {
            vector.add(r.nextInt(10));
        }

        Long finishPopulation = System.currentTimeMillis();

        Iterator<Integer> iterator = vector.iterator();

        int sum = 0;

        while(iterator.hasNext()) {
            sum += iterator.next();
        }

        Long finishIteration = System.currentTimeMillis();

        System.out.println("Time elapsed (population) (vector): " + (finishPopulation - start) / 1000.0 + " seconds");
    
        System.out.println("Time elapsed (iteration) (vector): " + (finishIteration - finishPopulation) / 1000.0 + " seconds");
    }

    public static void main(String[] args) {

        int testSize = 600000000;

        arrayTest(testSize);

        System.out.println();

        // 600000000 makes it run for over 10 seconds
        arrayListTest(testSize);

        System.out.println();

        vectorTest(testSize);
    }
}

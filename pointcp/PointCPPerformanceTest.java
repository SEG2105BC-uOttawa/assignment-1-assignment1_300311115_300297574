import design2.PointCP2;
import design5.PointCP25;
import design5.PointCP35;
import design5.PointCP5;
import design3.PointCP3;

import java.util.Random;

public class PointCPPerformanceTest {

    public static void main(String[] args) {

        int numberOfTestsRun = 100000000;

        System.out.println("##### POINTCP2 TEST #####\n\n");
        Random rand = new Random();
        
        double x1 = rand.nextDouble();
        double x2 = rand.nextDouble();
        double y1 = rand.nextDouble();
        double y2 = rand.nextDouble();
        PointCP2 A = new PointCP2('P',x1, y1);
        PointCP2 B = new PointCP2('P', x2, y2);
        for(int i=0; i<10; i++){
            System.out.println("// Run "+i);
            PointCP2.TestRunTime(numberOfTestsRun, A, B);
        }
        System.out.println("\n\n");

        System.out.println("##### POINTCP3-5 TEST #####\n\n");
        
        double rho1 = rand.nextDouble();
        double rho2 = rand.nextDouble();
        double theta1 = rand.nextDouble();
        double theta2 = rand.nextDouble();
        PointCP3 C = new PointCP3('C', rho1, theta1);
        PointCP3 D = new PointCP3('C', rho2, theta2);
        for(int i=0; i<10; i++){
            System.out.println("// Run "+i);
            PointCP3.TestRunTime(numberOfTestsRun, C, D);
        }
        System.out.println("\n\n");
    
        
        System.out.println("##### POINTCP3-5 TEST #####\n\n");
        
        double v1 = rand.nextDouble();
        double v2 = rand.nextDouble();
        double v3 = rand.nextDouble();
        double v4 = rand.nextDouble();

        PointCP5 E = new PointCP35('C', v1, v2);
        PointCP5 F = new PointCP35('C', v3, v4);
        for(int i=0; i<10; i++){
            System.out.println("// Run "+i);
            PointCP5.TestRunTime(numberOfTestsRun, E, F);
        }

        PointCP5 G = new PointCP25('P', v1, v2);
        PointCP5 H = new PointCP25('P', v1, v2);

        System.out.println("##### POINTCP2-5 TEST #####");
        for(int i=0; i<10; i++){
            System.out.println("// Run "+i);
            PointCP5.TestRunTime(numberOfTestsRun, G, H);
        }
        System.out.println("\n\n");
    }
}

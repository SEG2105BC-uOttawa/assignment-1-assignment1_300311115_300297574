package design5;
// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at http://www.site.uottawa.ca/school/research/lloseng/

import java.util.Random;

import design2.PointCP2;

/**
 * This class contains instances of coordinates in either polar or
 * cartesian format.  It also provides the utilities to convert
 * them into the other type. It is not an optimal design, it is used
 * only to illustrate some design issues.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @version July 2000
 */
public abstract class PointCP5
{
  private char coordinateType;

  private double xOrRho;

  private double yOrTheta;

  public PointCP5(char type, double xOrRho, double yOrTheta){
    if(type != 'C' && type != 'P') 
      throw new IllegalArgumentException(); 
    else if(type =='C')
    { 
      this.xOrRho = xOrRho; 
      this.yOrTheta = xOrRho; 
    } 
    else{ 
      this.xOrRho = Math.cos(Math.toRadians(yOrTheta)) * xOrRho; 
      this.yOrTheta = Math.sin(Math.toRadians(yOrTheta)) * xOrRho; 
    } 
  }
 
  public abstract double getX();

  public abstract double getY();
  
  public abstract double getRho();
  
  public abstract double getTheta();
  
  public abstract void convertStorageToPolar();
	
  public abstract void convertStorageToCartesian();
  
  public abstract PointCP5 rotatePoint(double rotation);

  public abstract String toString();

  public abstract double getDistance(PointCP5 pointB);

  public static void TestRunTime(int runTimes, PointCP5 pointA, PointCP5 pointB){
    double totalTime = 0;

    for(int i=0; i<runTimes; i++){
        double start = System.nanoTime();
        pointA.convertStorageToPolar();
        double end = System.nanoTime();
        totalTime += (end - start);
    }
    System.out.println("convertStorageToPolar() -> The average runtime was : "+totalTime/runTimes+" ns");
    totalTime = 0;


    for(int i=0; i<runTimes; i++){
        double start = System.nanoTime();
        pointA.convertStorageToCartesian();
        double end = System.nanoTime();
        totalTime += (end - start);
    }
    System.out.println("convertStorageToCartesian() -> The average runtime was : "+totalTime/runTimes+" ns");
    totalTime = 0;


    for(int i=0; i<runTimes; i++){
        double start = System.nanoTime();
        pointA.getDistance(pointB);
        double end = System.nanoTime();
        totalTime += (end - start);
    }
    System.out.println("getDistance(PointCP2 pointB) -> The average runtime was : "+totalTime/runTimes+" ns");
    totalTime = 0;

    double angle = new Random().nextDouble();
    for(int i=0; i<runTimes; i++){
        double start = System.nanoTime();
        pointA.rotatePoint(angle);
        double end = System.nanoTime();
        totalTime += (end - start);
    }
    System.out.println("rotatePoint(double rotation) -> The average runtime was : "+totalTime/runTimes+" ns");
    totalTime = 0;
    }
}

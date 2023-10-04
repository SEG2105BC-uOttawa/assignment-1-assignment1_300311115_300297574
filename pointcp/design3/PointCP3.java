package design3;
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
public class PointCP3{
  //Instance variables ************************************************

  private char coordinateType;
  /**
   * Contains the current value of X 
   */
  private double x;
  
  /**
   * Contains the current value of Y 
   */
  private double y;
	
  
  //Constructors ******************************************************

  /**
   * Constructs a coordinate object, with a type identifier.
   */
  public PointCP3(char type, double x, double y)
  {
    if(type != 'C' && type != 'P')
    throw new IllegalArgumentException();
    
    if(String.valueOf(type).toUpperCase() == "P"){
      this.y = y;
      this.x = x;
    }else{
      this.y = y;
      this.x = x;
      convertStorageToPolar();
    }
  }
	
  
  //Instance methods **************************************************
 
 
  public double getX(){return x;}
  
  public double getY(){return y;}
  
  public double getRho(){return (Math.cos(Math.toRadians(y)) * x);}
  
  public double getTheta() {return (Math.sin(Math.toRadians(y)) * x);}
  
	
    /**
   * Converts Cartesian coordinates to Polar coordinates.
   */
  public void convertStorageToPolar()
  {
    if(coordinateType != 'P')
    {
      //Calculate RHO and THETA
      double temp = getRho();
      y = getTheta();
      x = temp;
      
      coordinateType = 'P';  //Change coord type identifier
    }
  }
	
  /**
   * Converts Polar coordinates to Cartesian coordinates.
   */
  public void convertStorageToCartesian()
  {
    if(coordinateType != 'C')
    {
      //Calculate X and Y
      double temp = getX();
      y = getY();
      x = temp;
   
      coordinateType = 'C';	//Change coord type identifier
    }
  }

 
  /**
   * Calculates the distance in between two points using the Pythagorean
   * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
   *
   * @param pointA The first point.
   * @param pointB The second point.
   * @return The distance between the two points.
   */
  public double getDistance(PointCP3 pointB)
  {
    // Obtain differences in X and Y, sign is not important as these values
    // will be squared later.
    double deltaX = getX() - pointB.getX();
    double deltaY = getY() - pointB.getY();
    
    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
  }

  /**
   * Rotates the specified point by the specified number of degrees.
   * Not required until E2.30
   *
   * @param point The point to rotate
   * @param rotation The number of degrees to rotate the point.
   * @return The rotated image of the original point.
   */
  public PointCP3 rotatePoint(double rotation)
  {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();
        
    return new PointCP3('C',
      (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
  }

  /**
   * Returns information about the coordinates.
   *
   * @return A String containing information about the coordinates.
   */
  public String toString()
  {
    return "Stored as Cartesian ("+ getX() + "," + getY() + ")";
  }

  public static void TestRunTime(int runTimes, PointCP3 pointA, PointCP3 pointB){
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

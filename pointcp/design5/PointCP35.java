package design5;
// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at http://www.site.uottawa.ca/school/research/lloseng/


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
public class PointCP35 extends PointCP5
{
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
  public PointCP35(char type, double x, double y)
  {  
    super(type, x, y);
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
  public double getDistance(PointCP5 pointB)
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
  public PointCP35 rotatePoint(double rotation)
  {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();
        
    return new PointCP35('C',
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
}

package be.kdg.backendfrontend.Calculation;

import java.lang.Math;
import java.nio.file.Path;
import java.text.DecimalFormat;


public class PathFinder {
    // In this class you will find the formula based on Lukas paper formula
    // I will probably make the documentation for this formula because it may be a bit confusing
    // I am not sure if this needs to be a constructor or just functions

    // IMPORTANT:
    // KEEP IN MIND THAT WHEN ENTERING THE DATA YOU NEED TO TAKE INTO ACCOUNT THAT EAST AND NORTH ARE POSITIVE VALUES
    // AND WEST AND SOUTH ARE NEGATIVE VALUES

    // This is used to round the decimal points
    private static final DecimalFormat df2 = new DecimalFormat("0.00");
    private static final DecimalFormat df4 = new DecimalFormat("0.0000");


    private double x1; // x1 is the x coordinate of the boat
    private double y1; // boat
    private double x2; // x2 is the x coordinate of the MOB victim
    private double y2; // MOB victim
    private double boatVelocity; // velocity of the boat
    private double mobVelocity; // velocity of the MOB victim
    private double angle; // angle of the travel path of the boat (given in navigational degrees)



    //    public PathFinder(double x2, double y2, double angle) {
//        this.x2 = x2 * 1000;
//        this.y2 = y2 * 1000;
//        this.x1 = 4.403 * 1000;
//        this.y1 = 51.21 * 1000;
//        this.boatVelocity = 2;
//        this.mobVelocity = 1;
//        this.angle = angle;
//    }

    public PathFinder(double x1, double y1, double x2, double y2, double boatVelocity, double mobVelocity, double angle) {
        x1 = 100 * x1;
        y1 = 100 * y1;
        x2 = 100 * x2;
        y2 = 100 * y2;
        this.x1 = /*convertMinutesToDecimal(x1)*/ x1;
        this.y1 = /*convertMinutesToDecimal(y1)*/ y1;
        this.x2 = /*convertMinutesToDecimal(x2)*/ x2;
        this.y2 = /*convertMinutesToDecimal(y2)*/ y2;
        System.out.println("x1: " + this.x1 + ", y1: " + this.y1 + ", x2: " + this.x2 + ", y2: " + this.y2);
        this.boatVelocity = boatVelocity;
        this.mobVelocity = mobVelocity;
        this.angle = angle;
    }



    // This method will convert the minutes into decimal numbers in the original coordinates
    private double convertMinutesToDecimal(double coordinateInMinutes) {
        int decimalPart = (int) coordinateInMinutes / 100;
        return decimalPart * 100 + ((coordinateInMinutes - (decimalPart * 100)) / 60 * 100);
    }

//    public static void main(String[] args) {
//// Pathfinder test
//        PathFinder pathFinder = new PathFinder(4.403, 51.21, 4.403, 51.22, 2, 1, 45);
//
////		PathFinder pathFinder2 = new PathFinder(4.403, 51.25, 45);
//
//        System.out.println("Distance: " + df4.format(pathFinder.calculateDistance(pathFinder)));
//        System.out.println("Boat angle: " + df4.format(pathFinder.getBoatAngle(pathFinder)));
//        System.out.println("Intersect angle: " + df4.format(pathFinder.calculateIntersectAngle(pathFinder)));
//        System.out.println("Intersect distance: " + df4.format(pathFinder.calculateIntersectDistance(pathFinder)));
//        System.out.println("Intersect point x:" + df4.format(pathFinder.calculateIntersectX(pathFinder)));
//        System.out.println("Intersect point y:" + df4.format(pathFinder.calculateIntersectY(pathFinder)));
//
////		System.out.println("Distance: " + pathFinder2.calculateDistance(pathFinder2));
////		System.out.println("Boat angle: " + pathFinder2.getBoatAngle(pathFinder2));
////		System.out.println("Intersect angle: " + pathFinder2.calculateIntersectAngle(pathFinder2));
////		System.out.println("Intersect distance: " + pathFinder2.calculateIntersectDistance(pathFinder2));
////		System.out.println("Intersect point x:" + pathFinder2.calculateIntersectX(pathFinder2));
////		System.out.println("Intersect point y:" + pathFinder2.calculateIntersectY(pathFinder2));
//    }


    // This method works both ways
    private double convertCompassDegreesAndMathDegrees(Double angleInDegrees) {
        double angleInRadians = Math.toRadians(angleInDegrees);

        double x = Math.cos(angleInRadians);
        double y = Math.sin(angleInRadians);
//        System.out.println("Original (x, y): (" + x + ", " + y + ")");

        // Swap x and y values
        double swappedX = y;
        double swappedY = x;
//        System.out.println("Swapped (x, y): (" + swappedX + ", " + swappedY + ")");

        // Calculate the new angle (in radians)
        double newAngleInRadians = Math.atan2(swappedY, swappedX);

        double newAngleInDegrees = Math.toDegrees(newAngleInRadians);
//        System.out.println("New angle in degrees: " + newAngleInDegrees);

        return newAngleInDegrees;
    }


    public PathFinder(double x2, double y2, double angle) {
        this.x2 = x2 * 100;
        this.y2 = y2 * 100;
        this.x1 = 4.403 * 100;
        this.y1 = 51.21 * 100;
        this.boatVelocity = 2;
        this.mobVelocity = 1;
        this.angle = angle;
    }

//    public PathFinder(double x1, double y1, double x2, double y2, double boatVelocity, double mobVelocity, double angle) {
//        this.x1 = x1 * 100;
//        this.y1 = y1 * 100;
//        this.x2 = x2 * 100;
//        this.y2 = y2 * 100;
//        this.boatVelocity = boatVelocity;
//        this.mobVelocity = mobVelocity;
//        this.angle = angle;
//    }


    // This is to calculate the initial distance between the two gps modules
    // We will use a library for this, but I could use the Haversine formula to determine if we can view the map as a flat surface
    public double calculateDistance(PathFinder pathFinder) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }


//    public double getBoatAngle(PathFinder pathFinder) {
//        double boatAngle = 0;
//        if(x1>x2) {
//            boatAngle = Math.toDegrees(Math.atan(Math.abs(y2-y1)/Math.abs(x2-x1)));   // Here I am using atan2 because it is more accurate than atan
//        } else if(x1<x2) {
//            boatAngle = Math.toDegrees(Math.atan(Math.abs(y2-y1)/Math.abs(x2-x1))) + 180;
//        } else if(x1==x2) {
//            if(y1>y2) {
//                boatAngle = 270;
//            } else if(y1<y2) {
//                boatAngle = 90;
//            }
//        }
//        return boatAngle;
//    }

    // This will calculate the angle of the heading of the boat and MOB victim in the moment
    public double getBoatAngle(PathFinder pathFinder) {
        double boatAngle;

        if (x1 != x2 || y1 != y2) { // Check if the points are not the same
            // Calculate the angle using atan2, which handles all quadrants
            boatAngle = Math.toDegrees(Math.atan2(y2 - y1, x2 - x1));

            // Ensure the angle is positive
            if (boatAngle < 0) {
                boatAngle += 360;
            }
        } else {
            // Points are the same which means that it's not needed, so we can make it undefined
            boatAngle = Double.NaN; // or set to another appropriate value
        }
        return boatAngle;
    }


    // This will calculate the angle of the heading of the MOB victim and the direct path from the boat to the MOB victim
    public double calculateAngleOfBoatAndMOB(PathFinder pathFinder) {
        double angleOfBoatAndMOB = 180 - Math.abs(getBoatAngle(pathFinder) - convertCompassDegreesAndMathDegrees(angle));
        if (angleOfBoatAndMOB > 180) {
            angleOfBoatAndMOB = 360 - angleOfBoatAndMOB;
        }
        if (angleOfBoatAndMOB == 0) {
            angleOfBoatAndMOB = 180;
        }
        return angleOfBoatAndMOB;
    }

    // Calculate the distance of the boat and the intersect point
    public double calculateIntersectDistance(PathFinder pathFinder) {
        double intersectDistance;
        double angleOfBoatAndMOB = calculateAngleOfBoatAndMOB(pathFinder);

        // If the angle is 0 or 180 then these are the formulas for the distance
        if (angleOfBoatAndMOB == 0) {
            intersectDistance = boatVelocity * (calculateDistance(pathFinder) / (boatVelocity - mobVelocity));
            return calculateDistance(pathFinder);
        } else if (angleOfBoatAndMOB == 180) {
            intersectDistance = boatVelocity * (calculateDistance(pathFinder) / (boatVelocity + mobVelocity));
            return calculateDistance(pathFinder);
        }

        double d = calculateDistance(pathFinder);
        double k = mobVelocity / boatVelocity;
        double a = 1 - (k*k);
        double b = 2 * k * d * Math.cos(Math.toRadians(angleOfBoatAndMOB));  // for Math.cos() I needed to convert double to double
        double c = -d;

        if (a != 0) {
            double sqrt = Math.sqrt((b * b) - (4 * a * c));
            intersectDistance = ((-b + sqrt) / (2 * a));

            if (intersectDistance < 0) {
                intersectDistance = ((-b - sqrt) / (2 * a));
            }
        } else {
            intersectDistance = -c / b;
        }

        return intersectDistance;
    }

    // This will calculate the angle of the MOB, boat and the intersect point
    public double calculateIntersectAngle(PathFinder pathFinder) {
        double angle;
        double angleOfBoatAndMOB = calculateAngleOfBoatAndMOB(pathFinder);

        double d = calculateDistance(pathFinder);
        double k = mobVelocity / boatVelocity;
        double a = 1 - (k*k);
        double b = 2 * k * d * Math.cos(Math.toRadians(angleOfBoatAndMOB));  // for Math.cos() I needed to convert double to double
        double c = -d;

        if (angleOfBoatAndMOB == 0 || angleOfBoatAndMOB == 180) {
            return this.angle;
        }

        double denominator = 2*b*c;

        if (denominator == 0) {
            return 0;
        }

//        System.out.println("d" + d);
//        System.out.println("k" + k);
//        System.out.println("a" + a);
//        System.out.println("b" + b);
//        System.out.println("c" + c);
//        System.out.println("denom" + denominator);
//        System.out.println("angle of boat and MOB" + angleOfBoatAndMOB);
//        System.out.println("The cos of the angle of the boat and MOB: " + Math.cos(Math.toRadians(angleOfBoatAndMOB)));

        double argument = ((c*c) + (b*b) - (a*a))/denominator;
//        System.out.println("argument: " + argument);

        angle = Math.acos(argument) * 100;

        return angle;
    }

    public double calculateTime(PathFinder pathFinder) {
        double time = 0;
        double intersectDistance = calculateIntersectDistance(pathFinder);
        double intersectAngle = calculateIntersectAngle(pathFinder);
        double angleOfBoatAndMOB = calculateAngleOfBoatAndMOB(pathFinder);

        if (angleOfBoatAndMOB == 0 || angleOfBoatAndMOB == 180) {
            time = intersectDistance / boatVelocity;
            return time;
        }

        time = (intersectDistance * Math.sin(intersectAngle)) / (boatVelocity * Math.sin(angleOfBoatAndMOB));

        return time;
    } // TODO prove this on paper


    public double calculateIntersectX(PathFinder pathFinder) {
        double intersectDistance = calculateIntersectDistance(pathFinder);

        return (x1 + intersectDistance * Math.cos(Math.toRadians(angle))) / 100;
    }

    public double calculateIntersectY(PathFinder pathFinder) {
        double intersectDistance = calculateIntersectDistance(pathFinder);

        return (y1 + intersectDistance * Math.sin(Math.toRadians(angle))) / 100;
    }


    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public double getY1() {
        return y1;
    }

    public double getY2() {
        return y2;
    }

    public double getAngle() {
        return angle;
    }

    public double getBoatVelocity() {
        return boatVelocity;
    }

    public double getMobVelocity() {
        return mobVelocity;
    }


}

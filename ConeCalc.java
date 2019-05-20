/*Sathya Gadhiraju
 This class calculates the formulas for surface area, area of base, volume of cone, and volume of ice cream cone.*/
 
 public class ConeCalc{ // class header
 
 int height; // make height a variable
 int radius; // make radius a variable

 public ConeCalc(int h, int r){ // h is height and r is radius
  height = h; // initialize height
  radius = r; // initialize radius
 }

 public double surfaceArea(){ // method to calculate surface area
  double sArea = -5.0; // make sArea variable
  sArea = Math.PI*(Math.pow(radius, 2) + radius* Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2))); // calculate surface area
  return sArea; // return surface area
 }
 
 public double areaOfBase(){ // method to calculate area of the base
  double aOfBase = -6.0; // make aOfBase variable
  aOfBase = Math.PI*(Math.pow(radius, 2)); // calculate area of the base
  return aOfBase; // return area of the base
 }
 
 public double volumeOfCone(){ // method to calculate volume of the cone
  double vOfCone= -45.5; // make vOfCone variable
  vOfCone = 1.0/3.0*(Math.PI*(Math.pow(radius, 2))*height); // calculate volume of the cone
  return vOfCone; // return volume of the cone
 }
 
 public double volumeOfIceCreamCone(){ // method to calculate volume of the ice cream cone 
  double vOfIceCreamCone = -53.434; // make vOfIceCreamCone variable
  vOfIceCreamCone = (1.0/3.0*(Math.PI*(Math.pow(radius, 2))*height) + (2.0/3.0*(Math.PI*(Math.pow(radius, 3))))); // calculate volume of the ice cream cone
  return vOfIceCreamCone; // return volume of the cone
 }
}

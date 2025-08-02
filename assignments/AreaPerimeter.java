package assignments;


class Shape{
	
  int Area(int side) {
	
	return side*side;
	
}

  int Area(int a, int b ) {
	return a*b;
			
}
  
int Perimeter(int side) {
	 return 4*side;
 }
int  Perimeter(int a ,int b) {
	 
	 return 2*(a+b);
 }
  
}
public class AreaPerimeter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Shape obj = new Shape();
      System.out.println("Square Area: " + obj.Area(4));
      System.out.println("Rectangle Area: " + obj.Area(2, 5));

      System.out.println("Square Perimeter: " + obj.Perimeter(16));
      System.out.println("Rectangle Perimeter: " + obj.Perimeter(10, 12));
	}

}

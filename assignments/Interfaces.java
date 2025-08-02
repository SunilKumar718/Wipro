package assignments;


interface Drawable{
	
	 void drawingColor();
	 void thickness();
}

interface Fillable{
	void fillingColor();
    void size();
	
}


class Line implements Drawable{
	public void drawingColor() {
		System.out.println("Line Drawing color is Black");
	}
	public void thickness(){
		System.out.println("Line Thickness is 2px");
	}
}

class Circle implements Drawable,Fillable{
	public void drawingColor() {
		System.out.println("Circle Drawing color is Blue");
	}
	public void thickness(){
		System.out.println("Circle Thickness is 10px");
	}
	
	 public void fillingColor() {
	        System.out.println("Circle Filling Color is Red");
	    }

	 public void size() {
	        System.out.println("Circle Size:Radius = 5 units");
	
	 }	
}
class Square implements Drawable,Fillable{
	public void drawingColor() {
		System.out.println("Square Drawing color is Yellow");
	}
	public void thickness(){
		System.out.println("Square Thickness is 15");
	}
	
	 public void fillingColor() {
	        System.out.println("Square Filling Color is Green");
	    }

	 public void size() {
	        System.out.println("Square Size:Radius = 10 units");
	
	 }	
}
public class Interfaces {
	
	 public static void main(String[] args) {
		 
		 Line l= new Line();	
		 l.drawingColor();
	     l.thickness();
	     
	     Circle c= new Circle();
	     c.drawingColor();
	     c.fillingColor();
	     c.size();
	     c.thickness();
	     
	     
	     Square s= new Square();
	     s.drawingColor();
	     s.fillingColor();
	     s.size();
	     s.thickness();
	 }
	 }

//Line Drawing color is Black
//Line Thickness is 2px
//Circle Drawing color is Blue
//Circle Filling Color is Red
//Circle Size:Radius = 5 units
//Circle Thickness is 10px
//Square Drawing color is Yellow
//Square Filling Color is Green
//Square Size:Radius = 10 units
//Square Thickness is 15

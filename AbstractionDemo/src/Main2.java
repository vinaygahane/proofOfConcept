import java.util.Scanner;
abstract class Shapes{
    float area;
    abstract public void input();
    abstract public void compute();
    public void disp(){
        System.out.println("Area is "+area);
    }
}

class Geometry{
    void permit(Shapes s){
        s.input();
        s.compute();
        s.disp();
    }
}


class Rectangle extends Shapes{
    float length;
    float breath;
    public void  input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Length of rectangle");
        length = sc.nextFloat();
        System.out.println("Enter Breath of rectangle");
        breath = sc.nextFloat();
    }
    public void compute(){
        area = length*breath;
    }


}

class Square extends  Shapes{
    float length;
    public void  input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Length of square");
        length = sc.nextFloat();
    }
    public void compute(){
        area = length*length;
    }
}

class Circle extends  Shapes{
    float radius;
    final float PI = 3.14f;
    public void  input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius of circle");
        radius = sc.nextFloat();
    }
    public void compute(){
        area = PI*radius*radius;
    }
}

public class Main2 {
public static void main(String[] a)
{
    Rectangle r = new Rectangle();
    Square s = new Square();
    Circle c = new Circle();

    Geometry g = new Geometry();
    g.permit(r);
    g.permit(s);
    g.permit(c);
}
}

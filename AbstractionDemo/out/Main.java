import java.util.Scanner;

class Rectangle{
    float length;
    float breath;
    float area;

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

    public void disp(){
        System.out.println("Area is "+area);
    }
}

class Square{
    float length;
    float area;

    public void  input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Length of square");
        length = sc.nextFloat();
    }
    public void compute(){
        area = length*length;
    }

    public void disp(){
        System.out.println("Area is "+area);
    }
}

class Circle{
    float radius;
    final float PI = 3.14f;
    float area;

    public void  input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius of circle");
        radius = sc.nextFloat();


    }
    public void compute(){
        area = PI*radius*radius;
    }

    public void disp(){
        System.out.println("Area is "+area);
    }
}

public class Main {
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        Square s = new Square();
        Circle c = new Circle();

        r.input();
        r.compute();
        r.disp();

        s.input();
        s.compute();
        s.disp();

        c.input();
        c.compute();
        c.disp();

    }
}
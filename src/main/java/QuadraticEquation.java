import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.Objects;

@EqualsAndHashCode
public class QuadraticEquation {
    private int a, b, c;
    private double x1, x2, d;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuadraticEquation that = (QuadraticEquation) o;
        return a == that.a && b == that.b && c == that.c && Double.compare(that.x1, x1) == 0 && Double.compare(that.x2, x2) == 0 && Double.compare(that.d, d) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, x1, x2, d);
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    @Override
    public String toString() {
        return "QuadraticEquation{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", x1=" + x1 +
                ", x2=" + x2 +
                ", d=" + d +
                '}';
    }

    public QuadraticEquation(String str) {
        str = str.replaceAll("\\^2","");
        str = str.replaceAll("\\+", "");
        String[] strings = str.split("x");
        System.out.println(Arrays.toString(strings));

        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("-")){
                switch (i){
                    case 0:
                        this.a = -1;
                        break;
                    case 1:
                        this.b = -1;
                        break;
                    case 2:
                        this.c = -1;
                        break;
                }
            }
            else if (!strings[i].equals("")){
                switch (i){
                    case 0:
                        this.a = Integer.parseInt(strings[i]);
                        break;
                    case 1:
                        this.b = Integer.parseInt(strings[i]);
                        break;
                    case 2:
                        this.c = Integer.parseInt(strings[i]);
                        break;
                }
            }else {
                switch (i){
                    case 0:
                        this.a = 1;
                        break;
                    case 1:
                        this.b = 1;
                        break;
                    case 2:
                        this.c = 1;
                        break;
                }
            }
        }
        countDisc();
        if (d>=0){
            countRoots();
        }else {
            this.x1 = Double.parseDouble(null);
            this.x2 = Double.parseDouble(null);
        }
    }
    public void countRoots(){
        this.x1 = (-b - Math.sqrt(d))/2*a;
        this.x2 = (-b + Math.sqrt(d))/2*a;
    }
    public void countDisc(){
        this.d = Math.pow(b, 2) - 4*a*c;
    }
}

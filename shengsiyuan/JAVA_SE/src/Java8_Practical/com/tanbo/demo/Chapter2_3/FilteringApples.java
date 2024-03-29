package Java8_Practical.com.tanbo.demo.Chapter2_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: JavaSePractice
 * @description:
 * @author: TanBo
 * @create: 2019-09-12 13:34
 **/

import java.util.Comparator;
public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple("green",80.0),
                new Apple("green",155.0),
                new Apple("red",120.0));

        List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
            public boolean test(Apple apple){
                return "red".equals(apple.getColor());
            }
        });

        inventory.sort(new Comparator<Apple>() {
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        inventory.sort(
                (Apple a1,Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));

        for (Apple apple:inventory){
            System.out.println(apple);
        }
    }
    private static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        //在调用filterApples的时候，需要传入的实际上是一个实现了ApplePredicate接口的类的对象
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory){
            if (p.test(apple)) { result.add(apple);}
        }
        return result;
    }
}

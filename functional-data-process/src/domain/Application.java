package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static domain.Dish.*;

public class Application {
    public static void main(String[] args) {
        //외부 반복으로 메뉴의 이름 추출
        List<String> names = new ArrayList<>();
        for (Dish dish : menu) {
            names.add(dish.getName());
        }

        //내부 반복으로 메뉴의 이름 추출
        List<String> innerIteration = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());


        //스트림 연산 작동 순서 확인하
        List<String> dishNames = menu.stream()
                .filter(dish -> {
                    System.out.println("filtering " + dish.getName());
                    return dish.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("mapping " + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(dishNames);
    }
}

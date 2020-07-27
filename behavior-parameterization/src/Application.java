import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
                new Apple(130, Color.RED),
                new Apple(120, Color.RED),
                new Apple(150, Color.GREEN),
                new Apple(170, Color.RED),
                new Apple(190, Color.GREEN)
        );
        
        List<Apple> redApples = filterApples(apples, (Apple apple) -> apple.color.equals(Color.RED));
        for (Apple redApple : redApples) {
            System.out.println(redApple.toString());
        }
    }

    private List<Apple> filterApplesByColor(List<Apple> apples, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    private List<Apple> filterApplesByWeight(List<Apple> apples, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    public class AppleRedPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.color.equals(Color.RED);
        }
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if(p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}

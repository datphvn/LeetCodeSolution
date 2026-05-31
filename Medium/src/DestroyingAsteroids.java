import java.util.Arrays;

public class DestroyingAsteroids {

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long currentMass = mass;

        for (int asteroid : asteroids) {
            if (currentMass < asteroid) {
                return false;
            }

            currentMass += asteroid;
        }

        return true;
    }

    public static void main(String[] args) {
        DestroyingAsteroids solver = new DestroyingAsteroids();

        // Test 1
        int mass1 = 10;
        int[] asteroids1 = {3, 9, 19, 5, 21};
        System.out.println(
                solver.asteroidsDestroyed(mass1, asteroids1)
        ); // true

        // Test 2
        int mass2 = 5;
        int[] asteroids2 = {4, 9, 23, 4};
        System.out.println(
                solver.asteroidsDestroyed(mass2, asteroids2)
        ); // false

        // Test 3
        int mass3 = 100;
        int[] asteroids3 = {1, 2, 3, 4, 5};
        System.out.println(
                solver.asteroidsDestroyed(mass3, asteroids3)
        ); // true

        // Test 4
        int mass4 = 1;
        int[] asteroids4 = {1};
        System.out.println(
                solver.asteroidsDestroyed(mass4, asteroids4)
        ); // true

        // Test 5
        int mass5 = 2;
        int[] asteroids5 = {3};
        System.out.println(
                solver.asteroidsDestroyed(mass5, asteroids5)
        ); // false
    }
}
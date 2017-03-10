package net.estebanrodriguez.apps.pizzascale;

/**
 * Created by spoooon on 3/10/17.
 */

public class PizzaConverter {

    public static double KgsToLbs(double weight){
        return weight * 2.20462;
    }

    public static double ConvertToPizzaSlice(double weight){
        double slices = weight * 4;
        return roundToTheNearestHalfSlice(slices);
    }

    public static double ConvertToWholePizzas(double weight) {
        double pizzas = ConvertToPizzaSlice(weight) / 8;

        if (pizzas < 1) {
            return 0;
        } else
            return roundDownToTheNearestwhole(pizzas);
    }


    private static double roundToTheNearestHalfSlice(double slices){
        return Math.round(slices * 2)/2.0;
    }

    private static double roundDownToTheNearestwhole(double pizzas){
        return Math.floor(pizzas);
    }

    public static int getTheRemainingSlices(double weight){

        double slices = weight *4;
        return (int) slices%8;
    }
}

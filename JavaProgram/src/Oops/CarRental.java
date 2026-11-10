package Oops;

public class CarRental {
    void calculateRent(int hrs) {
        int amount = hrs * 500;
        System.out.println("Rent for hours: " + amount);
    }

    void calculateRent(boolean isDaily, int days) {
        if (isDaily) {
            int amount = days * 3000;
            System.out.println("Rent for days: " + amount);
        } else {
            System.out.println("Daily rental not selected");
        }
    }

    void calculateRent(int days, int amount, boolean isDriver) {
        int total = days * amount;

        if (isDriver) {
            total = total + (days * 1000);
        }

        System.out.println("Rent with driver: " + total);
    }

    public static void main(String[] args) {

        CarRental c = new CarRental();

        c.calculateRent(5);

        c.calculateRent(true, 2);

        c.calculateRent(3, 3000, true);
    }
}

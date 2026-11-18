interface ReceiptPrintable {
    void printReceipt();
}

class Rental {
    private String clientName;
    private int hours;
    private double hourlyRate;

    public Rental(String clientName, int hours, double hourlyRate) {
        this.clientName = clientName;
        this.hours = hours;
        this.hourlyRate = hourlyRate;
    }

    public String getClientName() {
        return clientName;
    }

    public int getHours() {
        return hours;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double calculateCost() {
        return hours * hourlyRate;
    }

    public boolean changeHours(int newHours) {
        if (newHours > 0) {
            hours = newHours;
            return true;
        }
        return false;
    }
}

class CameraRental extends Rental implements ReceiptPrintable {

    public CameraRental(String name, int hours, double rate) {
        super(name, hours, rate);
    }

    @Override
    public double calculateCost() {
        return super.calculateCost() + 300;
    }

    @Override
    public void printReceipt() {
        System.out.println("Камера | " + getClientName() + " | "
                + getHours() + " ч. | " + calculateCost() + " руб.");
    }
}

class LaptopRental extends Rental implements ReceiptPrintable {

    public LaptopRental(String name, int hours, double rate) {
        super(name, hours, rate);
    }

    @Override
    public double calculateCost() {
        double price = super.calculateCost();

        if (getHours() >= 5) {
            price = price * 0.9;
        }

        return price;
    }

    @Override
    public void printReceipt() {
        System.out.println("Ноутбук | " + getClientName() + " | "
                + getHours() + " ч. | " + calculateCost() + " руб.");
    }
}

public class Main {

    public static double getTotal(Rental[] rentals) {
        double sum = 0;

        for (int i = 0; i < rentals.length; i++) {
            sum += rentals[i].calculateCost();
        }

        return sum;
    }

    public static void main(String[] args) {

        CameraRental camera = new CameraRental("Алина", 2, 500);
        LaptopRental laptop1 = new LaptopRental("Максим", 6, 400);
        LaptopRental laptop2 = new LaptopRental("Ирина", 3, 400);

        Rental[] rentals = {camera, laptop1, laptop2};

        ReceiptPrintable[] receipts = {camera, laptop1, laptop2};

        System.out.println("Квитанции:");

        for (int i = 0; i < receipts.length; i++) {
            receipts[i].printReceipt();
        }

        System.out.println("Общая стоимость: " + getTotal(rentals));

        System.out.println("\\nПроверка изменения часов:");

        System.out.println("Изменение на -2: " + camera.changeHours(-2));
        System.out.println("Стоимость: " + camera.calculateCost());

        System.out.println("Изменение на 3: " + camera.changeHours(3));
        System.out.println("Стоимость: " + camera.calculateCost());

        System.out.println("Новая общая стоимость: " + getTotal(rentals));
    }
}

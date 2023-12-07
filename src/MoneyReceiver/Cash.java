package MoneyReceiver;

import exceptions.CustomException;

import java.util.Scanner;

public class Cash implements PaymentMethod {

    private double cashBalance = 200.36;
    static Scanner sc = new Scanner(System.in);

    @Override
    public int moneyInput() {
        System.out.printf("В кармане : %.2f$ \n", cashBalance);
        System.out.print("Сумма на пополнение: ");
        try {
            int sum = sc.nextInt();
            if (sum >= 1 && sum <= cashBalance) {
                return sum;
            } else {
                throw new CustomException("Введите сумму в пределах от 1 до " + cashBalance + " $");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Введите число");
            return moneyInput();
        } catch (CustomException CE) {
            System.out.println(CE.getMessage());
            return moneyInput();
        }
    }
}

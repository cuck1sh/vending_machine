package MoneyReceiver;

import java.util.Scanner;

public class BankCard implements PaymentMethod{

    private double cardBalance = 164.20;
    static Scanner sc = new Scanner(System.in);


    @Override
    public void moneyInput() {
        System.out.printf("Текущий баланс на карте: %.2f \n", cardBalance );
        while (true) {
            System.out.print("Сумма на пополнение: ");
            try {
                double sum = sc.nextInt();
                if (sum >= 1 && sum <= cardBalance) {

                } else {
                    throw
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Введите число");
                moneyInput();
            }



        }
    }



}

package MoneyReceiver;

import exceptions.CustomException;

import java.util.Scanner;

public class BankCard implements PaymentMethod {

    private double cardBalance = 164.20;
    static Scanner sc = new Scanner(System.in);

    @Override
    public int moneyInput() {
        System.out.printf("Текущий баланс на карте: %.2f$ \n", cardBalance);
        System.out.print("Сумма на пополнение: ");
        try {
            int sum = sc.nextInt();
            if (sum >= 1 && sum <= cardBalance) {
                System.out.print("Введите номер карты: ");
                String num = sc.nextLine();
                for (int i = 0; i < num.length(); i++) {
                    if (!Character.isDigit(num.charAt(i))) {
                        throw new CustomException("Введите только числа");
                    }
                }
                if (num.length() == 16) {
                    System.out.print("Введите одноразовый пароль: ");
                    String str = sc.nextLine();
                    return sum;
                } else {
                    throw new CustomException("Чисел должно быть 16");
                }
            } else {
                throw new CustomException("Введите сумму в пределах от 1 до " + cardBalance + " $");
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

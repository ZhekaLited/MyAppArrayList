import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        ArrayList<Account> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;

        int numStep = 0;
        while (isRunning) {
            System.out.println("Please enter your name in the account(quit to exit program): ");
            String name = sc.nextLine();
            if (name.equalsIgnoreCase("q")) {
                break;
            }

            System.out.println("Please enter an Game for your account: ");
            String game = sc.nextLine();
            if (numStep > 0 ) { // Функция поиска имени(Name) в листе
                if(ExistsName(list, name)) {
                    System.out.println("Name is occupied");
                }else{
                    //list.remove(list.size() - 1); // Если сработает то удаляет последнию введенный аккаунт
                    Account a = new Account(name, game);
                    list.add(a);
                }
            }

        numStep++; // Счетчик шагов сколько цикл крутанул , что бы начать првоерять совпадения со второго шага
        }

        for (Account t : list) {
            System.out.println("Name: " + t.getName() + "\nGame: " + t.getGame());
            System.out.println();
        }
    }

    private static boolean ExistsName(ArrayList<Account> list, String name) { // Обьявление типов параметров
        for (int i = 0; i < list.size(); i++) { // Пробег по коллекции и сравнимаем каждый имя в аккаунте с переданным в функцию именем
            Account acc = list.get(i); // Сдесь мы по очереди вытягиваем аккаунт
            if (acc.getName().equals(name)) { // Достаем из аккаунта имея и сравнимаем с именем переданным в функцию
                return true;
            }
        }
        return false;
    }
}



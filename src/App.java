import java.util.*;

/*В данном приложение используется ArrayList , Comparator , Scanner , Stack , Collection.sort , Random .

[Функционал данной программы] - Запись Nick игроков и игры в которые они играют с помощью консоли (Scanner).

Ники не могут повторятся!!! Игры - могут повторятся но только для записи !!!!

Ники можно вводить как с большой буквы так и с маленькой , на английском так и на русском , с помощью цифр и букв.

Ники будут считаться за повторные если при повторном вводе будет изменена только первая буква либо символ .

С помощью рандома игрокам присваивается очки по которым выбирается победитель и выводит его в консоль .

Выводится игры в которые сейчас играют ( Без повторных ) .

По окончанию работы приложения , можно просто закончить введя символ q .



Выполнил задание: Нечаев Евгений.

*/

public class App {
    public static void main(String[] args) {
        ArrayList<Account> list = new ArrayList<>();
        Comparator<Account> comparator = new Comparator<Account>() {
            @Override
            public int compare(Account left, Account right) {
                return left.getResultGame() - right.getResultGame();
            }
        };
        Comparator<Account> comparGame = new Comparator<Account>() {
            @Override
            public int compare(Account left, Account right) {

                if (left.getGame() == right.getGame()) {
                    return 0;
                }
                if (left.getGame() == null) {
                    return -1;
                }
                if (right.getGame() == null) {
                    return 1;
                }
                return left.getGame().compareTo(right.getGame());
            }
        };

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter your name in the account(quit to exit program): ");
            String name = sc.nextLine();
            if (name.equalsIgnoreCase("q")) {
                break;
            }

            System.out.println("Please enter an Game for your account: ");
            String game = sc.nextLine();
            Account a = new Account(name, game);
            if (list.size() > 0) { // Функция поиска имени(Name) в листе
                if (ExistsName(list, name)) {
                    System.out.println("Name is occupied");
                } else {
                    //list.remove(list.size() - 1); // Если сработает то удаляет последнию введенный аккаунт
                    list.add(a);
                }
            }else{
                list.add(a);
            }
        }

        for (Account t:list ) {
            int rnd = (int) getRandomIntegerBetweenRange(0,list.size()-1);
            t.setResultGame(rnd);
        }
        for (Account t : list) {
            System.out.println("Name: " + t.getName() + "\nGame: " + t.getGame() + " " + "\nResult Game: " + t.getResultGame());
            System.out.println();
        }

        Collections.sort(list, comparator);
        Stack<Account> stack = new Stack<>();
        for (Account t:list ) {
            stack.add(t);
        }

        System.out.println("[Winner User: " + stack.pop().getName() + "]\n");



        ArrayList<Account> distinctGame = new ArrayList<Account>();
        Collections.sort(list, comparGame);
        for (Account t : list) {
            if (!ExistsGame(distinctGame, t.getGame())) {
                distinctGame.add(t);
            }
        }
            System.out.println("[GAME ONLINE]");
        for(Account t : distinctGame) {
            System.out.println("Game: " + t.getGame());
        }
    }


    private static boolean ExistsName(ArrayList<Account> list, String name) { // Обьявление типов параметров
        for (int i = 0; i < list.size(); i++) { // Пробег по коллекции и сравнимаем каждый имя в аккаунте с переданным в функцию именем
            Account acc = list.get(i); // Сдесь мы по очереди вытягиваем аккаунт
            if (acc.getName().equalsIgnoreCase(name)) { // Достаем из аккаунта имея и сравнимаем с именем переданным в функцию
                return true;
            }
        }
        return false;
    }
    public static double getRandomIntegerBetweenRange(double min, double max){
        double x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }
    private static boolean ExistsGame(ArrayList<Account> list2, String game) {
        for (int i = 0; i < list2.size(); i++) {
            Account acc2 = list2.get(i);
            if (acc2.getGame().equalsIgnoreCase(game)) {
                return true;
            }
        }
        return false;
    }

}



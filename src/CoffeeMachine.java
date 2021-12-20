import java.util.*;
public class CoffeeMachine {
    //The below variables store the amount of ingredients currently in the machine
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int cash;

    //The below variables represent the maximum limits of the machine
    private int maxWater;
    private int maxMilk;
    private int maxBeans;
    private int maxCups;
    private int maxCash;




    static Scanner scan=new Scanner(System.in);

    public CoffeeMachine(int water, int milk, int beans, int cups, int cash) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.cash = cash;

        this.maxWater = water;
        this.maxMilk = milk;
        this.maxBeans = beans;
        this.maxCups = cups;
        this.maxCash = cash;

    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getBeans() {
        return beans;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public boolean canMakeCoffee(int waterNeed, int milkNeed, int beansNeed) {
        if (water >= waterNeed) {
            if (milk >= milkNeed) {
                if (beans >= beansNeed) {
                    System.out.println("Making you a coffee!\n");
                    return true;
                } else {
                    System.out.println("Sorry, not enough beans!");
                    return false;
                }

            } else {
                System.out.println("Sorry, not enough milk!");
                return false;
            }
        } else {
            System.out.println("Sorry, not enough water!");
            return false;
        }
    }

    public void makeCoffee(int waterNeed, int milkNeed, int beansNeed, int amount){
        water -= waterNeed;
        beans -= beansNeed;
        milk -= milkNeed;
        cups--;
        cash *= amount;
    }

    public void buy(String choice){
        switch (choice) {
            case "1": {
                if (canMakeCoffee(250, 0, 16)) {
                    makeCoffee(250, 0,16,4);
                    break;
                }
            }
            case "2": {
                if (canMakeCoffee(350, 75, 20)) {
                    makeCoffee(350, 75,20,7);
                    break;
                }
            }
            case "3": {
                if (canMakeCoffee(200, 100, 12)) {
                    makeCoffee(200, 100,12,6);
                    break;
                }

            }
            case "back": {
                break;
            }
            default: {
                break;
            }

        }

    }
    public void fill(int waterAdd, int milkAdd, int beansAdd, int cupsAdd) {
        if(water+waterAdd <= maxWater){
            water += waterAdd;
        }else {
            System.out.println("Water overflow");
        }

        if(milk+milkAdd <= maxMilk){
            milk += milkAdd;
        }else{
            System.out.println("Milk overflow");
        }

        if(beans+beansAdd <= maxBeans){
            beans += beansAdd;
        }else {
            System.out.println("Oops! Enough beans already");
        }

        if(cups+cupsAdd <= maxCups){
            cups += cupsAdd;
        }else{
            System.out.println("Too many cups!");
        }


    }

    public void collect() {
        System.out.println("Dispensing all cash from machine $" + cash +"\n");
        cash = 0;
    }

    public void remaining() {

        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(cash + " of cash");
        System.out.println();

    }


}

class Runner{
    static Scanner scan=new Scanner(System.in);
    public static void main(String[] args) {

        boolean exit = false;
        do {

            System.out.print("Good Morning Sunshine ! What do you wish to do ?  (Buy Coffee, Fill Up Ingredients, Collect Money, Monitor Status, Exit): ");
            String action = scan.next();
            CoffeeMachine machine1 = new CoffeeMachine(400, 540, 120, 9, 550);
            switch (action) {
                case "buy":
                    System.out.println();
                    System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                    String choice = scan.next();
                    machine1.buy(choice);
                    break;
                case "fill":
                    System.out.println("Write how many ml of water do you want to add: ");
                    int waterAdd = scan.nextInt();

                    System.out.println("Write how many ml of milk do you want to add: ");
                    int milkAdd = scan.nextInt();

                    System.out.println("Write how many grams of coffee beans do you want to add: ");
                    int beansAdd = scan.nextInt();

                    System.out.println("Write how many disposable cups of coffee do you want to add: ");
                    int cupsAdd = scan.nextInt();

                    machine1.fill(waterAdd, milkAdd, beansAdd, cupsAdd);
                    break;
                case "take":
                    machine1.collect();
                    break;
                case "remaining":
                    machine1.remaining();
                    break;
                case "exit":
                    exit=true;
                    break;
            }
        } while (!exit);


    }
}
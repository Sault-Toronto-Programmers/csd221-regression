import org.junit.jupiter.api.Assertions;
import  org.junit.jupiter.api.Test;
class CoffeeMachineTest {

    @Test
    void testCanMakeCoffee1() {
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);
        Assertions.assertFalse(machine.canMakeCoffee(500, 400, 100));
    }

    @Test
    void testCanMakeCoffee2() {
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);
        Assertions.assertFalse(machine.canMakeCoffee(400, 550, 100));
    }

    @Test
    void testCanMakeCoffee3() {
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);
        Assertions.assertFalse(machine.canMakeCoffee(400, 500, 125));
    }

    @Test
    void testCanMakeCoffee4(){
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);
        Assertions.assertTrue(machine.canMakeCoffee(400, 500, 100));
    }

    @Test
    void testMakeCoffee(){
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);
        machine.makeCoffee(5, 10, 15, 5);
        Assertions.assertEquals(395, machine.getWater());
        Assertions.assertEquals(530, machine.getMilk());
        Assertions.assertEquals(105, machine.getBeans());
        Assertions.assertEquals(555, machine.getCash());
    }

    @Test
    void testCollect(){
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);
        machine.collect();
        Assertions.assertEquals(0, machine.getCash());
    }

    @Test
    void testFill1(){
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);
        machine.fill(100, 100, 100, 100);
        Assertions.assertEquals(120, machine.getBeans());
        Assertions.assertEquals(540, machine.getMilk());
        Assertions.assertEquals(400, machine.getWater());
        Assertions.assertEquals(9, machine.getCups());
    }

    @Test
    void testFill2(){
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);
        machine.setBeans(50);
        machine.setMilk(50);
        machine.setCups(1);
        machine.setWater(50);
        machine.fill(100, 100, 30, 5);
        Assertions.assertEquals(80, machine.getBeans());
        Assertions.assertEquals(150, machine.getMilk());
        Assertions.assertEquals(150, machine.getWater());
        Assertions.assertEquals(6, machine.getCups());
    }
}
package sample;

import org.junit.Test;

public class testHuman {
    @Test
    public void testAddFio(){
        Human human = new Human();
        human.age=100500;
        System.out.println(human.age);
    }
}

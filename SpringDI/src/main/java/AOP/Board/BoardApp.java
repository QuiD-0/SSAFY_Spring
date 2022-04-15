package AOP.Board;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BoardApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("board.xml");
        Board board = applicationContext.getBean("board",Board.class);

        board.read(1);
        board.write("test");
        board.delete(1);
    }
}

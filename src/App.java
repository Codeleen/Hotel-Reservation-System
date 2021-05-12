import controller.Controller;
import controller.Message;
import model.HotelSystem;
import view.LoginScreen;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Starts the whole application, making the necessary beginning steps
 */
public class App {
    public static void main(String[] args) {
        int SCREEN_SIZE = 750;
        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();

        HotelSystem model = new HotelSystem();
        LoginScreen view = new LoginScreen(queue, SCREEN_SIZE);
        Controller controller = new Controller(queue, model, view);
        controller.mainLoop();
    }
}

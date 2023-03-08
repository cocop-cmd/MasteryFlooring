package App;

import FlooringMast.controller.FlooringController;
import Flooringmastery.ui.FlooringView;
import Flooringmastery.ui.UserIO;
import Flooringmastery.ui.UserIOConsoleImpl;
import dao.FlooringDao;
import dao.FlooringDaoFileImpl;

public class Main {
    public static void main(String[] args) throws Exception {
        UserIO myIo = new UserIOConsoleImpl();
        FlooringView myView = new FlooringView(myIo);
        FlooringDao myDao = new FlooringDaoFileImpl();
        FlooringController controller = new FlooringController(myDao, myView);

        controller.run();


    }


    }

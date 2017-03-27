package mars;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by roberto on 26/03/17.
 */
@RestController
public class RobotMarsController {

    @ExceptionHandler
    void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

    @RequestMapping("/rest/mars/{movements}")
    public Robot mars(@PathVariable("movements") String movements) {
        Robot robot = new Robot();

        // It could be implemented by a service layer
        for(char movement: movements.toCharArray()) {
            switch (movement) {
                case 'M':
                    robot.move();
                    break;
                case 'L':
                    robot.turnLeft();
                    break;
                case 'R':
                    robot.turnRigh();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid Movement!");
            }

        }

        return robot;
    }

}

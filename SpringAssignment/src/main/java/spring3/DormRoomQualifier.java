package spring3;

import org.springframework.stereotype.Component;

@Component("Dorm2")
public class DormRoomQualifier extends DormRoom {
    private int number = 07;
    private String building = "B";

    @Override
    public String getLocation() {
        return "Room " + number + ", " + building + " Building";
    }
}

package spring3;

import org.springframework.stereotype.Component;

@Component("Dorm1")
public class DormRoom{
    private int number =18;
    private String building ="A";

    public String getLocation(){
        return "Room " +number + ", "+ building + " Building";
    }
}

package spring3;

import org.springframework.stereotype.Component;

@Component
public class Freshman{
    private String name ="Mahesh";
    private DormRoom room;

    public String getName(){
        return name;
    }

    public DormRoom getRoom(){
        return room;
    }

    public void setRoom(DormRoom room){
        this.room = room;
    }
}

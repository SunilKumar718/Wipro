package springboot_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ClassKLM{

    @Autowired
    @Qualifier("classABC") 
    InterfacePQR pqr;

    public void show(){
        pqr.display();
    }
}

package uberRide;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class UberController {

	   @Autowired
	    private UberRepo repository;
    @GetMapping("/rides")
    public List<UberEntity> getAllRides() {
        return repository.findAll();
    }
}

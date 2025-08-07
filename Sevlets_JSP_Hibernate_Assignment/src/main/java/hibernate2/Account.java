package hibernate2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String holderName;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<AccTransaction> transactions = new ArrayList<>();


    public Account() {}

    public Account(String holderName){
        this.holderName =holderName;
    }

    public int getId(){ 
    	return id; 
	}
    public String getHolderName(){ 
    	return holderName; 
	}
    public void setHolderName(String holderName){ 
    	this.holderName =holderName; 
	}

    public List<AccTransaction> getTransactions(){ 
    	return transactions; 
	}
    public void addTransaction(AccTransaction t){
        t.setAccount(this);
        transactions.add(t);
    }
}

package hibernate2;

import javax.persistence.*;

@Entity
public class AccTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    
    public AccTransaction() {}
    public AccTransaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public int getId() { 
    	return id; 
	}
    public String getType() { 
    	return type; 
	}
    public double getAmount() { 
    	return amount; 
	}

    public void setType(String type) { 
    	this.type = type; 
	}
    public void setAmount(double amount) { 
    	this.amount = amount;
	}

    public Account getAccount() { 
    	return account; 
	}
    public void setAccount(Account account) { 
    	this.account = account; 
	}
}

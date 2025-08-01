package spring6;

public class Person {
    private int id;
    private int age;
    private String firstName;
    private String lastName;

    public int getId() { 
    	return id; 
	}
    public void setId(int id) { 
    	this.id = id; 
	}

    public int getAge() { 
    	return age; 
    }
    public void setAge(int age) { 
    	this.age = age; 
    }

    public String getFirstName() {
    	return firstName;
    }
    public void setFirstName(String firstName) { 
    	this.firstName = firstName; 
	}

    public String getLastName() { 
    	return lastName; 
    }
    public void setLastName(String lastName) { 
    	this.lastName = lastName; 
	}

    @Override
    public String toString() {
        return String.format("Person{id=%d, age=%d, firstName='%s', lastName='%s'}",
                id, age, firstName, lastName);
    }
}

import { Component } from "react";

//Functional Component for displaying the list of fruits
function FruitList(props) {
  return (
    <div style={{ padding: "20px",  }}>
      <h3>Fruit List</h3>
      <ul style={{ listStyleType: "none", padding: 0 }}>
        {/*Loops through the fruits array and shows each fruit */}
        {props.fruits.map((fruit, index) => (
          <li key={index}>{fruit}</li>
        ))}
      </ul>
    </div>
  );
}

// Class Component which manages the state of fruits
class Fruits extends Component {
  constructor(props) {
    super(props);

    //It preserves the previous state which allows to update the state(class component)
    this.state = {
      fruits: ["Apple", "Banana", "Mango"], //initial fruits
      newFruit: "" // empty string so that whatever the input is given will be stored here
    };  //like this.state.newfruit=" "
  }

  // Update newFruit whenever the input box changes
  handleChangeController = (e) => {
    this.setState({ newFruit: e.target.value }); //Current Control value and it updates the newfruit with the given input value
  };

  //Add the new fruit to the list
  addFruit= () => {
      if (this.state.newFruit.trim() !== "") { //checks if not empty after trimming spaces
      this.setState({
        fruits: [...this.state.fruits, this.state.newFruit], // adding new fruit at the end (joining) and update the list
        newFruit: "" //clear the input box
      });
      }
  };

  render() {
    return (
      <div style={{ padding: "20px",  }}>
        <h2>Fruits</h2>

        <input
          type="text"
          value={this.state.newFruit} // whatever the input is given will be taken as a value
          onChange={this.handleChangeController} //triggers whenever handleChangeController is called
          placeholder="Enter fruit name"
        />


        <button onClick={this.addFruit} style={{ marginLeft: "10px" }}> {/*On clicking button, A new fruit will be added */}
          Add Fruit
        </button> 

        {/* Passing fruits to the functional component */}
        <FruitList fruits={this.state.fruits} />
        <hr />
      </div>
    );
  }
}

// Exporting Fruits component
export default Fruits;

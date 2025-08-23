import { Component } from "react";

// Functional Component to display list of television models
function TelevisionList(props) {
  return (
    <div>
      <h3>Television Models</h3>
      <ul style={{ listStyleType: "none", padding: 0 }}>
        {props.models.map((model, index) => ( //loops through models array
          <li key={index}>{model}</li> // index used as key since no unique id
        ))}
      </ul>
    </div>
  );
}

// Class Component to Manage television models
class TelevisionManager extends Component {  //parent component
  constructor(props) {
    super(props);

    // preserve previous state to update the state
    this.state = {
      models: ["Samsung QLED", "Sony Bravia", "LG OLED"], //initial TV models
      newModel: "" //user input so it is stored here
    };
  }

  // Update input text when user types
  handleChangeController = (e) => {
    this.setState({ newModel: e.target.value }); //update newModel with Userinput value
  };

  // Add new television model to list using spread operator
  addModel= () => {
    if (this.state.newModel.trim() !== "") { //checks if not equal to empty after trimming spaces
      this.setState({
        models: [...this.state.models, this.state.newModel], // spread operator (...) joining with new model typed by user
        newModel: "" //clear input box so that user can type new model to store
      });
    }
  };

  render() {
    return (
      <div style={{ padding: "20px" }}>
        <h2>Television Manager</h2>

        <input
          type="text"
          value={this.state.newModel} // whatever the Userinput is given will be taken as a value
          onChange={this.handleChangeController} // triggers whenever handleChangeController is called
          placeholder="Enter the TV model"
        />

        <button onClick={this.addModel}  // On clicking button, A new model will be added
        style={{ marginLeft: "10px" }}>
          Add Model
        </button>

        {/* Passing state data to functional component  to display*/}
        <TelevisionList models={this.state.models} />
        <hr />
      </div>
    );
  }
}

export default TelevisionManager;

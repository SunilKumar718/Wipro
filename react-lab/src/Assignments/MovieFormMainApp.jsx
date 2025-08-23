import  { Component } from "react";
import MovieForm from "./MovieForm";

class MovieForm_MainApp extends Component { //Class Component
  state = { showForm: true };  //initially true to show the form

  toggleForm = () => {  // flips between true and false when the button is clicked
    this.setState((prev) => ({ showForm: !prev.showForm })); //key:value (value is inverted)
  };

  render() {
    return (
      <div className="container mt-4">
        <button className="btn btn-danger mb-3" onClick={this.toggleForm}>
          {this.state.showForm ? "Unmount Form" : "Mount Form"}
        </button>

        {this.state.showForm && <MovieForm />} {/*//conditional rendering*/}
      </div>
    );
  }
}

export default MovieForm_MainApp;

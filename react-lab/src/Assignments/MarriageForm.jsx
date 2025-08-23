import { Component } from "react";
//Class Component
class MarriageForm extends Component {
  constructor(props) { 
    super(props);

    // It stores all input fields
    this.state = {
      brideName:"",
      groomName:"",
      date:"",
      venue:"",
      submitted: false // initially form is not submitted
    };
  }

  // Update state when input changes
  handleChangeController = (e) => {
    this.setState({  //used to update the state of class component
      [e.target.name]: e.target.value //update state dynamically based on input name [key]:value
      //name attribute in form
    });
  };

  // Handle the form submission
  submitHandler = (e) => {
    e.preventDefault(); // prevents page reload after submitting the form
    this.setState({ submitted: true }); // marks as submitted, details will be displayed
  };

  render() {
    return (
      <div className="container mt-4">
        <div className="card shadow">
          <div className="card-header">
            <h3>Marriage Form</h3>
          </div>
          <div className="card-body text-start  font-weight-bold"> 
            {/* Form to collect marriage details */}
            <form onSubmit={this.submitHandler}> {/*triggers submitHandler when form is submitted */}
              <div className="form-group mb-3">
                <label>Bride Name</label>
                <input
                  type="text"
                  className="form-control"
                  name="brideName"
                  value={this.state.brideName}
                  onChange={this.handleChangeController} // updates brideName in state
                  required
                />
              </div>

              <div className="form-group mb-3">
                <label>Groom Name</label>
                <input
                  type="text"
                  className="form-control"
                  name="groomName"
                  value={this.state.groomName}
                  onChange={this.handleChangeController} // updates groomName in state
                  required
                />
              </div>

              <div className="form-group mb-3">
                <label>Date</label>
                <input
                  type="date"
                  className="form-control"
                  name="date"
                  value={this.state.date}
                  onChange={this.handleChangeController} //updates date
                  required
                />
              </div>

              <div className="form-group mb-3">
                <label>Venue</label>
                <input
                  type="text"
                  className="form-control"
                  name="venue"
                  value={this.state.venue}
                onChange={this.handleChangeController}  //updates venue 
                  required
                />
              </div>

              <button type="submit" className="btn btn-primary">
                Submit
              </button>
            </form>
          </div>
        </div>

        {/* Displaying submitted details */}
        <div
          className="card mt-4"
          style={{ display: this.state.submitted ? "block" : "none" }} //TERNARY operator to conditionally display
        >
          <div className="card-header bg-success text-white">
            <h4>Marriage Details</h4>
          </div>
          <div className="card-body">
            <p><strong>Bride Name:</strong> {this.state.brideName}</p>
            <p><strong>Groom Name:</strong> {this.state.groomName}</p>
            <p><strong>Date:</strong> {this.state.date}</p>
            <p><strong>Venue:</strong> {this.state.venue}</p>

          </div>
        </div>
        <hr />
      </div>
    );
  }
}

export default MarriageForm;
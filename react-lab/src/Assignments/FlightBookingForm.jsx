import {Component,createRef} from "react";

// Class Component
class FlightControlled extends Component {
 constructor(props) { //initialises the component
    super(props);
    this.state = {     // It stores all input fields
      passengerName: "",
      email: "",
      gender: "",         //Initially empty then updated based on user input
      meal: "Veg",       //Default value for meal
      request: "",
      submitted: null,   //initially no data submitted
    }; 
  }

handleChange = (e) => {
    const { name, value } = e.target; //destructuring
    this.setState({ [name]: value }); //updates state dynamically based on input name [key]:value
  };      //relies on name attribute in form

    handleSubmit = (e) => { // handles form submission
    e.preventDefault();   //prevents page reload after submitting the form
    this.setState({     //setting the state with submitted data
      submitted: {
        passengerName: this.state.passengerName, //spread operator is not added as we are not merging here
        email: this.state.email,
        gender: this.state.gender,      //after submission, data is stored in submitted
        meal: this.state.meal,
        request: this.state.request,
      },
    });  
};

render() {
    return (
      <div className="container mt-2">
        <div className="card shadow">
          <div className="card-header">
            <h3>Controlled Flight Booking Form</h3>
          </div>
          <div className="card-body text-start  font-weight-bold"> 
        <form onSubmit={this.handleSubmit}>     {/*//triggers when clicked submit*/}
          <div className="mb-3">
            <label className="form-label">Passenger Name</label>
            <input
              type="text"
              name="passengerName"
              value={this.state.passengerName} //typed input value is stored in state
              onChange={this.handleChange} //updates state when typing
              className="form-control"
              required
            />
          </div>

          <div className="mb-3">
            <label className="form-label">Email</label>
            <input
              type="email"
              name="email"
              value={this.state.email}  //controlled component (value comes from state)
              onChange={this.handleChange} //updates state when typing
              className="form-control"
              required
            />
          </div>

          <div className="mb-3">
            <label className="form-label">Gender</label><br />
            <div className="form-check form-check-inline">
              <input
                type="radio"
                name="gender"   //SHOULD BE SAME
                value="Male"
                checked={this.state.gender === "Male"}  //explicitly checks
                onChange={this.handleChange} //triggers when changed
                className="form-check-input"
              />
              <label className="form-check-label">Male</label>
            </div>
            <div className="form-check form-check-inline">
              <input
                type="radio"
                name="gender"
                value="Female"
                checked={this.state.gender === "Female"}
                onChange={this.handleChange}
                className="form-check-input"
              />
               <label className="form-check-label">Female</label>
            </div>
          </div>
          
          <div className="mb-3">
            <label className="form-label">Meal Preference</label>
            <select
              name="meal"
              value={this.state.meal} //controlled component (value comes from state)
              onChange={this.handleChange} //updates state when changed
              className="form-select"
            >
              <option value="Veg">Veg</option>
              <option value="Non-Veg">Non-Veg</option>
            </select>
          </div>

 <div className="mb-3">
            <label className="form-label">Special Request</label>
            <textarea
              name="request"
              value={this.state.request}  //controlled component (value comes from state)
              onChange={this.handleChange} //updates state when typing
              className="form-control"
            />
          </div>
           <button type="submit" className="btn btn-primary">
            Submit Controlled Form
          </button>
        </form>
        </div>

        {/* Display Submitted Data */}
        {this.state.submitted && (  //displays only if all the data is submitted
          <div className="mt-4">
            <h5>Submitted Details</h5>
            <table className="table table-bordered">
              <thead className="table-dark">
                <tr>
                  <th>Passenger Name</th>
                  <th>Email</th>
                  <th>Gender</th>
                  <th>Meal</th>
                  <th>Request</th>
                </tr>
              </thead>
              <tbody>
                <tr> {/* getting the submitted data from submitted  */}
                  <td>{this.state.submitted.passengerName}</td>
                  <td>{this.state.submitted.email}</td> 
                  <td>{this.state.submitted.gender}</td>
                  <td>{this.state.submitted.meal}</td>
                  <td>{this.state.submitted.request}</td>
                </tr>
              </tbody>
            </table>
          </div>
        )}
        
      </div>
            
            </div>
    );
  }
}

//class component with uncontrolled inputs using refs
// Refs are used to directly access DOM elements without state management
class FlightUncontrolled extends Component {
  constructor(props) {
    super(props);
    // Refs used instead of state  //Creating refs for each input field
    this.flightNoRef = createRef();  //stored in the dom accessed  via ref attribute
    this.sourceRef = createRef();  
    this.destRef = createRef();
    this.dateRef = createRef();
    this.termsRef = createRef();

    this.state = { submitted: null };  //initially no data submitted
  }

  handleSubmit = (e) => { //handles form submission
    e.preventDefault(); //prevents page reload after submitting the form
    // Collecting data from refs
    this.setState({     //values are not stored in state but in refs
      submitted: {      //retrieved directly from dom
        flightNo: this.flightNoRef.current.value, //current points to the DOM
        source: this.sourceRef.current.value,     //value extracts what user typed
        destination: this.destRef.current.value,
        travelDate: this.dateRef.current.value,
        termsAccepted: this.termsRef.current.checked ? "Yes" : "No", //checked if terms are accepted (Ternary operator)
      },
    });
  };



  render() {
    return (
         <div className="container mt-4">
        <div className="card shadow">
          <div className="card-header">
            <h3>Uncontrolled Flight Booking Form</h3>
          </div>
          <div className="card-body text-start "> 
        <form onSubmit={this.handleSubmit}> {/*//triggers when clicked submit*/}
          <div className="mb-3">
            <label className="form-label">Flight Number</label>
            <input type="text" ref={this.flightNoRef} className="form-control" required />
          </div>
          {/* here inputs dont use onchange  or value*/}
          <div className="mb-3">
            <label className="form-label">Source</label>
            <input type="text" ref={this.sourceRef} className="form-control" required />
          </div>

          <div className="mb-3">
            <label className="form-label">Destination</label>
            <input type="text" ref={this.destRef} className="form-control" required />
          </div>

          <div className="mb-3">
            <label className="form-label">Travel Date</label>
            <input type="date" ref={this.dateRef} className="form-control" required />
          </div>

          <div className="form-check mb-3">
            <input type="checkbox" ref={this.termsRef} className="form-check-input" />
            <label className="form-check-label">Accept Terms & Conditions</label>
          </div>

          <button type="submit" className="btn btn-success">
            Submit Uncontrolled Form
          </button>
        </form>
        </div>
         </div>
        
         {/* Display Submitted Data */}
        {this.state.submitted && ( //displays only if all the data is submitted
          <div className="card mt-4 p-3 shadow">
            <h5>Submitted Flight Details</h5>
            <p><strong>Flight Number:</strong> {this.state.submitted.flightNo}</p>
            <p><strong>Source:</strong> {this.state.submitted.source}</p>
            <p><strong>Destination:</strong> {this.state.submitted.destination}</p>
            <p><strong>Travel Date:</strong> {this.state.submitted.travelDate}</p>
            <p><strong>Terms Accepted:</strong> {this.state.submitted.termsAccepted}</p>
          </div>
        )}
      </div>
            
             
          
    );
  }
}

// Main App Component to render both forms side by side
class App1 extends Component {
  render() {
    return (
      <div className="container my-4">
        <h2 className="mb-4 text-center">Flight Booking Demo</h2>
        <div className="row">
          <div className="col-md-6">
            <FlightControlled />
          </div>
          <div className="col-md-6">
            <FlightUncontrolled />
          </div>
        </div>
        <hr/>
      </div>
    );
  }
}

export default App1;
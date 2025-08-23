import { Component } from "react";

// Class Component
class AccessoriesForm extends Component {
  constructor(props) { //initialises the component
    super(props); 
    this.state = {    //it stores the values of the form fields
      accessoryName: "",
      description: "",
      category: "",
      brand: "",
      inStock: false,
      items: [] //to store submitted entries
    };
  }

  //change handler
  handleChange = (e) => {
    const { name, value, type, checked } = e.target; //destructructing 
    this.setState({
      /* if input is a checkbox, use checked else value */
      [name]: type === "checkbox" ? checked : value //Ternary operator to handle checkbox
    });
  };

  // Add item method
  addItem = () => {
    const { accessoryName, description, category, brand, inStock } = this.state; //destructuring

    if (accessoryName && description && category && brand) { // Checks if all required fields are filled
      const newItem = {
        accessoryName,
        description,
        category,
        brand,
        inStock
      };

      this.setState((prevState) => ({
        items: [...prevState.items, newItem], //Spread operator to add new item
        accessoryName: "",
        description: "",
        category: "",    // Resetting fields after submission
        brand: "",
        inStock: false
      }));
    }
  };

  render() {
    return (
       <div className="container mt-4 pt-4">
        <div className="card shadow">
          <div className="card-header">
            <h3>Accessories Form</h3>
          </div>
          <div className="card-body text-start  font-weight-bold"> 

        {/*Input Form*/}
        <div className="mb-3 text-start" >
          <label className="form-label">Accessory Name</label>
          <input
            type="text"
            name="accessoryName"  //like a key in state and important for onchange to identify the field
            className="form-control"
            value={this.state.accessoryName} //controlled component (value comes from state)
            onChange={this.handleChange} //triggers when clicked
            placeholder="Enter accessory name"
          />
        </div>

        <div className="mb-3 text-start">
          <label className="form-label">Description</label>
          <textarea
            name="description"
            className="form-control"
            rows="3"
            value={this.state.description}
            onChange={this.handleChange} //triggers when clicked
            placeholder="Enter description"
          ></textarea>
        </div>

        <div className="mb-3 text-start">
          <label className="form-label">Category</label>
          <select
            name="category"
            className="form-select"
            value={this.state.category}
            onChange={this.handleChange}
          >
            <option value="">Select category</option>
            <option value="Electronics">Electronics</option>
            <option value="Fashion">Fashion</option>
            <option value="Sports">Sports</option>
            <option value="Home">Home</option>
          </select>
        </div>

        <div className="mb-3 text-start">
          <label className="form-label">Brand</label> <br />
          <div className="form-check form-check-inline">
            <input
              type="radio"
              name="brand"
              value="Nike"
              className="form-check-input text-start"
              checked={this.state.brand === "Nike"} //checked if brand is Nike
              onChange={this.handleChange}
            />
            <label className="form-check-label">Nike</label>
          </div>
          <div className="form-check form-check-inline">
            <input
              type="radio"
              name="brand"
              value="Adidas"
              className="form-check-input"
              checked={this.state.brand === "Adidas"}
              onChange={this.handleChange}
            />
            <label className="form-check-label">Adidas</label>
          </div>
          <div className="form-check form-check-inline">
            <input
              type="radio"
              name="brand"
              value="Samsung"
              className="form-check-input"
              checked={this.state.brand === "Samsung"}
              onChange={this.handleChange}
            />
            <label className="form-check-label">Samsung</label>
          </div>
        </div>

        <div className="mb-3 form-check">
          <input
            type="checkbox"
            name="inStock"
            className="form-check-input"
            checked={this.state.inStock}
            onChange={this.handleChange}
          />
          <label className="form-check-label text-start">Available in Stock</label>
        </div>

        <button className="btn btn-primary text-start mb-3 " onClick={this.addItem}>
          Add Accessory
        </button>
</div>
</div>
        {/* Table Output */}
        <h3>Submitted Accessories</h3>
        <table className="table table-bordered table-striped text-center "> 
          <thead className="table-dark">
            <tr>
              <th>Accessory Name</th>
              <th>Description</th>
              <th>Category</th>
              <th>Brand</th>
              <th>In Stock</th>
            </tr>
          </thead>
          <tbody>
            {this.state.items.map((item, index) => ( //Mapping through items to display in table
              <tr key={index}>
                <td>{item.accessoryName}</td>
                <td>{item.description}</td>
                <td>{item.category}</td>
                <td>{item.brand}</td>
                <td>{item.inStock ? "Yes" : "No"}</td> {/*ternary operator */}
              </tr>
            ))}
          </tbody>
        </table>  
        <hr/>
      </div>
    );
  }
}

export default AccessoriesForm;

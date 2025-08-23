import {useState} from "react";
//Functional Component
const BakingForm= () =>{

    const [formData, setFormData] = useState({ //formData holds the values
        itemName: "",
            quantity: "",        //All fields are initially empty
            ingredients: "",
            bakingTime: "",
            category: "Bread", //default value for category field

});

const [items, setItems] = useState([]); // empty to store submitted entries

const handleChangeController = (e) => { //to handle input changes
    // destructuring
    const { name, value } = e.target;  
    setFormData({ ...formData, [name]: value }); //spread operator to update only the particular field and joining with existing state
  };

  const handleSubmit = (e) => { //to handle form submission
    e.preventDefault(); //prevents the page from reloading after form submission so that no dats is shown in the url
    setItems([...items, formData]); //add new item into array
    setFormData({
      itemName: "",      //resetting all fields to empty to type new data
      quantity: "",
      ingredients: "",
      bakingTime: "",
      category: "Bread" //resetting category to default value,
    }); // reset form
  };

  return (
    <div className="container mt-4 pt-4">
        <div className="card shadow">
          <div className="card-header">
            <h3>Baking Form</h3>
          </div>
          <div className="card-body text-start  font-weight-bold"> 

        <form onSubmit={handleSubmit}>  {/*//triggers handleSubmit when form is submitted */}
          <div className="mb-3 ">
            <label className="form-label">Item Name</label>
            <input
              type="text"
              className="form-control"
              name="itemName"
              value={formData.itemName} //controlled component
              onChange={handleChangeController} //updates state when typing
              required
            />
          </div>

          <div className="mb-3">
            <label className="form-label">Quantity</label>
            <input
              type="number"
              className="form-control"
              name="quantity"
              value={formData.quantity} //controlled component
              onChange={handleChangeController} //updates state when typing
              required
            />
          </div>

          
          <div className="mb-3">
            <label className="form-label">Ingredients</label>
            <input
              type="text"
              className="form-control"
              name="ingredients"
              value={formData.ingredients}
              onChange={handleChangeController} //updates state when typing
              required
            />
          </div>

             <div className="mb-3">
            <label className="form-label">Baking Time (mins)</label>
            <input
              type="number"
              className="form-control"
              name="bakingTime"
              value={formData.bakingTime}
              onChange={handleChangeController} //updates state when typing
              required
            />
          </div>

           <div className="mb-3">
            <label className="form-label">Category</label>
            <select
              className="form-select"
              name="category"
              value={formData.category}
              onChange={handleChangeController} //updates state when typing
            >
              <option value="Cake">Cake</option>
              <option value="Bread">Bread</option>
              <option value="Pastry">Pastry</option>
            </select>
          </div>

           <button type="submit" className="btn btn-primary">
            Add Item
          </button>
        </form>
      </div>
      </div>

      {/* Displaying the Table*/}
      {items.length > 0 && (  //if items array is not empty(that means items not equal to zero), display the table
        <div className="card shadow p-4 mt-4">
          <h4 className="mb-3">Baking Items List</h4>
          <table className="table table-bordered table-striped">
            <thead className="table-dark">
              <tr>
                <th>#</th>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Ingredients</th>
                <th>Baking Time</th>
                <th>Category</th>
              </tr>
            </thead>
            <tbody>
              {items.map((item, index) => (  //Mapping through items to display in table
                <tr key={index}> {/* key is required when mapping through elements (starts from 0)*/} 
                  <td>{index + 1}</td> {/* index + 1 to show item number from 1 so that it becomes easy to understand */}
                  <td>{item.itemName}</td>
                  <td>{item.quantity}</td>
                  <td>{item.ingredients}</td>
                  <td>{item.bakingTime} mins</td>
                  <td>{item.category}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
      <hr/>
    </div>
    
    
  );
};

export default BakingForm;

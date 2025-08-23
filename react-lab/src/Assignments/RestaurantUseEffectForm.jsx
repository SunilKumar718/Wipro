import { useState, useEffect } from "react";

//functional Component
function RestaurantForm() {
  //State for form fields
  const [formData, setFormData] = useState({ //for preserving and setting the data
    restaurantName: "",
    ownerName: "",
    email: "",
    contact: "",    //initially empty fields
    address: "",
    cuisine: "",
    openingHours: "",
  });

  const [submittedData, setSubmittedData] = useState(null);  //initially form stores nothing, then it holds the submitted form values

  // Handle input change
  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value }); //Spread Operator merges with whatever the data is given in the input fields
  };

  //Handle form submit
  const handleSubmit = (e) => {
    e.preventDefault(); //prevents the page from loading
    setSubmittedData(formData); //Save form data to display as JSON
  };


  //Run on every render
  useEffect(() => {
    console.log("Restaurant Form Rendered");
  }); //no dependencies so runs after every render

  //Run only once (on mount)
  useEffect(() => {
    alert("Welcome to Restaurant Registration App 🍴");
  }, []); //empty depenedency so runs only once

  //Run whenever form data changes
  useEffect(() => {
    console.log("Form data changed:", formData);
  }, [formData]); //dependency is added,runs everytime formdata is changed

  //Auto-save every 5 seconds + cleanup
  useEffect(() => {
    const interval = setInterval(() => { //setting the time for autosaving(5 sec)
      console.log("Auto-saving data:", formData);
    }, 5000);

    //cleanup when component unmounts
    return () => {
      clearInterval(interval);
      console.log("Auto-save stopped"); //triggers when ui is not displayed or refreshed making sure it doesnt affect memory
    };
  }, [formData]);


  return (
     <div className="container mt-4">
      <h2 className="mb-4 text-center">Restaurant Registration Form</h2>

      {/*Form*/}
      <form onSubmit={handleSubmit} className="border p-4 rounded shadow">
        <div className="mb-3">
          <label className="form-label">Restaurant Name</label>
          <input
            type="text"
            name="restaurantName" //like a key when typing in the input
            className="form-control" 
            value={formData.restaurantName} //value typed
            onChange={handleChange} //triggers when changed
            required
          />
        </div>

        <div className="mb-3">
          <label className="form-label">Owner Name</label>
          <input
            type="text"
            name="ownerName"
            className="form-control"
            value={formData.ownerName}
            onChange={handleChange}
            required
          />
        </div>

           <div className="mb-3">
          <label className="form-label">Email</label>
          <input
            type="email"
            name="email"
            className="form-control"
            value={formData.email}
            onChange={handleChange}
            required
          />
        </div>

             <div className="mb-3">
          <label className="form-label">Contact Number</label>
          <input
            type="text"
            name="contact"
            className="form-control"
            value={formData.contact}
            onChange={handleChange}
            required
          />
        </div>

        <div className="mb-3">
          <label className="form-label">Address</label>
          <textarea
            name="address"
            className="form-control"
            value={formData.address}
            onChange={handleChange}
            required
          />
        </div>

       <div className="mb-3">
          <label className="form-label">Cuisine Type</label>
          <input
            type="text"
            name="cuisineType"
            className="form-control"
            value={formData.cuisineType}
            onChange={handleChange}
            required
          />
        </div>

        <div className="mb-3">
          <label className="form-label">Opening Hours</label>
          <input
            type="text"
            name="openingHours"
            className="form-control"
            value={formData.openingHours}
            onChange={handleChange}
            required
          />
        </div>

       <button type="submit" className="btn btn-primary w-100">
          Submit
        </button>
      </form>

      {/* DisplayJSON output */}
      {submittedData && ( //Conditional rendering(only shown when submittedData is not empty)
     <div className="mt-4">
          <h3>Submitted Data (JSON):</h3>
          <pre className="border rounded bg-light p-3">

        {/*Js Objects cant be shown directly on the browser so we are converting into JSON string*/}
            {JSON.stringify(submittedData, null, 2)}
          </pre>
        </div>
      )}
      <hr/>
    </div>
  );
}

export default RestaurantForm;
           

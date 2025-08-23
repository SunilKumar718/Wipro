import { useEffect, useState } from "react";
import axios from "axios";

//functional component
const TailoringInventory = () => {
  const [items, setItems] = useState([]); //to save the state of items

  useEffect(() => { //it runs only once after the component loads
    axios
      .get("http://localhost:5000/tailoringItems") //calls the JSON server API
      .then((response) => {
        setItems(response.data);  //saving the response data into setItems
      })
      .catch((error) => { //else cathes the error
        console.error("Error fetching data:", error);
      });
  }, []); //empty dependency

  return (
    <div className="container mt-4">
      <h2 className="mb-3">Tailoring Shop Inventory</h2>

      <table className="table table-bordered table-striped">
        <thead className="table-dark">
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Size</th>
            <th>Price (₹)</th>
          </tr>
        </thead>
        <tbody>
          {items.length > 0 ? (  //conditional rendering (render if only length>0)
            items.map((item) => (  //looping through the items
              <tr key={item.id}>
                <td>{item.id}</td>
                <td>{item.name}</td>
                <td>{item.size}</td>
                <td>{item.price}</td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="4" className="text-center">
                No items available
              </td>
            </tr>
          )}
        </tbody>
      </table>
      <hr/>
    </div>
  );
};

export default TailoringInventory;

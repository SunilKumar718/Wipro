import  { useState } from "react";

//Functional Component
const Electronics = () => {

  const [name, setName] = useState("Laptop"); //useState is used to manage the state
  const [brand, setBrand] = useState("hp");
  const [price, setPrice] = useState(55000);

  const updateBrand = () => {
    setBrand("Acer");       //Updating the brand state
  };

  const updatePrice = () => {
    setPrice(price + 2000);  //Increasing the price by 2000
  };

  return (
    <div>
      <h2>Electronic Item Details</h2>
      <p><strong>Name:</strong> {name}</p>
      <p><strong>Brand:</strong> {brand}</p>
      <p><strong>Price:</strong> {price}</p>

      <button onClick={updateBrand}>Update Brand</button>
      <button onClick={updatePrice} >Increase Price</button>
      <hr/>
    </div>
  );
};

export default Electronics;

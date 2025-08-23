
{/*Functional Arrow Component */}
const CanteenItem = ({ name, price, category, available }) => { //Properties
  return (
    <div >
      <p><strong>Name:</strong> {name}</p>
      <p><strong>Price:</strong> ₹{price}</p>
      <p><strong>Category:</strong> {category}</p>
      <p><strong>Available:</strong> {available}</p>
    </div>
  );
};

export default CanteenItem;
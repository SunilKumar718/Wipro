import { Component } from "react";

//Class Component
class MenuItem extends Component {
  render() {
    const {name, price, category, available } =this.props; //Destructuring props

    return (
      <div style={{ padding: "10px",}}>
        <p><strong>Name:</strong> {name}</p>
        <p><strong>Price:</strong> ₹{price}</p>
        <p><strong>Category:</strong> {category}</p>
        <p><strong>Available:</strong> {available}</p>
      </div>
    );
  }
}

export default MenuItem;

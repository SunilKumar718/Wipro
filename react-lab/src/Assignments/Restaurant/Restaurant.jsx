import { Component } from "react";
import MenuItem from "./MenuItem";

//Class Component
class Restaurant extends Component {
  render() {    //mandatory render method in class component
    return (
      <div>
        <h2>Spice Hub</h2>
        <p><strong>Location:</strong> Block B, First Floor</p>
        <p><strong>Open Hours:</strong> 10:00 AM - 10:00 PM</p>

        <h3>Restaurant Menu</h3>
        {/* Passing MenuItem component */}
        <MenuItem name="Paneer Butter Masala" price={150} category="Main Course" available="Yes" />
        <MenuItem name="Chicken Biryani" price={200} category="Main Course" available="Yes" />
        <MenuItem name="Masala Dosa" price={80} category="Breakfast" available="No"/>
        <MenuItem name="Gulab Jamun" price={40} category="Dessert" available="Yes"/>
        <hr/>
      </div>
    );
  }
}

export default Restaurant;

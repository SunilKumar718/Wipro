import CanteenItem from "./CanteenItems";

//Functional Arrow Component
const CanteenMenu = () => {
  return (
    <div>
      <h2>Campus Food Court</h2>
      <p><strong>Location:</strong> Block A, Ground Floor</p>
      <p><strong>Open Hours:</strong> 8:00 AM - 8:00 PM</p>

      <h3>Canteen Menu</h3>
      {/* Passing CanteenItem component */}
      <CanteenItem name="Idli" price={30} category="Breakfast" available="Yes" />
      <CanteenItem name="Dosa" price={40} category="BreakFast" available="Yes" />
      <CanteenItem name="Vada" price={20} category="Snack" available="No" />
      <CanteenItem name="Poori" price={45} category="BreakFast" available="Yes" />
      <CanteenItem name="Meals" price={90} category="Lunch" available="Yes" />
      <hr/>
    </div>
  );
};

export default CanteenMenu;

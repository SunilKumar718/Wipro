
//Functional Arrow Component
const SweetsList = () =>{
    const sweets = [    //Array of sweets objects
    { id: 1, name: "Gulab Jamun", price: 120 },
    { id: 2, name:"Rasgulla", price: 100 },
    { id: 3, name:"Kaju Katli", price: 250 },
    { id: 4, name:"Jalebi", price: 80 },
    { id: 5, name:"Ladoo", price: 150 }
  ];


return (
    <div>
      <h2>Sweets List</h2>
      {sweets.map((sweet) => (  //loops through the sweets array and renders each sweet
        <div key={sweet.id}>    {/*unique key for each sweet*/}
          {sweet.name} - Price: ₹{sweet.price}
        </div>
      ))}
      <hr/>
    </div>
    );
};
export default SweetsList;
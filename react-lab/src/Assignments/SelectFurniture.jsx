import  { useState } from "react";

//Functional Component
function Furniture() {
  const [selectedFurniture, setSelectedFurniture] = useState("sofa"); //using usestate to preserve the current values

  //Mini components inside App
    const Chair = () => (
 <div className="card shadow-sm border rounded mx-auto mt-3" style={{ width: "22rem" }}>
      <div className="card-body">
        <h5 className="card-title">Chair</h5>
        <p className="card-text"><b>Name:</b> Office Chair</p>
        <p className="card-text"><b>Price:</b> ₹2500</p>
        <p className="card-text"><b>Material:</b> Plastic</p>
        <p className="card-text"><b>Brand:</b> Nilkamal</p>
      </div> 
     
    </div>
   
  );
     


  const Table = () => (
    <div className="card shadow-sm border rounded mx-auto mt-3" style={{ width: "22rem" }}>
      <div className="card-body">
        <h5 className="card-title">Table</h5>
        <p className="card-text"><b>Name:</b> Dining Table</p>
        <p className="card-text"><b>Price:</b> ₹8000</p>
        <p className="card-text"><b>Material:</b> Oak Wood</p>
        <p className="card-text"><b>Brand:</b> HomeTown</p>
      </div>
      
    </div>
  );
  

   const Sofa = () => (
    <div className="card shadow-sm border rounded mx-auto mt-3">
      <div className="card-body">
        <h5 className="card-title">Sofa</h5>
        <p className="card-text"><b>Name:</b> Luxury Sofa</p>
        <p className="card-text"><b>Price:</b> ₹15000</p>
        <p className="card-text"><b>Material:</b> Leather</p>
        <p className="card-text"><b>Brand:</b> Urban Ladder</p>
      </div>
    </div>
  );

  <hr></hr>
  const Bed = () => (
    <div className="card shadow-sm border rounded mx-auto mt-3" style={{ width: "22rem" }}>
      <div className="card-body">
        <h5 className="card-title">Bed</h5>
        <p className="card-text"><b>Name:</b> King Size Bed</p>
        <p className="card-text"><b>Price:</b> ₹20000</p>
        <p className="card-text"><b>Material:</b> Sheesham Wood</p>
        <p className="card-text"><b>Brand:</b> Pepperfry</p>
      </div>
    </div>
   
  );

  //Function that chooses which furniture to display
  const renderFurniture = () => {   //Switch cases
    switch (selectedFurniture) {  //if selected furniture is " " , it displays that particular furniture
      case "chair":
        return <Chair />;
      case "table":
        return <Table />;
      case "sofa":
        return <Sofa />;
      case "bed":
        return <Bed />;
      default:
        return <p>Please select a furniture</p>; //default one
    }
  };

  return (
     <div className="container text-center mt-4 ">
      <h1 className="mb-3">Furniture Store</h1>

      {/*Dropdown for selecting furniture */}
      <select
        value={selectedFurniture}   //whatever the furniture selected
        onChange={(e) => setSelectedFurniture(e.target.value)} //function to hold the selected furniture properties
      >
        <option value="chair">Chair</option>
        <option value="table">Table</option>
        <option value="sofa">Sofa</option>
        <option value="bed">Bed</option>
      </select>

      <hr />
      {renderFurniture()} {/* rendering the component of containing switchcases*/}
   
    </div>
  );
}

export default Furniture;

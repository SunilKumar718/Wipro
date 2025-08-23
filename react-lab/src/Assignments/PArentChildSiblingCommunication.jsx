import { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

//functional Component (parent)
function Communication() {

  // Parent state
  const [fruits, setFruits] = useState(["Apple", "Mango"]); //Initially aray contains two elements
  const [selectedFruit, setSelectedFruit] = useState(""); //here empty

    //Add new fruit(from Child B)
  const addFruit = (fruit) => {
    setFruits([...fruits, fruit]); //adds the new one with the existing one using spread operator
  };

    // Select fruit(from Child A)
  const handleSelectFruit = (fruit) => {
    setSelectedFruit(fruit); //setting the new fruit selected into selectedfruit
  };

    return (
    <div className="container mt-4">
      <h2 className="text-center ">React-Parent/Child/Sibling Communication </h2>
      <div className="row mt-4">

        {/*Child A*/}
        <div className="col-md-4">
            {/*fruits-propname and {fruits} is parent state variable
             and we are passing the fruits list from parent to child here

               //React has a one-way data flow: parent → child
            //But what if a child wants to send something back?
            Example: Child B wants to add "Orange" to the list.

            Children cannot directly change the parent’s state.

            So parent gives them a function (callback) like onAddFruit.

            When the child clicks a button → it calls onAddFruit("Orange").

            Parent hears it and updates fruits.

            onselectfruit is like a callback function to change the list in parent

                        */}
          <ChildA fruits={fruits} onSelectFruit={handleSelectFruit} />
        </div>

        {/*Child B*/}
        <div className="col-md-4">
          <ChildB onAddFruit={addFruit} /> {/*if childB wants to add a fruit to list,addfruit is the only way to communicate with */}
        </div>

        {/*Child C*/}
        <div className="col-md-4">
          <ChildC selectedFruit={selectedFruit} /> {/*prop={parentstate} 
                                                    So whatever fruit the user clicked in ChildA, Parent saves it in selectedFruit, then gives it to ChildC.*/}
        </div>
      </div>
        <hr/>
    </div>
  );


  function ChildA({ fruits, onSelectFruit }) {  {/*receives 2 props from parent */}
  return (
    <div className="card p-3">
      <h5>Child A - Fruit List</h5>
      <ul className="list-group">
        {fruits.map((fruit, index) => ( //mapping through the array
          <li
            key={index} //uniquw key is needed by react for  each item
            className="list-group-item"
            onClick={() => onSelectFruit(fruit)} //gives the clicked fruit 
            style={{ cursor: "pointer" }}  //shows like a pointer
          >
            {fruit} {/*displays the fruit name inside list */}
          </li>
        ))}
      </ul>
    </div>
  );
}

function ChildB({ onAddFruit }) {
  return (
    <div className="card p-3">
      <h5>Child B</h5>
      <button
        className="btn btn-success"
        onClick={() => onAddFruit("Orange")} //when clicked orange is sent and added to array
      >
        Send Fruit (Orange)
      </button>
    </div>
  );
}

function ChildC({ selectedFruit }) { //one prop
  return (
    <div className="card p-3">
      <h5>Child C</h5>
      {selectedFruit ? (  //conditional rendering  ,if selectedfruit is true,display the fruit else say no fruit found
        <p>Selected Fruit: <b>{selectedFruit}</b></p>
      ) : (
        <p>No fruit selected yet</p>
      )}
    
    </div>
  );
}

}

export default Communication;
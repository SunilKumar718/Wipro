import Juice from "./Juice";

//Functional Arrow Component
const JuiceList = () => {
  const juices = [                 //Array of juice objects
    { id: 1, name: "Mango", price: 40 },
    { id: 2, name: "Papaya", price: 30 },
    { id: 3, name: "Carrot", price: 60 },
    { id: 4, name: "Pineapple", price: 45 },
  ];

  return (
    <div style={{ padding: "20px" , textAlign: "center" , margin: "auto", }}>
      <h2>Juice Menu</h2>
      <table border="1" style={{textAlign: "center",margin: "auto", width: "100%", borderCollapse: "collapse"}} cellPadding="7">
        <thead>
          <tr>
            <th>ID</th>
            <th>Juice Name</th>
            <th>Price in (₹)</th>
          </tr>
        </thead>
        <tbody>
          {juices.map((juice) => (    //Loops through the juices array and render the Juice component for each juice
           /* Passing Juice component here*/
           <Juice key={juice.id}    //unique key for each juice so that react can identify easily
            id={juice.id} 
            name={juice.name}
             price={juice.price} />
          ))}
        </tbody>
      </table>
      <hr/>
    </div>
  );
};

export default JuiceList;


//Functional Arrow Component
const TempleList = () => {
  const temples = [     //Array of temple objects
    {
      id: 1,
      name: "Tirupati Balaji Temple",
      location: "Tirupati, Andhra Pradesh",
      deities: ["Lord Venkateswara", "Goddess Lakshmi"]
    },
    {
      id: 2,
      name: "Kashi Vishwanath Temple",
      location: "Varanasi, Uttar Pradesh",
      deities: ["Lord Shiva", "Goddess Annapurna"]
    },
    {
      id: 3,
      name: "Jagannath Temple",
      location: "Puri, Odisha",
      deities: ["Lord Jagannath", "Balabhadra", "Subhadra"]
    }
  ];

  return (
    <div>
      <h2>Temple List</h2>
      <table border="1" cellPadding="7" style={{ width: "100%" ,borderCollapse: "collapse"}}>
        <thead>
          <tr>
            <th>Temple Name</th>
            <th>Location</th>
            <th>Deities</th>
          </tr>
        </thead>
        <tbody>
          {temples.map((temple) => (  //Loops through the temples array and renders each temple
            <tr key={temple.id}>
              <td>{temple.name}</td>
              <td>{temple.location}</td>
              <td>
                <ul>
                  {temple.deities.map((deity, index) => ( // ( Nested loop)Loops through the deities array of each temple
                    <li key={index}>{deity}</li> //index used a unique key for each deity when there is no unique id
                  ))}
                </ul>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <hr/>
    </div>
  );
};

export default TempleList;

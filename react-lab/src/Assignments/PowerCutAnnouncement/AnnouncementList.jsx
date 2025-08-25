
import { useContext } from "react";
import { PowerCutContext } from "./PowerCutContext";


const AnnouncementList = () => {
  //using useContext to get announcements array from global context
  const { announcements } = useContext(PowerCutContext);

  return (
   
    <div className="card p-3">
      <h5 className="mb-3">Announcements</h5>

      <div style={{ maxHeight: "300px", overflowY: "auto" }}>
        {/*Checking if there are announcements*/}
        {announcements.length === 0 ? (      //if no, this message will be shown
          <p className="text-muted">No announcements yet.</p>
        ) : (
          // else,map through announcements and display each announcements
          announcements.map((a) => (
            <div
              key={a.id} //always unique
              className={`border p-2 rounded mb-2
                 ${a.message.toLowerCase().includes("urgent") //converting into lowecase
                  ? "bg-warning"   //highlight urgent announcements
                  : "bg-light"
              }`}
            >
              {/*Display street, message, and time */}
              <strong>Street:</strong> {a.street} <br />
              <strong>Message:</strong> {a.message} <br />
              <small className="text-muted">Time: {a.time}</small>
            </div>
          ))
        )}
      </div>
    </div>
  );
};

export default AnnouncementList;

//Importing useState, and useContext
import { useState, useContext } from "react";
import { PowerCutContext } from "./PowerCutContext";

//Child Component
const SendAnnouncement = () => {
  const [street, setStreet] = useState("");   //to store street name
  const [message, setMessage] = useState(""); //to store announcement message

  //using useContext to consume values from PowerCutContext
  //here we get access to the addAnnouncement function
  const { addAnnouncement } = useContext(PowerCutContext);

  //Function to handle form submission
  const handleSubmit = (e) => {
    e.preventDefault(); //prevents page reload after submitting the form

    //checking both inputs are filled
    if (street.trim()!=="" && message.trim()!=="") {
        addAnnouncement(street, message); //call the addAnnouncement function from context
        setStreet("");  //clearing input fields after submission
        setMessage("");
    };
    };
  return (
    <div className="card p-3 mb-3 shadow-sm">
      <h5 className="mb-3">Send PowerCut Announcement</h5>

      {/*Form for adding announcement*/}
      <form onSubmit={handleSubmit}>
        {/*Street Name input*/}
        <input
          type="text"
          className="form-control mb-2"
          placeholder="Street Name"
          value={street} //typed value stores here
          onChange={(e) => setStreet(e.target.value)} //changing the state of street
        />

        {/*Announcement Message textarea*/}
        <textarea
          className="form-control mb-2"
          placeholder="Announcement Message"
          value={message} //typed value stores here
          onChange={(e) => setMessage(e.target.value)} //changing the state of message
        />

        {/*Submit button*/}
        <button type="submit" className="btn btn-primary w-100">
          Send
        </button>
      </form>
    </div>
  );
};

export default SendAnnouncement;

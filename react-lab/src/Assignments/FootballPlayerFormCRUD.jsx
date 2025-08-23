import { useEffect, useState } from "react";
import axios from "axios";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";

//JSON Server endpoint
//Run server: json-server --watch wiprodb/players.json --port 5002
const API_URL = "http://localhost:5002/players";

//functional component
const PlayerManagerForm = () => {
  const [players, setPlayers] = useState([]); //stores the players array,initially empty
  const [editingPlayer, setEditingPlayer] = useState(null); //for editing a player,intially null

  // Fetch Players
  useEffect(() => { //Runs once when component loads.
    axios
      .get(API_URL) //getting the url
      .then((res) => setPlayers(res.data))  //getting the data from json server
      .catch((err) => console.error("Error fetching players:", err)); //else catches the error
  }, []); //empty dependency

  //Validation Schema using yup
  const playerSchema = Yup.object({
    name: Yup.string().min(3, "Min 3 characters").required("Required"),

    age: Yup.number()
      .typeError("Must be a number")
      .min(16, "Must be at least 16")
      .max(40, "Max age 40")
      .required("Required"),

    position: Yup.string()
      .oneOf(
        ["Forward", "Midfielder", "Defender", "Goalkeeper"],
        "Invalid Position"
      )   //value must be one of the array
      .required("Required"),

    club: Yup.string().required("Required"),

    nationality: Yup.string().required("Required"),

    goals: Yup.number()
      .typeError("Must be a number") //must be a postive number
      .min(0, "Cannot be negative")
      .required("Required"),

    matchesPlayed: Yup.number()
      .typeError("Must be a number")  //must be a postive number
      .min(0, "Cannot be negative")
      .required("Required"),

    jerseyNumber: Yup.number()
      .typeError("Must be a number")
      .min(1, "Min 1") //minumum
      .max(99, "Max 99") //maximum
      .required("Required"),

    email: Yup.string().email("Invalid email").required("Required"),

    contactNumber: Yup.string()
      .matches(/^[0-9]{10}$/, "Must be 10 digits")
      .required("Required"),
  });

  //Add or Update Player
  const handleSubmit = (values, { resetForm }) => {
    {/*Values Contain all the form values 
        checks if we are in editing mode,if not null */}
    if (editingPlayer) {  //if player is available,then update using the playerid
      axios
        .put(`${API_URL}/${editingPlayer.id}`, values) //calling put request with id
        .then((res) => {
            {/*maps through all players
                if the playerid matches the player we want to edit,update else keep old one */}
          setPlayers(
            players.map((p) => (p.id === editingPlayer.id ? res.data : p)) //ternary operator
          );
          setEditingPlayer(null); //we are exiting the editing mode here
          resetForm();  //reset the form
        })
        .catch((err) => console.error("Error updating player:", err)); //catch the error
    } else {
        {/*If no player is being edited that this means it’s adding new player. */}
      axios
        .post(API_URL, values) //post method to add players
        .then((res) => {
          setPlayers([...players, res.data]); //spread operator to add to existing data
        })
        .catch((err) => console.error("Error adding player:", err));
      resetForm(); //reset the form
    }
  };

  // Delete Player
  const handleDelete = (id) => { //handling with id
    if (window.confirm("Are you sure you want to delete this player?")) { //Confirm alert is being asked if we click delete button
      axios
        .delete(`${API_URL}/${id}`) //delete method is called
        .then(() => {
            {/*filter creates a new array except the deleted one
                we are saying to create new array except the id we want to delete */}
          setPlayers(players.filter((p) => p.id !== id));
        })
        .catch((err) => console.error("Error deleting player:", err));
    }
  };

  return (
    <div className="container mt-4">
      <h2 className="mb-4 text-center">⚽ Football Player Manager</h2>

      {/* Add/Edit Form*/}
      <Formik
        initialValues={
          editingPlayer || {  //if editingplayer exists,prefill the form with the data it contains else default values
            name: "",
            age: "",
            position: "",
            club: "",       //default values
            nationality: "",
            goals: "",
            matchesPlayed: "",
            jerseyNumber: "",
            email: "",
            contactNumber: "",
          }
        }
        enableReinitialize //when the user clicks Edit on a table row, Formik will reinitialize the form with the new data.
        validationSchema={playerSchema}
        onSubmit={handleSubmit}
      >
        <Form className="mb-4">
          <div className="row g-2">
            <div className="col-md-4">
              <Field type="text" name="name" placeholder="Name" className="form-control" />
              <ErrorMessage name="name" component="div" className="text-danger" />
            </div>

            <div className="col-md-2">
              <Field type="number" name="age" placeholder="Age" className="form-control" />
              <ErrorMessage name="age" component="div" className="text-danger" />
            </div>

            <div className="col-md-3">
              <Field as="select" name="position" className="form-select">
                <option value="">Select Position</option>
                <option value="Forward">Forward</option>
                <option value="Midfielder">Midfielder</option>
                <option value="Defender">Defender</option>
                <option value="Goalkeeper">Goalkeeper</option>
              </Field>
              <ErrorMessage name="position" component="div" className="text-danger" />
            </div>

            <div className="col-md-3">
              <Field type="text" name="club" placeholder="Club" className="form-control" />
              <ErrorMessage name="club" component="div" className="text-danger" />
            </div>

            <div className="col-md-3">
              <Field type="text" name="nationality" placeholder="Nationality" className="form-control" />
              <ErrorMessage name="nationality" component="div" className="text-danger" />
            </div>

            <div className="col-md-2">
              <Field type="number" name="goals" placeholder="Goals" className="form-control" />
              <ErrorMessage name="goals" component="div" className="text-danger" />
            </div>

            <div className="col-md-3">
              <Field type="number" name="matchesPlayed" placeholder="Matches Played" className="form-control" />
              <ErrorMessage name="matchesPlayed" component="div" className="text-danger" />
            </div>

            <div className="col-md-2">
              <Field type="number" name="jerseyNumber" placeholder="Jersey No." className="form-control" />
              <ErrorMessage name="jerseyNumber" component="div" className="text-danger" />
            </div>

            <div className="col-md-4">
              <Field type="email" name="email" placeholder="Email" className="form-control" />
              <ErrorMessage name="email" component="div" className="text-danger" />
            </div>

            <div className="col-md-4">
              <Field type="text" name="contactNumber" placeholder="Contact Number" className="form-control" />
              <ErrorMessage name="contactNumber" component="div" className="text-danger" />
            </div>

            <div className="col-md-4">
              <button type="submit" className="btn btn-primary w-100">
                {editingPlayer ? "Update Player" : "Add Player"} {/*if editingplayer exists,updateplayer else addplayer */}
              </button>
            </div>
          </div>
        </Form>
      </Formik>

      {/* Players Table */}
      <table className="table table-bordered">
        <thead className="table-dark">
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Position</th>
            <th>Club</th>
            <th>Nationality</th>
            <th>Goals</th>
            <th>Matches</th>
            <th>Jersey</th>
            <th>Email</th>
            <th>Contact</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {players.map((p) => ( //mapping
            <tr key={p.id}>
              <td>{p.id}</td>
              <td>{p.name}</td>
              <td>{p.age}</td>
              <td>{p.position}</td>
              <td>{p.club}</td>
              <td>{p.nationality}</td>
              <td>{p.goals}</td>
              <td>{p.matchesPlayed}</td>
              <td>{p.jerseyNumber}</td>
              <td>{p.email}</td>
              <td>{p.contactNumber}</td>
              <td>
                <button
                  className="btn btn-warning btn-sm me-2"
                  onClick={() => setEditingPlayer(p)} //triggers when clicked
                >
                  Edit
                </button>
                <button
                  className="btn btn-danger btn-sm"
                  onClick={() => handleDelete(p.id)}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default PlayerManagerForm;

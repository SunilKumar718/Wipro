import { useState } from "react";
import { Formik, Form, Field, FieldArray, ErrorMessage } from "formik";
import * as Yup from "yup";

//Arrow Functional Component
const HockeyRegistrationForm = () => {
  const [records, setRecords] = useState([]);

  //Validation Schema with Yup
  const validationSchema = Yup.object({
    playerName: Yup.string() //must be a string
      .matches(/^[A-Za-z ]+$/, "Only alphabets and spaces allowed")
      .min(3,"Min 3 characters") //minimum
      .max(40, "Max 40 characters") //maximum
      .required("Player Name is required"), //manadatory field

    jerseyNumber: Yup.number() //must be a number
    .min(1,"Min 1")
    .max(99, "Max 99")
    .required("Jersey Number is required"), //manadatory field

    position: Yup.string().oneOf(["Forward", "Defense", "Goalie"])//values must be on of the array values
    .required("Position Required"),

    stickHand: Yup.string().oneOf(["Left", "Right"]) //values must be on of the array values
    .required("Stick Hand required"),

    dateOfBirth: Yup.date()
      .required("Date of Birth required")
      .test("age", "Age must be between 10 and 55",  //to test the age
        (value) => {
        if (!value)  //if empty, doesnt validate
          return false;
        const today = new Date(); //current date
        const dob = new Date(value); //given dob in the form
        const age = today.getFullYear() - dob.getFullYear(); //getting age
        return age >= 10 && age <= 55; //condition
      }),

    nationality: Yup.string()
    .required("Nationality Required"),

    email: Yup.string().email("Invalid email").required("Email Required"),

    phone: Yup.string()
      .matches(/^[6-9][0-9]{9}$/, "Must be 10-digit Indian number")
      .required("Required"),

    playerId: Yup.string()
      .matches(/^HOCK-\d{4}$/, "Format: HOCK-XXXX")
      .required("PlayerId is Required"),  //should use the same format

     guardianName: Yup.string().when("dateOfBirth", {  //depends on the dob field
      is: (dob) => { // 'is' is a  function that checks the condition
        if (!dob) //if dob is empty,return false
            return false;
            /*if there is a date,we calculate age */
        const age = new Date().getFullYear() - new Date(dob).getFullYear();
        return age < 18; //true if palyer is under 18
      },
      /* then it is required ,else not */
      then: (schema) => schema.required("Guardian Name required for under 18"),
      otherwise: (schema) => schema.notRequired(),
    }),

    // Team & Event
    teamName: Yup.string().required("Team Name Required"),

leagueLevel: Yup.string()
      .oneOf(["Amateur", "College", "Pro"]) //one of the values
      .required("League Level required"),

    tournamentName: Yup.string().required("Tournament Name required"),

    startDate: Yup.date().required("Start Date required"),

   endDate: Yup.date()
      .required("End Date required")
      .min(Yup.ref("startDate"), "End Date must be on or after Start Date"),// referring the start date to validate

      jerseySize: Yup.string().when("position", { 
      is: (pos) => pos !== "Goalie", //if not equal to goalie,required field else no
      then: (schema) => schema.required("Jersey Size required"),
      otherwise: (schema) => schema.notRequired(),
    }),

      padSize: Yup.string().when("position", { //depends on position field
      is: "Goalie", //if goalie then mandatory else no
      then: (schema) => schema.required("Pad Size required"),
      otherwise: (schema) => schema.notRequired(),
    }),

    // Medical & Consent
    hasMedicalCondition: Yup.boolean(), //true or false

     medicalCertNumber: Yup.string().when("hasMedicalCondition", { //when medicalcondition is true, it is mandatory
      is: true, //if true then mandatory else not required
      then: (schema) =>
        schema
          .matches(/^MED-\d{4}$/, "Format: MED-XXXX") //it shouldnatch the format
          .required("Medical Cert Number required"),
      otherwise: (schema) => schema.notRequired(), //else not required
    }),

    consent: Yup.boolean().oneOf([true], "Consent is required"),

    //Past Teams
    pastTeams: Yup.array().of(  //array
      Yup.object({ //nested field
          clubName: Yup.string()
                      .min(2, "Min 2 chars")
                      .max(30, "Max 30 chars")
                      .required("Club Name required"),
                      
          years: Yup.number()
                      .min(1, "Min 1 year")
                      .max(20, "Max 20 years")
                      .required("Years required"),
                })
              ).max(3, "Max 3 past teams allowed"),
            });

  return (
    <div className="container mt-4">
      <h2 className="mb-3">Hockey Tournament Registration</h2>

      <Formik
      //Initial Values
        initialValues={{
          playerName: "",
          jerseyNumber: "",
          position: "",
          stickHand: "",
          dateOfBirth: "",
          nationality: "",
          email: "",
          phone: "",
          playerId: "",
          guardianName: "",
          teamName: "",
          leagueLevel: "",
          tournamentName: "",
          startDate: "",
          endDate: "",
          jerseySize: "",
          padSize: "",
          hasMedicalCondition: false,
          medicalCertNumber: "",
          consent: false,
          pastTeams: [],
        }}

        validationSchema={validationSchema}
        //Submit Handler
        onSubmit={(values, { resetForm }) => {
          console.log("Submitted Data:", values);
          setRecords([...records, values]); //spread operator to join with existing data
          resetForm(); //resets the form
        }}
      >
        {({ values, isValid }) => (  //values-> current state of values(conditional conditional displaying purpose)
                                    //isValid->true only of all fields are filled(lets you enable/disable submit button)
          <Form className="card p-3">
             {/* Player Details */}
            <h5>Player Details</h5>
            <div className="row g-3">
              <div className="col-md-4">
                <label>Player Name</label>
                <Field name="playerName" className="form-control" />            
                {/**Displays Message under the field */}
                <ErrorMessage name="playerName" component="div" className="text-danger" />
              </div>

              <div className="col-md-4">
                <label>Jersey Number</label>
                <Field name="jerseyNumber" type="number" className="form-control" />
                <ErrorMessage name="jerseyNumber" component="div" className="text-danger" />
              </div>

              <div className="col-md-4">
                <label>Position</label>
                <Field as="select" name="position" className="form-select">
                  <option value="">Select</option>
                  <option>Forward</option>
                  <option>Defense</option>
                  <option>Goalie</option>
                </Field>
                <ErrorMessage name="position" component="div" className="text-danger" />
              </div>

              <div className="col-md-4">
                <label>Stick Hand</label>
                <Field as="select" name="stickHand" className="form-select">
                  <option value="">Select</option>
                  <option>Left</option>
                  <option>Right</option>
                </Field>
                <ErrorMessage name="stickHand" component="div" className="text-danger" />
              </div>

              <div className="col-md-4">
                <label>Date of Birth</label>
                <Field name="dateOfBirth" type="date" className="form-control" />
                <ErrorMessage name="dateOfBirth" component="div" className="text-danger" />
              </div>

              <div className="col-md-4">
                <label>Nationality</label>
                <Field name="nationality" className="form-control" />
                <ErrorMessage name="nationality" component="div" className="text-danger" />
              </div>

              <div className="col-md-4">
                <label>Email</label>
                <Field name="email" type="email" className="form-control" />
                <ErrorMessage name="email" component="div" className="text-danger" />
              </div>

              <div className="col-md-4">
                <label>Phone</label>
                <Field name="phone" className="form-control" />
                <ErrorMessage name="phone" component="div" className="text-danger" />
              </div>

               {/* Player ID */}
              <div className="col-md-4">
                <label>Player ID</label>
                <Field name="playerId" className="form-control" placeholder="HOCK-1234" />
                <ErrorMessage name="playerId" component="div" className="text-danger" />
              </div>

             {/*Guardian (conditional) */}
              <div className="col-md-4">
                <label>Guardian Name</label>
                <Field name="guardianName" className="form-control" />
                <ErrorMessage name="guardianName" component="div" className="text-danger" />
              </div>
            </div>

              {/* Team Info */}
            <h5 className="mt-4">Team & Event</h5>
            <div className="row g-3">
              <div className="col-md-4">
                <label>Team Name</label>
                <Field name="teamName" className="form-control" />
                <ErrorMessage name="teamName" component="div" className="text-danger" />
              </div>

              <div className="col-md-4">
                <label>League Level</label>
                <Field as="select" name="leagueLevel" className="form-select">
                  <option value="">Select</option>
                  <option>Amateur</option>
                  <option>College</option>
                  <option>Pro</option>
                </Field>
                <ErrorMessage name="leagueLevel" component="div" className="text-danger" />
              </div>

              <div className="col-md-4">
                <label>Tournament Name</label>
                <Field name="tournamentName" className="form-control" />
                <ErrorMessage name="tournamentName" component="div" className="text-danger" />
              </div>
              {/* Dates */}
              <div className="col-md-4">
                <label>Start Date</label>
                <Field name="startDate" type="date" className="form-control" />
                <ErrorMessage name="startDate" component="div" className="text-danger" />
              </div>

              <div className="col-md-4">
                <label>End Date</label>
                <Field name="endDate" type="date" className="form-control" />
                <ErrorMessage name="endDate" component="div" className="text-danger" />
              </div>

              {/* Conditional Jersey/Pad */}
            {values.position !== "Goalie" && ( //if not equal to goalie,display the field
              <div className="mb-3">
                <label>Jersey Size</label>
                <Field name="jerseySize" className="form-control" />
                <ErrorMessage name="jerseySize" component="div" className="text-danger" />
              </div>
            )}
              {values.position === "Goalie" && ( //if equal to goalie, display the field
              <div className="mb-3">
                <label>Pad Size</label>
                <Field name="padSize" className="form-control" />
                <ErrorMessage name="padSize" component="div" className="text-danger" />
              </div>
            )}
              {/* Medical */}
            <h5 className="mt-4">Medical & Consent</h5>
            <div className="form-check">
              <Field type="checkbox" name="hasMedicalCondition" className="form-check-input" id="medCond" />
              <label htmlFor="medCond" className="form-check-label">Has Medical Condition</label>
            </div>

            <div className="mt-2">
              <Field name="medicalCertNumber" className="form-control" placeholder="MED-1234" />
              <ErrorMessage name="medicalCertNumber" component="div" className="text-danger" />
            </div>
             {/* Consent */}
            <div className="form-check mt-2">
              <Field type="checkbox" name="consent" className="form-check-input" id="consent" />
              <label htmlFor="consent" className="form-check-label">I agree to terms</label>
              <ErrorMessage name="consent" component="div" className="text-danger" />
            </div>

              {/* Past Teams (FieldArray) */}
            <h5 className="mt-4">Past Teams (Max 3)</h5>
            <FieldArray name="pastTeams">
              {({ push, remove }) => (  //methods to remove and add the teams
                <div>
                  {values.pastTeams.map((team, index) => (   //looping through the values
                    <div key={index} className="row g-2 mb-2">
                      <div className="col-md-5">
                        <Field name={`pastTeams[${index}].clubName`}
                         placeholder="Club Name" 
                         className="form-control" />
                        <ErrorMessage name={`pastTeams[${index}].clubName`} 
                        component="div" className="text-danger" />
                      </div>

                      <div className="col-md-3">
                        <Field name={`pastTeams[${index}].years`} 
                        type="number" placeholder="Years" className="form-control" />
                        <ErrorMessage name={`pastTeams[${index}].years`} component="div" className="text-danger" />
                      </div>
                      
                      <div className="col-md-2">
                        <button type="button" className="btn btn-danger" onClick={() => remove(index)}>X</button> {/*special function to remove*/} 
                      </div>

                    </div>
                  ))}
                  {values.pastTeams.length < 3 && ( //Conditional rendering , render only if the length is <3

                    <button type="button" 
                    className="btn btn-secondary mt-2" 
                    onClick={() => push({ clubName: "", years: "" })}> {/*to add team*/}
                      + Add Team
                    </button>
                  )}
                </div>
              )}
            </FieldArray>

            {/*isValid is provided by formik, only true if all the fields are filled */}
            <button type="submit" className="btn btn-primary mt-3" disabled={!isValid}>
              Submit
            </button>
            </div>
          </Form>
        )}
      </Formik>

      {/* Submitted Records Table */}
      <h3 className="mt-5">Submitted Players</h3>
      <table className="table table-bordered mt-3">
        <thead>
          <tr>
            <th>Player ID</th>
            <th>Player Name</th>
            <th>Jersey</th>
            <th>Team</th>
            <th>Position</th>
            <th>Phone</th>
            <th>Tournament</th>
            <th>Email</th>
            <th>Past Teams</th>
          </tr>
                </thead>
                <tbody>
                    {records.map((r, i) => ( //mapping through the items
                      <tr key={i}>
                        <td>{r.playerId}</td>
                        <td>{r.playerName}</td>
                        <td>{r.jerseyNumber}</td>
                        <td>{r.teamName}</td>
                        <td>{r.position}</td>
                        <td>{r.phone}</td>
                        <td>{r.tournamentName}</td>
                        <td>{r.email}</td>
                        <td>
                          {r.pastTeams && r.pastTeams.length > 0 //if length>0,condition true and table is displayed
                            ? r.pastTeams.map((t) => `${t.clubName} (${t.years} yrs)`).join(", ") //joining
                            : "—"} {/*else*/}
                        </td> 
                      </tr>
                    ))}
                </tbody>
            </table>
            <hr/>
       </div>
  );
};

export default HockeyRegistrationForm;

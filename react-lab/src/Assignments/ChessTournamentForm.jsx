import  { useState } from "react";
import { Formik, Form, Field, ErrorMessage } from "formik"; //easy form handling
import * as Yup from "yup"; //easy validation of forms

//Arrow functional Component
const ChessTournamentForm = () => {
  const [submittedData, setSubmittedData] = useState([]); //usestate to store the submittedData

  const initialValues = {
    playerName: "",
    dob: "",
    gender: "",    //Initial values Object
    fideId: "",
    rating: "",
    email: "",
    mobile: "",   //formik uses this object to store the inputs
    country: "",
    category: "",
    parentContact: "",
    payment: false,  //Default values
    terms: false, 
  };

  //Validation schema
  const validationSchema = Yup.object({
    playerName: Yup.string() //must be a string
      .min(3, "Minimum 3 characters required")
      .required("Player Name is required"),

    dob: Yup.date()
      .required("Date of Birth is required")
      .test("age-range", "Age must be between 5 and 90 years", //it ensures age is 5-90
        function (value) {
        if (!value)  //value is the input value from field
            return false; //if value is empty or null,return false
        const today = new Date(); //current data
        const birthDate = new Date(value); //date entered in the form
        const age = today.getFullYear() - birthDate.getFullYear(); //Calculates approximate age by subtracting the year of birth from the current year.
        return age >= 5 && age <= 90; 
      }),

    gender: Yup.string().required("Gender is required"),

    fideId: Yup.string()
      .matches(/^\d{8}$/, "FIDE ID must be exactly 8 digits")
      .required("FIDE ID is required"),

    rating: Yup.number()
      .min(100, "Rating must be at least 100") //minimum 100
      .max(3000, "Rating cannot exceed 3000")  //maximum 3000
      .required("Rating is required"), //mandatory

    email: Yup.string().email("Invalid email format").required("Email is required"),

    mobile: Yup.string()
      .matches(/^[6-9]\d{9}$/, "Mobile must be 10 digits starting with 6-9") //it should start with 6,7,8,9
      .required("Mobile Number is required"),

    country: Yup.string().required("Country is required"),

    category: Yup.string().required("Category is required"),

    /*if the category is under 12 , then this field is mandatory else not required */
    parentContact: Yup.string().when("category", {
  is: (val) => val === "Under 12",   // ✅ must be a function or value check
  then: (schema) => schema
    .matches(/^\d{10}$/, "Parent contact must be 10 digits")
    .required("Parent contact is required for Under 12"),
  otherwise: (schema) => schema.notRequired(),
}),

    payment: Yup.boolean().oneOf([true], "Payment confirmation is required"), //default is false, so the remaining one is true, so it must be one of true not anyother value

    terms: Yup.boolean().oneOf([true], "You must accept terms & conditions"), //no other value other than true
  });

  const onSubmit = (values, { resetForm }) => {  //it automatically resets the form once submitted
    console.log("Registration Form data:", values);  //values printed in the console
    setSubmittedData((prevData) => [...prevData, values]); //spread operator to add the new data to existing data
    resetForm();  //resetting the form
  };

  return (
    <div className="container mt-4">
      <h2 className="mb-4">Chess Tournament Registration</h2>
      <Formik
        initialValues={initialValues}  //giving the object
        validationSchema={validationSchema}
        onSubmit={onSubmit} //triggers when submitted
      >
        {({ values }) => ( //for conditional rendering, it shows the particular field only when the condition is true like category in the form
          <Form>
            {/* Player Name */}
            <div className="mb-3">
              <label className="form-label">Player Name</label>
              <Field name="playerName" className="form-control" /> {/*//equal to input in normal html*/}
              <ErrorMessage name="playerName" component="div" className="text-danger" />
            </div>

            {/* Date of Birth */}
            <div className="mb-3">
              <label className="form-label">Date of Birth</label>
              <Field type="date" name="dob" className="form-control" />
              <ErrorMessage name="dob" component="div" className="text-danger" />{/**SHows the validation errors under the field */}
            </div>

            {/* Gender */}
            <div className="mb-3">
              <label className="form-label">Gender</label>
              <Field as="select" name="gender" className="form-select">
                <option value="">Select</option>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Other">Other</option>
              </Field>
              <ErrorMessage name="gender" component="div" className="text-danger" />
            </div>

            {/* FIDE ID */}
            <div className="mb-3">
              <label className="form-label">FIDE ID</label>
              <Field name="fideId" className="form-control" />
              <ErrorMessage name="fideId" component="div" className="text-danger" />
            </div>

            {/* Rating */}
            <div className="mb-3">
              <label className="form-label">Rating</label>
              <Field type="number" name="rating" className="form-control" />
              <ErrorMessage name="rating" component="div" className="text-danger" />
            </div>

            {/* Email */}
            <div className="mb-3">
              <label className="form-label">Email</label>
              <Field type="email" name="email" className="form-control" />
              <ErrorMessage name="email" component="div" className="text-danger" />
            </div>

            {/* Mobile */}
            <div className="mb-3">
              <label className="form-label">Mobile Number</label>
              <Field name="mobile" className="form-control" />
              <ErrorMessage name="mobile" component="div" className="text-danger" />
            </div>

            {/* Country*/}
            <div className="mb-3">
              <label className="form-label">Country</label>
              <Field name="country" className="form-control" />
              <ErrorMessage name="country" component="div" className="text-danger" />
            </div>

            {/* Category */}
            <div className="mb-3">
              <label className="form-label">Category</label>
              <Field as="select" name="category" className="form-select">
                <option value="">Select</option>
                <option value="Under 12">Under 12</option>
                <option value="Under 18">Under 18</option>
                <option value="Open">Open</option>
              </Field>
              <ErrorMessage name="category" component="div" className="text-danger" />
            </div>

            {/* Parent Contact */}
            {values.category === "Under 12" && (
              <div className="mb-3">
                <label className="form-label">Parent Contact</label>
                <Field name="parentContact" className="form-control" />
                <ErrorMessage name="parentContact" component="div" className="text-danger" />
              </div>
            )}

            {/*Payment Confirmation */}
            <div className="form-check mb-3">
              <Field type="checkbox" name="payment" className="form-check-input" />
              <label className="form-check-label">Payment Confirmation</label>
              <ErrorMessage name="payment" component="div" className="text-danger" />
            </div>

            {/*Terms*/}
            <div className="form-check mb-3">
              <Field type="checkbox" name="terms" className="form-check-input" />
              <label className="form-check-label">Accept Terms & Conditions</label>
              <ErrorMessage name="terms" component="div" className="text-danger" />
            </div>

            {/*Submit Button*/}
            <button type="submit" className="btn btn-primary">Submit</button>
            <hr/>
          </Form>
        )}
      </Formik>

      {/* Display submitted data in table */}
      {submittedData.length > 0 && ( //conditional rendering if length >0
        <div className="mt-5">
          <h4>Submitted Players Data</h4>
          <table className="table table-bordered">
            <thead className="table-dark">
              <tr>
                <th>Name</th>
                <th>DOB</th>
                <th>Gender</th>
                <th>FIDE ID</th>
                <th>Rating</th>
                <th>Email</th>
                <th>Mobile</th>
                <th>Country</th>
                <th>Category</th>
                <th>Parent Contact</th>
              </tr>
            </thead>
            <tbody>
              {submittedData.map((player, index) => ( //looping through the data
                <tr key={index}>
                  <td>{player.playerName}</td>
                  <td>{player.dob}</td>
                  <td>{player.gender}</td>
                  <td>{player.fideId}</td>
                  <td>{player.rating}</td>
                  <td>{player.email}</td>
                  <td>{player.mobile}</td>
                  <td>{player.country}</td>
                  <td>{player.category}</td>
                  <td>{player.parentContact || "-"}</td>
                </tr>
              ))}
            </tbody>
          </table>
          <hr/>
        </div>
      )}
    </div>
  );
};

export default ChessTournamentForm;

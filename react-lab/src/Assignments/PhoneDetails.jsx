import {useState} from 'react';

//Functional Component
const PhoneDetails = () => {
    const [phoneNum,setPhoneNum] = useState({ //It is used to manage the state
    brand: "Realme",
    model: "11 pro",
    price: 25000
    });
    const updatePrice= () => {
        setPhoneNum({
            ...phoneNum, //Spread operator to keep the existing state
            price: phoneNum.price + 1000}); //updating only the price 
};
        return (
            <div>
                <h2>Phone Details</h2>
                <p><strong>Brand:</strong> {phoneNum.brand}</p>
                <p><strong>Model:</strong> {phoneNum.model}</p>
                <p><strong>Price:</strong> ₹{phoneNum.price}</p>
                <button onClick={updatePrice}>Update Price</button>
                <hr/>
            </div>
        );
        };

export default PhoneDetails;
    
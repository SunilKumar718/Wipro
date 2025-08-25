
//Importing
import { createContext,  //creates a new context globally
         useState } from "react";

export const PowerCutContext = createContext(); //Creating a context object globally 

//Create a custom hook (for easier access in components)
// export const usePowerCut = () => useContext(PowerCutContext);

// 4. Create the Provider component
const PowerCutProvider = ({ children }) => { //defining the child components
  //list of announcements
  const [announcements, setAnnouncements] = useState([]); //usestate to store the announcements

  //Function to add a new announcement
  const addAnnouncement = (street, message) => {
    const newAnnouncement = {
      id: Date.now(), //creates a uniqueId
      street,         //street name
      message,        //announcement content
      time: new Date().toLocaleTimeString() //urrent time
    };

    //Add new announcement at the top of the list
    setAnnouncements([newAnnouncement, ...announcements]); //spread operator to join the new data with the existing data
  };

  //Provide state + function to child components
  return (
    /*value prop is what you share with the other components
    Here we are passing the announcements and function to add new announcements
    */
    <PowerCutContext.Provider value={{ announcements, addAnnouncement }}> {/*//provider is responsible for supplying the values*/} 
      {children}   {/*Childer can access these(consumer) */}
    </PowerCutContext.Provider>
  );
};

export default PowerCutProvider;
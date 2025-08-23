import { useEffect, useState } from "react";

function FestivalApp() {

  const [festival, setFestival] = useState("Diwali"); //setting the state here with current value

  const [countdown, setCountdown] = useState(10); //for countdown


  useEffect(() => {
    console.log("Festival App Rendered"); //runs after every render
  }); //no dependencies


  useEffect(() => {
    alert("Welcome to Diwali Festival App"); //runs only on first load //alert msg comes twice as it is in development stage,react18 does it to detect sideeffects
  }, []); //empty dependencies


  useEffect(() => {
    console.log("Festival changed to:", festival);
  }, [festival]); // runs whenever 'festival' changes
//dependency added 'festival'


  useEffect(() => {
    const timer = setInterval(() => {  //timer to decrement the count value
      setCountdown((prev) => prev - 1);  //it decrements the count value
    }, 1000);

    // cleanup when component unmounts
    return () => {           //when the component is unmounted,the timer is cleared else memory leak issues arise
      clearInterval(timer);
      console.log("Timer cleared"); //shows this when we refresh the app
    };
  }, []);

 
  useEffect(() => {
    console.log("Festival or Countdown changed!", festival, countdown);
  }, [festival, countdown]);  //multiple dependencies so it renders when festival or countdown changes

  return (
    <div style={{ textAlign: "center", marginTop: "30px" }}>
      <h1>Festival React App</h1>
      
      <h3>Current Festival: {festival}</h3>
      <button onClick={() => setFestival("Diwali")}>Diwali</button>  {/*Inline Arrow Function */}
      <button onClick={() => setFestival("Holi")}>Holi</button>
      <button onClick={() => setFestival("Pongal")}>Pongal</button>

      <h2>Countdown: {countdown}</h2> {/*we can observe the countdown here */}
   <hr/>
    </div>
  );
}

export default FestivalApp;

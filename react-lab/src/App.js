
import './App.css';
import GroceryList from "./Assignments/GroceryList";
import Car from "./Assignments/CarDetails";
import PhoneDetails from "./Assignments/PhoneDetails"; 
import Electronics from "./Assignments/Electronics"; 
import JuiceList from "./Assignments/Juice/JuiceList"; 
import SweetsList from "./Assignments/SweetList";
import CanteenMenu from './Assignments/Canteen/CanteenMenu';
import Restaurant from './Assignments/Restaurant/Restaurant';
import TempleList from './Assignments/TempleList';
import TailorShop from './Assignments/Tailor/TailorShop';
import Fruits from './Assignments/Fruits';
import TelevisionManager from './Assignments/TelevisionManager';
import MarriageForm from './Assignments/MarriageForm';
import AccessoriesForm from './Assignments/AccessoriesForm';
import BakingForm from './Assignments/BakingForm';
import App1 from './Assignments/FlightBookingForm';
import MovieForm_MainApp from './Assignments/MovieFormMainApp';
import App2 from './Assignments/ElectronicProductDetails'
import Furniture from './Assignments/SelectFurniture';
import FestivalApp from './Assignments/FestivalReact';
import RestaurantForm from './Assignments/RestaurantUseEffectForm'
import Communication from './Assignments/PArentChildSiblingCommunication';
import ChessTournamentForm from './Assignments/ChessTournamentForm';
import HockeyTournamentForm from './Assignments/HockeyTournamentForm';
import TailoringInventory from './Assignments/TailoringInventoryAxios';
import PlayerManagerForm from './Assignments/FootballPlayerFormCRUD';



function App() {
  let groceries = ["Rice", "Eggs", "Sugar", "Salt"];

  return (
    <div style={{ padding: "20px" , margin: "auto", maxWidth: "800px", textAlign: "center"}}>
      <h1>React Assignments</h1>
      <hr/>
       
       <GroceryList items={groceries} />
       <Car brand="Hyundai" model="i20" color="White" year="2016" />
       <PhoneDetails />
       <Electronics />
       <JuiceList />
       <SweetsList />
       <CanteenMenu />
       <Restaurant/>
       <TempleList />
       <TailorShop />
       <Fruits/>
       <TelevisionManager />
       <MarriageForm />
       <AccessoriesForm />
       <BakingForm />
       <App1 />
       <MovieForm_MainApp/>
       <App2/>
       <Furniture/>
       <FestivalApp/>
       <RestaurantForm/>
       <Communication/>
       <ChessTournamentForm/>
       <HockeyTournamentForm/>
       <TailoringInventory/>
       <PlayerManagerForm />

  </div>
  );
}

export default App;

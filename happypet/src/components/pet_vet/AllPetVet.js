import { Link } from "react-router-dom";
import AllPetVetCards from "./AllPetVetCards";
import Bottom from "../Bottom";
const AllPetVet = () => {
  return (
    <>
      <button type="button" class="btn btn-light">
        <Link to="/saveveterinary">Register As Veterinary</Link>
      </button>
      <div>
        <AllPetVetCards />
      </div>
      
    <Bottom/>
     
    </>
  );
};

export default AllPetVet;

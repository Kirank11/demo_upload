import PetCareTakerCards from "./PetCareTakerCards";
import { Link } from "react-router-dom";
import Bottom from "../Bottom";

const AllPetCaretaker = () => {
  return (
    <>
       <button type="button" class="btn btn-light">
        <Link to="/savepetcaretaker">Register As Pet Caretakers</Link>
      </button> 
      <div>
        <PetCareTakerCards />
      </div>
      <Bottom/>
    </>
  );
};

export default AllPetCaretaker;

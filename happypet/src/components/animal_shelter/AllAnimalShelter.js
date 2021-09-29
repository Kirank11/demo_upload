import AnimalShelterCards from "./AnimalShelterCards";
import { Link } from "react-router-dom";
import Bottom from "../Bottom";

const AllAnimalShelter = () => {
  return (
    <>
      <button type="button" class="btn btn-light">
        <Link to="/saveanimalshelter">Register As Animal Shelter</Link>
      </button>
      <div>
        <AnimalShelterCards />
      </div>
      <Bottom/>
    </>
  );
};

export default AllAnimalShelter;

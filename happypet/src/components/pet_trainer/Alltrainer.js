
import TrainerCards from "./TrainerCards";
import { Link } from "react-router-dom";
import Bottom from "../Bottom";


const Alltrainer = () => {
  return (
    <>
      <button type="button" class="btn btn-light">
        <Link to="/savetrainer">Register As  Trainer</Link>
      </button>
      <div>
        <TrainerCards />
      </div>
      <Bottom/>
    </>
  );
};

export default Alltrainer;

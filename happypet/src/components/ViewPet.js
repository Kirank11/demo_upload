import axios from "axios";
import React, { Component } from "react";
import Pet from "./pets";
import Bottom from "./Bottom";
import PetRow from "./PetRow";

class ViewPet extends Component {
  constructor(props) {
    super(props);
    this.state = { object: [] };
    this.getData();
  }

  getData = () => {
    const sess = sessionStorage.getItem("user");
    const loggedInUser = JSON.parse(sess);
    axios
      .get("http://localhost:8080/api/pets/viewpets",{
          id:loggedInUser.id,
      })
      .then((response) => {
        console.log(" before backend data");
        console.log(response.data);
        this.setState({ object: response.data });
      });
  };

  render() {
    var dis = [];
    var i=0;
    for (const iterator of this.state.object) {
      if(i==0)
      {
        var pets = new Array();
      }
      console.log(iterator);
      pets.push(<Pet pet={iterator} />);
      i=i+1;
      if(i==2)
      {
        dis.push(<PetRow pets={pets}/>);
        i=0;
      }
    }

    return (
      <>
      <div className="container-fluid">{dis.map((value) => {
            return value;
          })}</div>
          
        
        {/* <Bottom/> */}
      </>
    );
  }
}
export default ViewPet;

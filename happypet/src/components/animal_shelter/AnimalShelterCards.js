import axios from "axios";
import React, { Component } from "react";
import AnimalShelter from "./AnimalShelter";

class AnimalShelterCards extends Component {
  constructor(props) {
    super(props);
    this.state = { object: [] };
    this.getData();
  }

  getData = () => {
    axios
      .get("http://localhost:8080/api/animalshelter/allanimalshelter")
      .then((response) => {
        console.log(" before backend data");
        this.setState({ object: response.data });
      });
  };

  render() {
    var dis = [];
    for (const iterator of this.state.object) {
      console.log(iterator);
      dis.push(<AnimalShelter shelter={iterator} />);
    }

    return (
      <div>
        {dis.map((value) => {
          return value;
        })}
      </div>
    );
  }
}
export default AnimalShelterCards;

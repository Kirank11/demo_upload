import React, { Component } from "react";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";

class Veterinary extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <>
        <div className="container">
          <div class=" row">
            <Card style={{ width: "18rem" }}>
              <Card.Img
                variant="top"
                src="https://www.humanesociety.org/sites/default/files/styles/1240x698/public/2018/06/kittens-in-shelter-69469.jpg?h=ece64c50&itok=tOiKeqHY"
              />
              <Card.Body>
                <Card.Title>Vet:{this.props.vet.name}</Card.Title>
                <Card.Title>Hospital:{this.props.vet.hospital_name}</Card.Title>
                <Card.Text>
                  <b>Address : {this.props.vet.address}</b>
                </Card.Text>
                <b>Phone No : {this.props.vet.phone}</b>
              </Card.Body>
            </Card>
          </div>
        </div>
      </>
    );
  }
}
export default Veterinary;

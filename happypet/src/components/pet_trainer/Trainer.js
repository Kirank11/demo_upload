import React, { Component } from "react";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";

class Trainer extends Component {
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
                <Card.Title>Trainer:{this.props.trainer.name}</Card.Title>
                <Card.Title>Trainning Center:{this.props.trainer.center_name}</Card.Title>
                <Card.Text>
                  <b>Address : {this.props.trainer.address}</b>
                </Card.Text>
                <b>Phone No : {this.props.trainer.phone}</b>
              </Card.Body>
            </Card>
          </div>
        </div>
      </>
    );
  }
}
export default Trainer;

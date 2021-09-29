import React, { Component } from "react";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import GridList from "@material-ui/core/GridList"
class Pet extends Component {
  constructor(props) {
    super(props);
  }
  userCheck =() => {
    var sess = sessionStorage.getItem("user");
    console.log(sess);
    if(sess!=null)
    {
      sessionStorage.setItem("pet",JSON.stringify(this.props.pet));
      var pet_data=sessionStorage.getItem("pet");
      console.log("****************"+pet_data);
      window.location="/sellerinfo";
    }
    else
    {
      console.log("Login First");
      window.location="/loginreg";
    }
  }

  render() {
    return (
      <>
        <div className="container">
          <div class="col-sm-3" style={{float:"left"}}>
            {/* <p>Hello</p> */}
            <Card style={{ width: "18rem" }}>
              <Card.Img
                variant="top"
                src="https://images.unsplash.com/photo-1548199973-03cce0bbc87b?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cGV0fGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80"
              />
              <Card.Body>
                <Card.Title>{this.props.pet.breed}</Card.Title>
                <Card.Text>
                  Some quick example text to build on the card title and make up
                  the bulk of the card's content.
                </Card.Text>
                <Button variant="primary" onClick={this.userCheck}>Buy</Button>
              </Card.Body>
            </Card>
          </div>
        </div>
      </>
    );
  }
}
export default Pet;

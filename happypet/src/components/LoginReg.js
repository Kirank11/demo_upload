import React from 'react';
import Card from "react-bootstrap/Card";
import { Link } from "react-router-dom"
const LoginReg = () => {
    return(
        <div className="container">
            <Card style={{ width: '18rem' }}>
        <Card.Body>
            <Card.Title></Card.Title>
            <Card.Text>
            Please Login Or Register ......
            </Card.Text>
            <Card.Link ><Link
                to="/signup"
              >
                Registration
              </Link></Card.Link>
            <Card.Link ><Link
                to="/login"
              >
                Login
              </Link></Card.Link>
        </Card.Body>
        </Card>
        </div>
    );
}

export default LoginReg;
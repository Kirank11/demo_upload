import React, { Component } from 'react'

export default class PetRow extends Component {
    constructor(props){
        super(props);
    }
    render() {
        return (
            <div className="row">
                {this.props.pets.map((value)=>{
                    return value;
                })}
            </div>
        )
    }
}

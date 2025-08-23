import {Component} from "react";

//Class Component
class Car extends Component{

    render(){
        const {brand,model,color,year} =this.props; //Destructuring props
        return(
            <div>
                <h2>Car Details</h2>
                <p><strong>Brand:</strong> {brand}</p>
                <p><strong>Model:</strong> {model}</p>
                <p><strong>Color:</strong> {color}</p>
                <p><strong>Year:</strong>{year}</p>
                <hr/>
            </div>
            
        )
    }
}

export default Car;
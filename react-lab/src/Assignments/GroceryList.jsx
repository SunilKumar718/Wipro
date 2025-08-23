
{/* Functional Component*/}
function GroceryList({items}){
    
    return (
        <div style={{ padding: "20px", textAlign: "center" }}>
            <h2>Grocery List</h2>
            <ul style={{listStyleType: "none", padding: 0}}>
                {items.map( (item, index) =>(   //map Loops through the items array
                <li key={index}>{item}</li>
            ))
                }
            </ul>
            
            <button onClick = {() => 
                alert("Groceries Added to the Cart")} >Add to Cart</button>
                <hr/>
        </div>
    )
}

export default GroceryList;
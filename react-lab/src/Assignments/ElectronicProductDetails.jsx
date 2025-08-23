import { useState, useEffect } from "react";

//Loading Component
function LoadingComponent() {
  return <h2>Loading product details...</h2>;
}

//Error Component
function ErrorComponent() {
  return <h2>⚠️ Error fetching product details</h2>;
}

//Product Component
function ProductComponent({ product }) { //product acts as props here
  return (
    <div>
      <h2>{product.name}</h2>
      <p>Brand: {product.brand}</p>
      <p>
        Price: ₹{product.price} → 
        {product.price > 50000 ? " Premium Product" : " Budget Product"} {/*//ternary Operator*/}
      </p>
      <p>Category: {product.category}</p>
      <p>
        {product.warranty > 0                         //if warranty>0
          ? "Warranty: " + product.warranty + " years" //show warrenty
          : "No Warranty"}                            {/*else no warranty */}
      </p>
      <p>{product.availability ? "✅In Stock" : "❌ Out of Stock"}</p> {/*if true ,in stock else no stock */}
      <p>{product.category === "Laptop" ? "🎒 Free Laptop Bag Offer" : ""}</p>{/*if it is laptop,offer applicable,else nothing */}
    </div>
  );
}

// Main App Component
function App2() {
  // state variables
  const [loading, setLoading] = useState(true);   //shows loading initially
  const [error, setError] = useState(false);      //shows error if something fails
  const [product, setProduct] = useState(null);   //stores the product data

  // useEffect for API call
  useEffect(() => {  //runs after the component is rendered
    setTimeout(() => {  //delays by 2sec
      const isError =false; //initially false to load the page,then set true to show the error

      if (isError) {
        setError(true); //show error like something went wrong
      } else {
        // product data comes here
        setProduct({
          name: "MacBook",
          brand: "Apple",
          price: 200000,
          category: "Laptop",
          warranty: 2,
          availability: true,
        });
      }

      setLoading(false); // stop loading after 2 seconds
    }, 2000);
  }, []); //empty dependency (runs only once)

  // Decide what to show using ternary operators
  return (
    <div>
      {loading  //if loading is true
        ? <LoadingComponent />     //show loading
        : error                     //next check,if loading is false (if true)
        ? <ErrorComponent />       // show error if API fails
        : <ProductComponent product={product} /> //if both are false,show product details
      }             {/* //stored in project */}  
      <hr/>
    </div>
  );
}

export default App2;

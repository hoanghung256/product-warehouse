import logo from "./logo.svg";
import Products from "./pages/Products";
import PRODUCTS from "./data/products"
import "./App.css";

function App() {
  return (
    <div className="App">
      <div className="App-header">
        <Products productList={PRODUCTS.PRODUCTS}/>
      </div>
    </div>
  );
}

export default App;

import Products from "./components/Products";
import ProductDetail from "./components/ProductDetail";
import { Routes, Route } from "react-router-dom";
import { useState } from "react";
import InputForm from "./components/InputForm";

function App() {
  // This state use for set detail when click to product
  const [productDetail, setProductDetail] = useState(null);

  return (
    <div className="App">
      <Routes>
        <Route
          path="/"
          element={<Products setProductDetail={setProductDetail} />}
        />
        <Route
          path="/products/:productId"
          element={<ProductDetail product={productDetail} />}
        />
        <Route
          path="/form"
          element={<InputForm  />}
        />
      </Routes>
    </div>
  );
}

export default App;

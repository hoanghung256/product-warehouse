import Products from "./pages/Products";
import ProductDetail from "./pages/ProductDetail";
import { Routes, Route } from "react-router-dom";
import { useState } from "react";

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
      </Routes>
    </div>
  );
}

export default App;

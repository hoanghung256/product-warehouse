import Products from "./components/Products";
import ProductDetail from "./components/ProductDetail";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { useState } from "react";
import AddProductForm from "./components/AddProductForm";

function App() {
  // This state use for set detail when click to product
  const [productDetail, setProductDetail] = useState(null);

  return (
    <div className="App">
      {/** BrowserRouter declare that the project use routers */}
      <BrowserRouter>
        <Routes>
          <Route
            path="/"
            element={<Products setProductDetail={setProductDetail} />}
          />
          <Route
            path="/products/:productId"
            element={<ProductDetail product={productDetail} />}
          />
          <Route path="/addProduct" element={<AddProductForm />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;

import { useEffect, useState } from "react";
import PRODUCTS from "../data/products";

function Products({ productList }) {
  const [products, setProducts] = useState(productList);
  

  return (
    <div>
      {products.map((p) => (
        <div>
          <div>{p.name}</div>
          <div>{p.quantity}</div>
          <div>{p.price}</div>
          <div>{p.createDate}</div>
        </div>
      ))}
    </div>
  );
}

export default Products;

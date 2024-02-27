import { useEffect, useState } from "react"

function Products({ productList }) {
  const [products, setProducts] = useState(productList);
  
  useEffect(() => {

  }, [])

  return (
    <div>
      {products.map((p) => (
        <div key={p.id}>
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

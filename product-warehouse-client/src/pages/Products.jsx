import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";

function Products({ setProductDetail }) {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/products")
      .then((res) => {
        console.log(res.data);
        setProducts(res.data);
      })
      .catch((err) => console.log(err));
  }, []);

  return (
    <div className="container-fluid">
      <div className="row">
        {products &&
          products.map((p) => (
            <div key={p.id} className="col-6 col-md-4 col-lg-2">
              <div className="border border-dark rounded-1 mt-3">
                <Link
                  to={`products/${p.id}`}
                  className="nav-link"
                  onClick={() => setProductDetail(p)}
                >
                  <img
                    className="img-fluid"
                    src={p.imagePath}
                    alt="Product image"
                  />
                  <hr />
                  <div className="text-center">
                    <p>{p.name}</p>
                  </div>
                </Link>
              </div>
            </div>
          ))}
      </div>
    </div>
  );
}

export default Products;

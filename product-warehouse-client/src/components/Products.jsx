import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";

function Products({ setProductDetail }) {
  // Declare a state with init value is an array []
  const [products, setProducts] = useState([]);

  // UseEffect run finally when a component is rendered
  useEffect(() => {
    axios
      .get("/api/products") // The front part of url has been config at line 43 package.json
      .then((res) => {
        // then() run after front-end receive the response back from back-end
        setProducts(res.data);
      })
      .catch((err) => console.log(err));
  }, []); // Condition for useEffect run ([] mean useEffect only run 1 time)

  return (
    <div className="container-fluid">
      <div className="w-25">
        {/* Link is a component from react-router-dom using for navigate to another route*/}
        <Link to={"/addProduct"} className="btn btn-primary">
          Add
        </Link>
      </div>
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

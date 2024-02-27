import axios from "axios";
import { Link } from "react-router-dom";

function ProductDetail({ product }) {
  function handleDelete(productId) {
    axios
      .delete(`/api/products?id=${productId}`)
      .then((res) => console.log(res))
      .catch((err) => console.error(err));
  }

  return (
    <div className="mx-5">
      <div className="d-flex">
        {/* Redirect back to home (better UX) */}
        <Link to="/" className="text-dark">
          products
        </Link>
        <p>/ {product.name}</p>
      </div>
      <div className="d-flex mt-3">
        <div>
          <img src={product.imagePath} width="200px" alt="Product image" />
        </div>
        <div>
          <strong>Product name: {product.name}</strong>
          <div className="mx-2">
            <p>ID: {product.id}</p>
            <p>Quantity: {product.quantity}</p>
            <p>Price: {product.price}$</p>
          </div>
        </div>
      </div>
      <div>
        <button onClick={() => handleDelete(product.id)}>Delete</button>
        <button>Update</button>
      </div>
    </div>
  );
}

export default ProductDetail;

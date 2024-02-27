import { Link } from "react-router-dom";

function ProductDetail({ product }) {
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
          <img src={product.imagePath} width="200px" alt="Staff image" />
        </div>
        <div>
          <strong>Product name: {product.name}</strong>
          <div className="mx-2">
            <p>Quantity: {product.quantity}</p>
            <p>Price: {product.price}$</p>
          </div>
        </div>
      </div>
    </div>
  );
}

export default ProductDetail;

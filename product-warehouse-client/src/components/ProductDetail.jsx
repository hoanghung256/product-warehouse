import axios from "axios";
import { useState } from "react";
import { Link } from "react-router-dom";
import UpdateProductForm from "./UpdateProductForm";
import { toast } from "react-toastify";

function ProductDetail({ product }) {
  const [showForm, setShowForm] = useState(false);
  async function handleDelete(productId) {
    const res = await axios.delete(`/api/products?id=${productId}`);
    if (res.data.status === 0) {
      toast.success(res.data.result);
    } else {
      toast.error(res.data.result);
    }
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
        <button onClick={() => setShowForm(true)}>Update</button>
      </div>
      <div>
        {showForm === true ? <UpdateProductForm product={product} /> : ""}
      </div>
    </div>
  );
}

export default ProductDetail;

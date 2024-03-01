import axios from "axios";
import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import UpdateProductForm from "./UpdateProductForm";
import { toast } from "react-toastify";

function ProductDetail({ product }) {
  const [showForm, setShowForm] = useState(false);
  const [productDetail, setProductDetail] = useState(product);
  const navigate = useNavigate();
  async function handleDelete(productId) {
    const res = await axios.delete(`/api/products?id=${productId}`);
    if (res.data.status === 0) {
      toast.success(res.data.result);
      navigate("/");
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
        <p>/ {productDetail.name}</p>
      </div>
      <div className="d-flex mt-3">
        <div>
          <img
            src={productDetail.imagePath}
            width="200px"
            alt="Product image"
          />
        </div>
        <div>
          <strong>Product name: {productDetail.name}</strong>
          <div className="mx-2">
            <p>ID: {productDetail.id}</p>
            <p>Quantity: {productDetail.quantity}</p>
            <p>Price: {productDetail.price}$</p>
          </div>
        </div>
      </div>
      <div>
        <button onClick={() => handleDelete(productDetail.id)}>Delete</button>
        <button onClick={() => setShowForm(true)}>Update</button>
      </div>
      <div>
        {showForm === true ? (
          <UpdateProductForm
            product={product}
            setProductDetail={setProductDetail}
            setShowForm={setShowForm}
          />
        ) : (
          ""
        )}
      </div>
    </div>
  );
}

export default ProductDetail;

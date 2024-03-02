import { useState } from "react";
import { toast } from "react-toastify";
import axios from "axios";
import { Link } from "react-router-dom";

function AddProductForm() {
  const [data, setData] = useState({
    name: "",
    quantity: "",
    price: "",
  });

  async function handleAdd() {
    // React will wait for axios.post() response, then run the rest
    const res = await axios.post("/api/products", data); // Pass data like this call pass data in request body
    if (res.data.status === 0) {
      toast.success(res.data.result);
    } else {
      toast.error(res.data.result);
    }
  }

  return (
    <div className="d-flex flex-column">
      <Link to={"/"}>Home</Link>
      <label>Name</label>
      <input
        type="text"
        onChange={(e) => setData({ ...data, name: e.target.value })}
      />
      <label>Quantity</label>
      <input
        type="number"
        onChange={(e) => setData({ ...data, quantity: e.target.value })}
      />
      <label>Price</label>
      <input
        type="number"
        onChange={(e) => setData({ ...data, price: e.target.value })}
      />

      <button onClick={handleAdd}>Submit</button>
    </div>
  );
}

export default AddProductForm;

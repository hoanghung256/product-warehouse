import { useState } from "react";
import { toast } from "react-toastify";
import axios from "axios";

function UpdateProductForm({ product, setProductDetail, setShowForm }) {
  const [data, setData] = useState(product);

  async function handleUpdate() {
    const res = await axios.put(
      `/api/products?id=${data.id}&name=${data.name}&price=${data.price}&quantity=${data.quantity}`
    );

    if (res.data.status === 0) {
      toast.success("Update product successfully!");
      setProductDetail(data);
      setShowForm(false);
    } else {
      toast.error(res.data.result);
    }
  }

  return (
    <div className="d-flex flex-column">
      <label>Name</label>
      <input
        type="text"
        value={data.name}
        onChange={(e) => setData({ ...data, name: e.target.value })}
        disabled={false}
      />
      <label>Quantity</label>
      <input
        type="number"
        value={data.quantity}
        onChange={(e) => setData({ ...data, quantity: e.target.value })}
      />
      <label>Price</label>
      <input
        type="number"
        value={data.price}
        onChange={(e) => setData({ ...data, price: e.target.value })}
      />

      <button onClick={handleUpdate}>Update</button>
    </div>
  );
}

export default UpdateProductForm;

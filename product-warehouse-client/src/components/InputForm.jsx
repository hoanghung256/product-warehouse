import { useState } from "react";
import axios from "axios";

function InputForm({ action, setProducts }) {
  const [data, setData] = useState({
    name: "",
    quantity: "",
    price: "",
  });

  async function handleAdd() {
    axios
      .post(
        `/api/products?name=${data.name}&quantity=${data.quantity}&price=${data.price}`
      )
      .then((res) => {
        console.log(res.data);
      })
      .catch((err) => console.error(err));
  }

  function handleUpdate() {
    axios
      .put(
        `/api/products?name=${data.name}&quantity=${data.quantity}&price=${data.price}`
      )
      .then((res) => {
        console.log(res.data);
      })
      .catch((err) => console.error(err));
  }

  return (
    <div className="d-flex flex-column">
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

      {action === "add" ? (
        <button onClick={handleAdd}>Submit</button>
      ) : (
        <button onClick={handleUpdate}>Update</button>
      )}
    </div>
  );
}

export default InputForm;

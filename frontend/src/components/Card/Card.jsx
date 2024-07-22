import Button from "@/components/Button";
const Card = () => {
  return (
    <div className="card bg-base-300 w-96 shadow-xl">
      <figure>
        <img src="https://img.daisyui.com/images/stock/photo-1606107557195-0e29a4b5b4aa.webp" alt="Shoes" />
      </figure>
      <div className="card-body">
        <h2 className="card-title">Super Product</h2>
        <p>You should buy these!</p>
        <div className="card-actions">
          <Button text="Buy now" onClick={() => alert("Wow you bought that")} />
        </div>
      </div>
    </div>
  );
};

export default Card;

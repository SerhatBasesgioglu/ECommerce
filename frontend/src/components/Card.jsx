"use client";

import Button from "@/components/Button";
import Image from "next/image";
const Card = ({ product }) => {
  const imageUri = product.name.toLowerCase().replace(/ /g, "");
  return (
    <div className="card bg-base-300 w-56 m-4 p-2 shadow-xl flex">
      <figure>
        <Image src={`/images/${imageUri}.png`} alt="iphone" width="128" height="128" />
      </figure>
      <div className="card-body">
        <h2 className="card-title">{product.name}</h2>
        <p>{product.categoryName}</p>
        <p>{product.storeName}</p>
        <div className="card-actions">
          <Button text="Buy now" onClick={() => alert("Wow you bought that")} />
        </div>
      </div>
    </div>
  );
};

export default Card;

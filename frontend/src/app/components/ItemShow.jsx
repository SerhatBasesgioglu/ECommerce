import Card from "@/components/Card";
import { get } from "@/util/api";
const ItemShow = async () => {
  const productList = await get("/products");
  return (
    <>
      {productList.map((product, key) => (
        <Card product={product} key={key} />
      ))}
    </>
  );
};

export default ItemShow;

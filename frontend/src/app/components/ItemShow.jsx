import Card from "@/components/Card";
const ItemShow = () => {
  return [...Array(30).keys()].map((key) => <Card key={key} />);
};

export default ItemShow;

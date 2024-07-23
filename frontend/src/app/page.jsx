import Card from "@/components/Card";
import CategoryTab from "./components/CategoryTab";
import RightSide from "./components/RightSide";
import ItemShow from "./components/ItemShow";
const Home = () => {
  return (
    <div className="flex">
      <div className="flex-none w-1/5">
        <CategoryTab />
      </div>
      <div className="flex-none grid w-3/5 grid-cols-4">
        <ItemShow />
      </div>
      <div className="flex-none w-1/5">
        <RightSide />
      </div>
    </div>
  );
};

export default Home;

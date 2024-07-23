import Client from "./Client";
const { get } = require("@/util/api");

const Server = async () => {
  const categoryList = await get("/categories");
  return <Client categoryList={categoryList} />;
};

export default Server;

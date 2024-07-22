import Table from "@/components/Table";
import { get } from "@/util/api";

const UserList = async () => {
  const data = await get("/users");
  const userColumns = [
    { header: "Id", accessor: "id" },
    { header: "Email", accessor: "email" },
    { header: "Password", accessor: "password" },
  ];

  return <Table columns={userColumns} data={data} />;
};

export default UserList;

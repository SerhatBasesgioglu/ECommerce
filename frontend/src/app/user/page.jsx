import Table from "@/components/Table";

const UserList = async () => {
  const res = await fetch("http://172.26.230.6:8080/users");
  const data = await res.json();
  console.log(data);

  const userColumns = [
    { header: "Id", accessor: "id" },
    { header: "Email", accessor: "email" },
    { header: "Password", accessor: "password" },
  ];

  const userData = [
    {
      name: "Serhat",
      email: "serhat@gmail.com",
    },
    {
      name: "Serdar",
      email: "serdar@gmail.com",
    },
  ];

  return <Table columns={userColumns} data={data} />;
};

export default UserList;

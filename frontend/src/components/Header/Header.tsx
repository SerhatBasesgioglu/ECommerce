import Button from "@/components/Button";

const Header = () => {
  return (
    <div className="container mx-auto bg-red-400">
      <div className="flex justify-end">
        <Button text="Register" />
        <Button text="Login" />
      </div>
    </div>
  );
};

export default Header;

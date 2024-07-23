import Button from "@/components/Button";
import Link from "next/link";

const handleButtonClick = () => {
  alert("Hello world");
};

const Navbar = () => {
  return (
    <div className="navbar min-h-12 bg-base-200">
      <div className="flex-1">
        <Link href="/">
          <Button text="Logo" className="btn-secondary" />
        </Link>
      </div>
      <div className="flex-none">
        <Link href="/user">
          <Button text="User List" />
        </Link>
        <Link href="/auth/login">
          <Button text="Login" />
        </Link>
        <Link href="/auth/register">
          <Button text="Register" />
        </Link>
      </div>
    </div>
  );
};

export default Navbar;

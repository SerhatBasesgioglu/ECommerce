"use client";
import Button from "@/components/Button";

const LoginPage = () => {
  const submitLogin = () => {
    alert("You alerted these nuts");
  };
  return (
    <>
      <p>Login</p>
      <form action={submitLogin} className="items-center justify-center flex flex-col">
        <label className="input input-bordered flex items-center m-2">
          <input type="text" placeholder="Email" />
        </label>
        <label className="input input-bordered flex items-center m-2">
          <input type="text" placeholder="Password" />
        </label>
        <Button text="Login" type="submit" className="btn-md w-32 btn-secondary" />
      </form>
    </>
  );
};

export default LoginPage;

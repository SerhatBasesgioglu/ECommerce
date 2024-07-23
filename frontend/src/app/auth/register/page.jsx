import Button from "@/components/Button";

const RegisterPage = () => {
  return (
    <>
      <p>Register</p>
      <label className="input input-bordered flex items-center m-2">
        <input type="text" placeholder="Email" />
      </label>
      <label className="input input-bordered flex items-center m-2">
        <input type="text" placeholder="Password" />
      </label>
      <Button text="Register" className="btn-md w-32 btn-secondary" />
    </>
  );
};
export default RegisterPage;

const Button = ({ text }: { text: string }) => {
  let age: number | string;

  return (
    <>
      <button>{text}</button>
    </>
  );
};

export default Button;

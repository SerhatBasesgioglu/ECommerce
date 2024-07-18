"use client";

const Button = ({ text, onClick }) => {
  return (
    <div className="mx-1 my-1 bg-blue-400">
      <button onClick={onClick}>{text}</button>
    </div>
  );
};

export default Button;

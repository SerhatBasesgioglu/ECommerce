const Button = ({ text, onClick, className }) => {
  return (
    <div className={`btn btn-sm btn-primary mx-1 ${className}`}>
      <button onClick={onClick}>{text}</button>
    </div>
  );
};

export default Button;

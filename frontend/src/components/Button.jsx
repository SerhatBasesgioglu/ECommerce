const Button = ({ text, onClick, type, className }) => {
  return (
    <div className={`btn btn-sm btn-primary mx-1 ${className}`}>
      <button type={type} onClick={onClick}>
        {text}
      </button>
    </div>
  );
};

export default Button;

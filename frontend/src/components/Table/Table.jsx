const Table = ({ columns, data }) => {
  return (
    <table className="table table-zebra table-sm">
      <thead>
        <tr>
          {columns.map((column, key) => (
            <th key={key}>{column.header}</th>
          ))}
        </tr>
      </thead>
      <tbody>
        {data &&
          data.map((row, rowIndex) => (
            <tr key={rowIndex}>
              {columns.map((column, columnIndex) => (
                <td key={columnIndex}>{row[column.accessor]}</td>
              ))}
            </tr>
          ))}
      </tbody>
    </table>
  );
};

export default Table;

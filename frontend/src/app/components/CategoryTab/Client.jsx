"use client";
import Button from "@/components/Button";
const Client = ({ categoryList }) => {
  return (
    <>
      {categoryList.map((category, key) => (
        <div className="flex" key={key}>
          <Button
            text={category.name}
            onClick={() => {
              alert(`This is the category ${category.name} which is subcategory of ${category.parentCategoryName}`);
            }}
          />
        </div>
      ))}
    </>
  );
};

export default Client;

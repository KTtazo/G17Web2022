import classNames from "classnames";
import styles from "./style.module.scss";
function TextInput({
  labelFor,
  name,
  value,
  type,
  placeholder,
  onChange,
  className
}) {
  return (
    <div className={classNames(styles["text-input-container"], className)}>
      {name && <label htmlFor={labelFor}>{name}</label>}
      <input
        value={value}
        onChange={onChange}
        type={type}
        placeholder={placeholder}
      />
    </div>
  );
}
export { TextInput };

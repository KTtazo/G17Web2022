function TextInput({ labelFor, name, value, type, placeholder, onChange }) {
  return (
    <>
      <label htmlFor={labelFor}>{name}</label>
      <input
        value={value}
        onChange={onChange}
        type={type}
        placeholder={placeholder}
      />
    </>
  );
}
export { TextInput };

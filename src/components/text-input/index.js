import styles from './style.module.scss'
function TextInput({ labelFor, name, value, type, placeholder, onChange }) {

  return (
    <div className={styles['text-input-container']}>
      <label htmlFor={labelFor}>{name}</label>
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

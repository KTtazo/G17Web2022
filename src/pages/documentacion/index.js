import styles from "./style.module.scss";
function Documentacion() {
  return (
    <div className={styles["documentation-container"]}>
      <iframe src="https://docs.google.com/document/d/e/2PACX-1vQxE-j8QIp0x9mno9jhBPIlmpNPoQa6JqtIIkXz8ZZobCSJhmaCjRfnKiyOb60eAEHa1bGSi--98NJ1/pub?embedded=true"></iframe>
    </div>
  );
}

export { Documentacion };

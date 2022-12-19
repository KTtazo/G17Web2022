import styles from "./style.module.scss";

import { dummyDataOfertas } from "../../datos-mostrar/datos-ofertas";

function ListingsTable(props) {
  const table = dummyDataOfertas.map((item, index) => {
    return (
      <div className={styles["row"]} key={index}>
        <div>{item.companyName}</div>
        <div>{item.position}</div>
        {props.children}
      </div>
    );
  });
  return <div className={styles["table"]}>{table}</div>;
}
export { ListingsTable };

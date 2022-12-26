import styles from "./style.module.scss";

import { dummyDataOfertas } from "../../datos-mostrar/datos-ofertas";
import { Link } from "react-router-dom";
import { urlPaths } from "../../navigation/url-paths";

function ListingsTable(props) {
  const table = dummyDataOfertas.map((item, index) => {
    return (
      <Link
        to={`${urlPaths.information}/${item.id}`}
        className={styles["row"]}
        key={index}
      >
        <div className={styles["company-name"]}>{item.companyName}</div>
        <div className={styles["position"]}>{item.position}</div>
        {props.children}
      </Link>
    );
  });

  return <div className={styles["table"]}>{table}</div>;
}
export { ListingsTable };

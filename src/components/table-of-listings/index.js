import styles from "./style.module.scss";
import { Link } from "react-router-dom";
import { urlPaths } from "../../navigation/url-paths";
import {DatosOfertas} from "../../datos-mostrar/datos-ofertas.js";

function ListingsTable(props) {

  const table = DatosOfertas().map((item, index) => {
    return (
      <Link
        to={`${urlPaths.information}/${item.id}`}
        className={styles["row"]}
        key={index}
      >
        <div className={styles["company-name"]}>{item.name}</div>   //HE UTILIZADO DATOS RANDOM DE PRUEBA; HAY QUE CAMBIARLO
        <div className={styles["position"]}>{item.email}</div>
        {props.children}
      </Link>
    );
  });

  return <div className={styles["table"]}>{table}</div>;
}
export { ListingsTable };

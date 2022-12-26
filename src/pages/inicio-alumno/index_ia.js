import { ListingsTable } from "../../components/table-of-listings";
import { Link } from "react-router-dom";
import { urlPaths } from "../../navigation/url-paths";
import styles from "./style.module.scss";
function InicioAlumno() {
  return (
    <div>
      <ListingsTable />
      <ListingsTable />
      <Link className={styles["item"]} to={`${urlPaths.information}/1`}>
        Datos de Practicas{" "}
      </Link>
    </div>
  );
}

export { InicioAlumno };

import { ListingsTable } from "../../components/table-of-listings";
import { Link } from "react-router-dom";
import { urlPaths } from "../../navigation/url-paths";
import styles from "./style.module.scss";
function InicioAlumno() {
  return (
    <div>
      <ListingsTable />
      <ListingsTable />
    </div>
  );
}

export { InicioAlumno };

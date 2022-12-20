import { Link } from "react-router-dom";
import { urlPaths } from "../../url-paths";
import styles from "./style.module.scss";

function Header() {
  return (
    <header className={styles["header"]}>
      <Link className={styles["item"]} to={urlPaths.login}>
        Login
      </Link>
      <Link className={styles["item"]} to={urlPaths.register}>
        Register
      </Link>
      <Link className={styles["item"]} to={urlPaths.inicioAlumno}>
        Inicio{" "}
      </Link>
      <Link className={styles["item"]} to={`${urlPaths.datosGenerales}/`}>
        Datos generales{" "}
      </Link>
    </header>
  );
}

export { Header };

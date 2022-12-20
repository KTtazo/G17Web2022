import { Link } from "react-router-dom";
import { urlPaths } from "../../url-paths";
import styles from "./style.module.scss";
function Footer() {
  return (
    <footer className={styles["header"]}>
        <Link className={styles["item"]} to={urlPaths.login}>
          Login
        </Link>
        <Link className={styles["item"]} to={urlPaths.register}>
          Register
        </Link>
        <Link className={styles["item"]} to={urlPaths.inicioAlumno}>
          Inicio{" "}
        </Link>
        <Link className={styles["item"]} to={`${urlPaths.information}/1`}>
          test{" "}
        </Link>
        <Link className={styles["item"]} to={`${urlPaths.inicioTutor}/1`}>
          Inicio Tutor{" "}
        </Link>
        <Link className={styles["item"]} to={`${urlPaths.inicioResponsable}/1`}>
          Inicio Responsable{" "}
        </Link>
        <Link className={styles["item"]} to={`${urlPaths.datosPractica}/1`}>
          Datos de Practicas{" "}
        </Link>
    </footer>
  );
}

export { Footer };

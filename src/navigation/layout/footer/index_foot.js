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
          Inicio Alumno{" "}
        </Link>
        <Link className={styles["item"]} to={`${urlPaths.information}/1`}>
          Info Practicas{" "}
        </Link>
        <Link className={styles["item"]} to={`${urlPaths.inicioTutor}/`}>
          Inicio Tutor{" "}
        </Link>
        <Link className={styles["item"]} to={`${urlPaths.inicioResponsable}/`}>
          Inicio Responsable{" "}
        </Link>
        <Link className={styles["item"]} to={`${urlPaths.datosPractica}/`}>
          Datos de Practicas{" "}
        </Link>
    </footer>
  );
}

export { Footer };

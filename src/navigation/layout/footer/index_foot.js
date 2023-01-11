import { Link } from "react-router-dom";
import { urlPaths } from "../../url-paths";
import styles from "./style.module.scss";
function Footer() {
  return (
    <footer className={styles["footer"]}>
      <div className={styles["footer-section"]}>
        <div className={styles["title"]}>Enlaces importantes</div>
        <Link className={styles["item"]} to={urlPaths.login}>
          Login
        </Link>{" "}
        {/* <a
          href={"http://localhost:3000/login"} /////link here
          target={"_blank"}
          className={styles["item"]}
        ></a> */}
        <a
          href={
            "https://docs.google.com/document/d/1ZI-opdvpKlcesdfKXx0cXPMNkE-WHfpoTZErSlQWUGc/edit"
          } /////link here
          target={"_blank"}
          className={styles["item"]}
        >
          Documentación del trabajo
        </a>
      </div>
      <div className={styles["footer-section"]}>
        <div className={styles["title"]}>Trabajo realizado por</div>
        <div className={styles["item"]}>Diego Fernández Rueda</div>
        <div className={styles["item"]}>Elena Martin Naranjo</div>
        <div className={styles["item"]}>David Soler Vicén</div>
        <div className={styles["item"]}>Enrique Gutiérrez Velasco</div>
        <div className={styles["item"]}>Daniel Pastor Miguel</div>
      </div>

      {/*       
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
        </Link> */}
    </footer>
  );
}

export { Footer };

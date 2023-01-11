import { useContext } from "react";
import { Link } from "react-router-dom";
import AuthContext from "../../../store/auth-context";
import { urlPaths } from "../../url-paths";
import styles from "./style.module.scss";

function Header() {
  const { isLoggedIn, onLogout } = useContext(AuthContext);
  return (
    <header className={styles["header"]}>
      <div className={styles["left-section"]}>
        {!isLoggedIn ? (
          <>
            <Link className={styles["item"]} to={urlPaths.login}>
              Login
            </Link>

            <Link className={styles["item"]} to={urlPaths.register}>
              Register
            </Link>
          </>
        ) : (
          <>
            <Link className={styles["item"]} to={urlPaths.inicioAlumno}>
              Inicio
            </Link>
            <Link className={styles["item"]} to={urlPaths.nuevaOferta}>
              NuevaOferta
            </Link>
          </>
        )}
      </div>
      {isLoggedIn && (
        <div className={styles["right-section"]}>
          <Link className={styles["item"]} onClick={onLogout}>
            Cerrar sesión
          </Link>
        </div>
      )}
    </header>
  );
}

export { Header };

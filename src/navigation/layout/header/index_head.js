import { Link } from "react-router-dom";
import { urlPaths } from "../../url-paths";

function Header() {
  return (
    <header>
      <div>
        <Link to={urlPaths.login}>Login</Link>
        <Link to={urlPaths.register}>Register</Link>
        <Link to={urlPaths.inicioAlumno}>Inicio </Link>
      </div>
    </header>
  );
}

export { Header };

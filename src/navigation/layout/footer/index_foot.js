import { Link } from "react-router-dom";
import { urlPaths } from "../../url-paths";
function Footer() {
  return (
    <footer>
      <div>
        <Link to={urlPaths.login}>Login</Link>
        <Link to={urlPaths.register}>Register</Link>
        <Link to={urlPaths.inicioAlumno}>InicioAlumno </Link>
        <Link to={urlPaths.inicioTut}>InicioTutor </Link>
        <Link to={urlPaths.inicioResponsable}>InicioResponsable </Link>
        <Link to={urlPaths.datosPractica}>InicioPráctica </Link>
      </div>
    </footer>
  );
}

export { Footer };

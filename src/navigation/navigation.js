import { Route, Routes } from "react-router-dom";
import { Home } from "../pages/home/index_h";
import { Information } from "../pages/informacion";
import { InicioAlumno } from "../pages/inicio-alumno/index_ia";
import { InicioResponsable } from "../pages/inicio-responsable/index_ir";
import { InicioTutor } from "../pages/inicio-tutor/index_it";
import { Login } from "../pages/login";
import { Register } from "../pages/register";
import { urlPaths } from "./url-paths";
import { DatosGenerales } from "../pages/datos-generales/index_dg";

function Navigation() {
  return (
    <Routes>
      <Route path={urlPaths.home} element={<Home />} />
      <Route path={urlPaths.login} element={<Login />} />
      <Route path={urlPaths.register} element={<Register />} />
      <Route path={urlPaths.inicioAlumno} element={<InicioAlumno />} />
      <Route path={urlPaths.inicioTutor} element={<InicioTutor />} />
      <Route path={urlPaths.datosGenerales} element={<DatosGenerales/>}/>
      <Route
        path={urlPaths.inicioResponsable}
        element={<InicioResponsable />}
      />
      <Route path={`${urlPaths.information}/:id`} element={<Information />} />
      
    </Routes>
  );
}

export { Navigation };

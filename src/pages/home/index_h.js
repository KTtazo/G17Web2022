import { useContext, useState } from "react";
import { LoginForm } from "../../components/login/Login";
import AuthContext from "../../store/auth-context";
import { InicioAlumno } from "../inicio-alumno/index_ia";
function Home() {
  const { isLoggedIn } = useContext(AuthContext);

  return <>{!isLoggedIn ? <LoginForm /> : <InicioAlumno />}</>;
}

export { Home };

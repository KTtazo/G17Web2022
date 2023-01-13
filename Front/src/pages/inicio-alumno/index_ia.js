import { ListingsTable } from "../../components/table-of-listings";
import { useNavigate } from "react-router-dom";
import { urlPaths } from "../../navigation/url-paths";
import { useContext, useEffect } from "react";
import AuthContext from "../../store/auth-context";
function InicioAlumno() {
  const { isLoggedIn } = useContext(AuthContext);

  const navigate = useNavigate();

  useEffect(() => {
    if (!isLoggedIn) {
      navigate(urlPaths.home);
    }
  }, [isLoggedIn]);

  return (
    <div>
      <ListingsTable />
      <ListingsTable />
    </div>
  );
}

export { InicioAlumno };

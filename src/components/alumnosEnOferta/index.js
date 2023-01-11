import { Button } from "../button/button";
import styles from "./style.module.scss";
import { ListingsTable } from "../../components/table-of-listings"; 
function aceptadosInformacion(props) {
  const handleSubmit = (e) => {
    e.preventDefault();
  };
  return (
    <div className={styles["oferta-info-container"]}>
      <ListingsTable />
      <ListingsTable />
      <Button
        className={styles["button"]}
        onButtonClick={handleSubmit}
        type="submit"
      >
        Inicio automático de selección de alumnos
      </Button>
    </div>
  );
}
export { OfertaInformacion };

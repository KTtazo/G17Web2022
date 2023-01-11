import { Button } from "../button/button";
import styles from "./style.module.scss";
 
function OfertaInformacion(props) {
  const handleSubmit = (e) => {
    e.preventDefault();
  };
  return (
    <div className={styles['oferta-info-container']}>
      <div> {props.data.companyName}</div>
      <div> {props.data.position}</div>
      <div> {props.data.info}</div>
      <Button className={styles['button']} onButtonClick={handleSubmit} type="submit">
        Inscribirse en la oferta
      </Button>
    </div>
  );
}
export { OfertaInformacion };

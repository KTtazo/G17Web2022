import { Button } from "../button/button";
import styles from "./style.module.scss";
 
function OfertaInformacion(props) {
  const handleSubmit = (e) => {
    e.preventDefault();
   
   const requestBody = {
      id_oferta: props.data.id,
      //id_alumno: ???????????????????????????????                   //NO SE COMO OBTENER EL ID DEL ALUMNO QUE QUIERE INSCRIBIRSE A LA OFERTA
    };

    fetch("http://localhost:8080/alumno/urlServlet", {               //HAY QUE PONER LA URL DEL SERVLET
      headers: {
        "Content-Type": "application/json",
      },
      method: "post",
      body: JSON.stringify(requestBody),
    })

    .then((response) => {
      if(response.status === 200) {
        console.log("----Oferta seleccionada----");
      }else
        console.log("----Error al seleccionar oferta----");
    })
    .catch((message) => { 
      alert(message);
      console.log("----Error al seleccionar oferta----");
    });
  };
  return (
    <div className={styles['oferta-info-container']}>
      <div> {props.data.name}</div>                             //HE USADO DATOS DE PRUEBA RANDOM, HAY QUE CAMBIAR LOS CAMPOS
      <div> {props.data.email}</div>
      <div> {props.data.status}</div>
      <Button className={styles['button']} onButtonClick={handleSubmit} type="submit">
        Inscribirse en la oferta
      </Button>
    </div>
  );
}
export { OfertaInformacion };

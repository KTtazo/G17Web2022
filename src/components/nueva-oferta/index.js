import { useState } from "react";
import { TextInput } from "../text-input";
import styles from "./style.module.scss";
function NuevaOfertaForm() {
  const [titulo, setTitulo] = useState("");
  const [turnos, setTurnos] = useState();
  const [semanas, setSemanas] = useState();
  return (
    <div className={styles["nueva-oferta-container"]}>
      <h1>Nueva Oferta</h1>

      <TextInput
        value={titulo}
        type={"text"}
        placeholder={"Titulo de posicion"}
        onChange={(e) => setTitulo(e.target.value)}
      />
      <TextInput
        value={turnos}
        type={"numero"}
        placeholder={"Turnos"}
        onChange={(e) => setTurnos(e.target.value)}
      />
      <TextInput
        value={semanas}
        type={"numero"}
        placeholder={"Semanas"}
        onChange={(e) => setSemanas(e.target.value)}
      />
    </div>
  );
}

export { NuevaOfertaForm };

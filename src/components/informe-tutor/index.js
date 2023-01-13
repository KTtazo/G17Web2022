import { useState } from "react";
import { TextInput } from "../text-input";
import styles from "./style.module.scss";
import { Button } from "../button/button";

function InformeTutorForm() {
  const [alumno, setAlumno] = useState("");
  const [nota, setNota] = useState();
  const [info, setInfo] = useState("");
  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(alumno);
    console.log(nota);
    console.log(info);
  };
  return (
    <div className={styles["nueva-oferta-container"]}>
      <h1>Generar informe</h1>

      <TextInput
        value={alumno}
        type={"text"}
        placeholder={"Alumno"}
        onChange={(e) => setAlumno(e.target.value)}
      />
      <TextInput
        value={nota}
        type={"numero"}
        placeholder={"Nota"}
        onChange={(e) => setNota(e.target.value)}
      />
      <TextInput
        value={info}
        type={"text"}
        placeholder={"Informacion y notas"}
        onChange={(e) => setInfo(e.target.value)}
      />
      <Button type="submit" onButtonClick={handleSubmit}>
        Generar informe
      </Button>
    </div>
  );
}

export { InformeTutorForm };

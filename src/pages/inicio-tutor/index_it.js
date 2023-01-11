import { ListingsTable } from "../../components/table-of-listings";
import { Button } from "../../components/button/button";
import React, { useContext, useState } from "react";
import { urlPaths } from "../../navigation/url-paths";
import styles from "./style.module.scss";
import { Link, useNavigate } from "react-router-dom";

function InicioTutor() {
  const navigate = useNavigate();
  return (
    <div>
      <ListingsTable />
      <ListingsTable />
      <div className={styles["buttons"]}>
        <Button
          onButtonClick={() => {
            navigate(urlPaths.nuevaOferta);
          }}
          className={styles["button"]}
        >
          Añadir oferta
        </Button>
        <Button
          onButtonClick={() => {
            navigate(urlPaths.register);
          }}
          className={styles["button"]}
        >
          Registro de nuevo tutor
        </Button>
        <Button
          onButtonClick={() => {
            navigate(urlPaths.informeTutor);
          }}
          className={styles["button"]}
        >
          Generar informe sobre alumno
        </Button>
      </div>
    </div>
  );
}

export { InicioTutor };

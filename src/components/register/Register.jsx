import React, { useState } from "react";
import { useContext } from "react";
import AuthContext from "../../store/auth-context";
import { Button } from "../button/button";
import { TextInput } from "../text-input";
import styles from "./style.module.scss";

export const RegisterForm = (props) => {
  const [email, setEmail] = useState("");
  const [pass, setPass] = useState("");
  const [name, setName] = useState("");
  const { onLogin } = useContext(AuthContext);

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(email);
    onLogin(email, pass);
    
    const requestBody = {
      email: email,
      password: pass,
      name: name
    };

    fetch("http://localhost:8080/urlServlet", {           //HAY QUE PONER LA URL DEL SERVLET
      headers: {
        "Content-Type": "application/json",
      },
      method: "post",
      body: JSON.stringify(requestBody),
    })

    .then((response) => {
      if(response.status === 200) {
        console.log("----Registration succesfull----");
      }else
        console.log("----Registration failed----");
    })
    .catch((message) => { 
      alert(message);
      console.log("----Registration failed----");
    });
  };
  return (
    <div className={styles["auth-form"]}>
      <form className={styles["register-form"]} onSubmit={handleSubmit}>
        <h1>
          Registro de tutor
        </h1>
        <TextInput
          labelFor={"nombre"}
          name={"Nombre"}
          value={name}
          type={"text"}
          placeholder={"Tu nombre"}
          onChange={(e) => setName(e.target.value)}
        />
        <TextInput
          labelFor={"email"}
          name={"Email"}
          value={email}
          type={"email"}
          placeholder={"example@gmail.com"}
          onChange={(e) => setEmail(e.target.value)}
        />
        <TextInput
          labelFor={"password"}
          name={"Contraseña"}
          value={pass}
          type={"password"}
          placeholder={"******"}
          onChange={(e) => setPass(e.target.value)}
        />

        <Button type="submit" onButtonClick={handleSubmit}>
          Registrar
        </Button>
      </form>
    </div>
  );
};

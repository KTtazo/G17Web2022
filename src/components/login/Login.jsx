import React, { useContext, useState } from "react";
import { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { urlPaths } from "../../navigation/url-paths";
import AuthContext from "../../store/auth-context";
import { Button } from "../button/button";
import { TextInput } from "../text-input";
import styles from "./login.module.scss";

export const LoginForm = (props) => {
  const { onLogin, isLoggedIn } = useContext(AuthContext);

  const navigate = useNavigate();

  useEffect(() => {
    if (isLoggedIn) {
      navigate(urlPaths.home);
    }
  }, [isLoggedIn]);

  // const [currentForm, setCurrentForm] = useState("login");

  const [email, setEmail] = useState("");
  const [pass, setPass] = useState("");
  // const [diego, setDiego] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(email);
    console.log(pass);
    onLogin(email, pass);
  };
  // const toggleForm = (formName) => {
  //   setCurrentForm(formName);
  // };

  return (
    <div className={styles["auth-form-container"]}>
      <form className={styles["login-form"]} onSubmit={handleSubmit}>
        <h1>
          Bienvenido al portal de prácticas de la universidad de Alcalá de
          Henares
        </h1>
        <TextInput
          labelFor={"email"}
          name={"Email"}
          value={email}
          type={"email"}
          placeholder={"example@gmail.com"}
          onChange={(e) => setEmail(e.target.value)}
          className={styles["text-input"]}
        />
        {/* <TextInput
        labelFor={'diego'}
        name={'text'}
        value={diego}
        type={'text'}
        placeholder={'yo look at this'}
        onChange={(e)=>{setDiego(e.target.value)}}/> */}
        {/* ctrl +/ */}
        <TextInput
          labelFor={"password"}
          name={"Contraseña"}
          value={pass}
          type={"password"}
          placeholder={"******"}
          onChange={(e) => setPass(e.target.value)}
          className={styles["text-input"]}
        />

        <div className={styles["buttons"]}>
          <Button onButtonClick={handleSubmit} type="submit">
            Log In
          </Button>

          <Button
            onButtonClick={() => {
              navigate(urlPaths.register);
            }}
            className={styles["button"]}
          >
            Register
          </Button>
        </div>
      </form>
    </div>
  );
};

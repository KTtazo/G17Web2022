import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { urlPaths } from "../../navigation/url-paths";
import { Button } from "../button/button";
import { TextInput } from "../text-input";
import styles from "./login.module.scss";

export const LoginForm = (props) => {
  const [currentForm, setCurrentForm] = useState("login");

  const [email, setEmail] = useState("");
  const [pass, setPass] = useState("");
  const [diego, setDiego] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(email);
    console.log(pass);
  };

  const toggleForm = (formName) => {
    setCurrentForm(formName);
  };

  const navigate = useNavigate();
  return (
    <div className={styles["auth-form-container"]}>
      <form className={styles["login-form"]} onSubmit={handleSubmit}>
        <h1>Bienvenido al portal de prácticas</h1>
        <h1>de la universidad de Alcalá de Henares</h1>
        <TextInput
          labelFor={"email"}
          name={"Email"}
          value={email}
          type={"email"}
          placeholder={"example@gmail.com"}
          onChange={(e) => setEmail(e.target.value)}
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
          name={"Password"}
          value={pass}
          type={"password"}
          placeholder={"******"}
          onChange={(e) => setPass(e.target.value)}
        />

        <div className={styles["buttons"]}>
          <button type="submit">Log In</button>
          <Link className={styles["item"]} to={`${urlPaths.register}/`}>
            test{" "}
          </Link>
          <Button
            onButtonClick={() => {
              navigate(urlPaths.register);
            }}
            className={styles["button"]} ///you can modify the style in the scss file, under .button
          >
            Register
          </Button>
        </div>
      </form>
    </div>
  );
};

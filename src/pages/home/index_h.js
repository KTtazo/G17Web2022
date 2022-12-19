import { useState } from "react";
import { LoginForm } from "../../components/login/Login";
import { RegisterForm } from "../../components/register/Register";
function Home() {
  const [currentForm, setCurrentForm] = useState("login");

  const toggleForm = (formName) => {
    setCurrentForm(formName);
  };
  return (
    <>
      {
        //(ternary operator)check if condition is true(first statement) else (second)
        currentForm === "login" ? (
          <LoginForm onFormSwitch={toggleForm} />
        ) : (
          <RegisterForm />
        )
      }
    </>
  );
}

export { Home };

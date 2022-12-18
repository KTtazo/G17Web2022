import React,{useState} from "react";
import logo from './logo.svg';
import './App.css';
import {Login} from "./Login";
import {Register} from "./Register";


function App() {
  const[currentForm, setCurrentForm]=useState('login');

  const toggleForm=(formName)=>{
    setCurrentForm (formName);
  }
  return (
    <div className='="App'>
      {
      //(ternary operator)check if condition is true(first statement) else (second)
        currentForm==="login"? <Login onFormSwitch={toggleForm}/> : <Register/>
      }
    </div>
    
  );
}

export default App;

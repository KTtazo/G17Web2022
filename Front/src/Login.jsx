import React,{useState} from "react";

export const Login = (props) => {
    const [email, setEmail] = useState('');
    const [pass, setPass] = useState('');

    const handleSubmit=(e)=>{
        e.preventDefault();
        console.log(email);
    }

    return(
        <div className="auth-form-container">
            <form className="login-form" onSubmit={handleSubmit}>
                <label htmlFor="email">Email</label>
                <input value={email} onChange={(e) => setEmail(e.target.value)} type="email" placeholder="example@gmail.com"/>
                <label htmlFor="password">Contraseña</label>
                <input value={pass} onChange={(e)=>setPass(e.target.value)} type="password" placeholder="********"/>
                <button type="submit">Log In</button>
            </form>
            <button onClick={() => props.onFormSwitch('register')}>Registro de tutor</button>
        </div>
        
    )
    
}
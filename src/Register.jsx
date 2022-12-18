import React,{useState} from "react";

export const Register = (props) => {
    const [email, setEmail] = useState('');
    const [pass, setPass] = useState('');
    const [name, setName] = useState('');

    const handleSubmit=(e)=>{
        e.preventDefault();
        console.log(email);
    }
    return(
        <div className="auth-form">
            <form className="register-form" onSubmit={handleSubmit}>
                <label htmlFor="nombre">Nombre</label>
                <input value={name} name="name" id="name" placeholder="nombre"/>
                <label htmlFor="email">Email</label>
                <input value={email} onChange={(e) => setEmail(e.target.value)} type="email" placeholder="example@gmail.com"/>
                <label htmlFor="password">Contraseña</label>
                <input value={pass} onChange={(e)=>setPass(e.target.value)} type="password" placeholder="********"/>
                <button type="submit">Registrar</button>
            </form>
        </div>
    )
}
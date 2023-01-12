import React, {useState, useEffect} from "react";

function DatosOfertas() {

  const [ofertas, setOfertas] = useState([])

  const obtenerOfertas = async() => {
    const response = await fetch("https://gorest.co.in/public/v2/users")     //DATOS DE PRUEBA, HAY QUE PONER LA URL DEL SERVLET
    const dataOfertas = await response.json()
    setOfertas(dataOfertas)
  }

  useEffect( () => {
    obtenerOfertas()
  }, [])

  return ofertas
}

export {DatosOfertas};



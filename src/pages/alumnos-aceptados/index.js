import { useParams } from "react-router";
import { NotFound } from "../../components/not-found";
import { aceptadosInformacion } from "../../components/alumnosEnOferta";


import { dummyDataOfertas } from "../../datos-mostrar/datos-ofertas";

function alumnosAceptados() {
  const { id } = useParams();

  const data = dummyDataOfertas.filter((item) => {  //cambiar el tipo de data
    return item.id == id;
  });

  return (
    <>
      {data && (data[0] ? <aceptadosInformacion data={data[0]} /> : <NotFound />)}
    </>
  );
}

export { alumnosAceptados };

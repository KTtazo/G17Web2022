import { useParams } from "react-router";
import { NotFound } from "../../components/not-found";
import { OfertaInformacion } from "../../components/oferta-informacion";

import { dummyDataOfertas } from "../../datos-mostrar/datos-ofertas";

function Information() {
  const { id } = useParams();

  const data = dummyDataOfertas.filter((item) => {
    return item.id == id;
  });

  return (
    <>
      {data && (data[0] ? <OfertaInformacion data={data[0]} /> : <NotFound />)}
    </>
  );
}

export { Information };

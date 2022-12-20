function OfertaInformacion(props) {
  return (
    <div>
      <div> {props.data.companyName}</div>
      <div> {props.data.position}</div>
      <div> {props.data.info}</div>
    </div>
  );
}
export { OfertaInformacion };

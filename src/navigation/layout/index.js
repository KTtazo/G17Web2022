import { Footer } from "./footer/index_foot";
import { Header } from "./header/index_head";
import styles from "./style.module.scss";

function Layout({ children, ...props }) {
  return (
    <>
      <Header />
      main
      <main className={styles["main"]}>{children}</main>
      <Footer />
    </>
  );
}

export { Layout };

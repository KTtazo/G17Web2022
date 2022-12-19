import React from "react";
import "./App.css";
import { Navigation } from "./navigation/navigation";
import { Layout } from "./navigation/layout";

function App() {
  return (
    <div className='="App'>
      <Layout>
        <Navigation />
      </Layout>
    </div>
  );
}

export default App;

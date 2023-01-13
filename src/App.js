import React from "react";
import "./App.css";
import { Navigation } from "./navigation/navigation";
import { Layout } from "./navigation/layout";
import { AuthContextProvider } from "./store/auth-context";

function App() {
  return (
    <div className='="App'>
      <AuthContextProvider>
        <Layout>
          <Navigation />
        </Layout>
      </AuthContextProvider>
    </div>
  );
}

export default App;

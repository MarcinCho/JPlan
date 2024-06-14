import "./App.css";
import { Footer } from "./models/NavbarAndFooter/Footer";
import { Navbar } from "./models/NavbarAndFooter/Navbar";

export const App = () => {
  return (
    <>
      <Navbar />
      <div>
        <h1>Hello</h1>
      </div>
      <Footer />
    </>
  );
};

import "./App.css";
import { HomePage } from "./layouts/HomePage/HomePage";
import { Footer } from "./layouts/NavbarAndFooter/Footer";
import { Navbar } from "./layouts/NavbarAndFooter/Navbar";
import { Route, Routes } from "react-router-dom";
import { CompanyList } from "./layouts/Company/CompanyList";
import { Login } from "./layouts/Login/Login";

export const App = () => {
  return (
    <div>
      <Navbar />
      <div className="flex-grow-1">
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/companies" element={<CompanyList />} />
          <Route path="/login" element={<Login />} />
        </Routes>
      </div>
      <Footer />
    </div>
  );
};
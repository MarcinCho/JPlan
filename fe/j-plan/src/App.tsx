import "./App.css";
import { HomePage } from "./layouts/HomePage/HomePage";
import { Footer } from "./layouts/NavbarAndFooter/Footer";
import { Navbar } from "./layouts/NavbarAndFooter/Navbar";
import { Route, Routes } from "react-router-dom";
import { CompanyList } from "./layouts/Company/CompanyList";

export const App = () => {
  return (
    <div>
      <Navbar />
      <div className="flex-grow-1">
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/companies" element={<CompanyList />} />
        </Routes>
      </div>
      <Footer />
    </div>
  );
};

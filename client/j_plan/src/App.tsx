import React from "react";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { Login } from "./components/Login";
import { Route, Routes } from "react-router-dom";
import { Home } from "./components/Home";
import { Register } from "./components/Register";
import { Profile } from "./components/Profile";
import { Navbar } from "./components/Additionals/Navbar";
import { Footer } from "./components/Additionals/Footer";
import { About } from "./components/Additionals/About";
import { Company } from "./components/Company/Company";
import { CompanyList } from "./components/Company/CompanyList";
import { TimeCard } from "./components/TimeCard/TimeCard";
import { NewTimeCard } from "./components/TimeCard/NewTimeCard";

export const App: React.FC = () => {
  return (
    <div>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/profile" element={<Profile />} />
        <Route path="/about" element={<About />} />
        <Route path="/companies" element={<CompanyList />} />
        <Route path="/timecard" element={<NewTimeCard />} />
      </Routes>
      <Footer />
    </div>
  );
};

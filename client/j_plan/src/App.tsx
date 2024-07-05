import React from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Login } from './components/Login';
import { Route, Routes } from 'react-router-dom';
import Home from './components/Home';
import { Register } from './components/Register';
import { Profile } from './components/Profile';

export const App: React.FC = () => {
  return (
    <div>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/profile" element={<Profile />} />
      </Routes>
    </div>
  );
};


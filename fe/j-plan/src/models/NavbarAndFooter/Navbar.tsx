import { NavLink } from "react-router-dom";
// import { useOktaAuth } from "@okta/okta-react";
// import { SpinnnerLoading } from "../Utils/SpinnerLoading";
import React from "react";

export const Navbar = () => {
  //   const { oktaAuth, authState } = useOktaAuth();

  //   if (!authState) {
  //     return <SpinnnerLoading />;
  //   }

  //   const handleLogout = async () => oktaAuth.signOut();

  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
      <div className="container-fluid">
        <span className="navbar-brand">What2read.dev</span>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNavDropdown"
          aria-controls="navbarNavDropdown"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNavDropdown">
          <ul className="navbar-nav">
            <li className="nav-item">
              <NavLink className="nav-link" to="/">
                Home
              </NavLink>
            </li>
            {/* <li className="nav-item">
              <a className="nav-link" href="#">
                About
              </a>
            </li> */}
            <li className="nav-item">
              <NavLink className="nav-link" to="/search">
                Search books
              </NavLink>
            </li>
          </ul>
          <ul className="navbar_nav ms-auto">
            <li className="nav-item m-1">
              <NavLink
                type="button"
                className="btn btn-outline-light"
                to="/login"
              >
                Login
              </NavLink>
            </li>
            {/* {!authState.isAuthenticated ? (
              <li className="nav-item m-1">
                <NavLink
                  type="button"
                  className="btn btn-outline-light"
                  to="/login"
                >
                  Login
                </NavLink>
              </li>
            ) : (
              <li className="nav-item m-1">
                <button
                  className="btn btn-outline-light"
                  onClick={handleLogout}
                >
                  Log out
                </button>
              </li>
            )} */}
          </ul>
        </div>
      </div>
    </nav>
  );
};

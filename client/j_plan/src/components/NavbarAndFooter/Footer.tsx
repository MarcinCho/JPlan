import { Link } from "react-router-dom";

export const Footer = () => {
  return (
    <footer className="py-3 bg-dark footer fixed-bottom">
      <ul className="nav justify-content-center border-bottom pb-3 mb-3">
        <li className="nav-item">
          <Link className="nav-link px-2 text-white" to="/">
            Home
          </Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link px-2 text-white" to="/search">
            Companies
          </Link>
        </li>
      </ul>
      <p className="text-center text-body-secondary text-white">
        M.Chowaniec 2024
      </p>
    </footer>
  );
};

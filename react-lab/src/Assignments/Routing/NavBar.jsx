
import { Link } from "react-router-dom";

//Navbar functional Component using Bootstrap and  React Router
const Navbar = () => {
  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
      <div className="container">
        {/*Brand*/}
        <Link className="navbar-brand" to="/">Income Tax Portal</Link>

        {/*Toggler Button for Mobile */}
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        {/*
collapse navbar-collapse: Menu collapses on small screens.

id="navbarNav": Must match the toggle button’s data-bs-target.

me-auto: Bootstrap class for margin-end auto, pushes items left.
*/
}

        {/*Collapsible Menu */}
        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav ms-auto">
            {/* Each menu item */}

            {/*
            Each li.nav-item is a menu entry.

            Link.nav-link: React Router link styled as Bootstrap nav link.

            Clicking a link navigates without reloading the page.
            */}
            <li className="nav-item">
              <Link className="nav-link" to="/" end>Home</Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link" to="/add-taxpayer">Add Taxpayer</Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link" to="/taxpayer-list">Taxpayer List</Link>
            </li>
           
            <li className="nav-item">
              <Link className="nav-link" to="/tax-rates">Tax Rates</Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link" to="/contact">Contact</Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link" to="/about">About</Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link" to="/faq">FAQ</Link>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;

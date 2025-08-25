import { useNavigate } from "react-router-dom";
//useNavigate is a React Router hook that lets you programmatically navigate to a different route.
const NotFound = () => {
  const mynavigate = useNavigate();

  const goHome = () => {
    mynavigate("/"); //redirect to Home page
  };

  return (
    <div className="container mt-5 text-center">
      <h1 className="display-4">404</h1>
      <h3>Page Not Found</h3>
      <p>The page you are looking for does not exist.</p>
      <button className="btn btn-primary mt-3" onClick={goHome}>
        Go Back Home
      </button>
    </div>
  );
};

export default NotFound;

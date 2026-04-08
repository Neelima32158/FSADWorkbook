import { useEffect } from "react";
import { useNavigate, Link } from "react-router-dom";

function Home() {
    const navigate = useNavigate();

    useEffect(() => {
        if (!localStorage.getItem("username")) {
            navigate("/");
        }
    }, []);

    const logout = () => {
        localStorage.removeItem("username");
        navigate("/");
    };

    return (
        <div className="container">
            <h2>Home Page</h2>

            <Link to="/profile">Go to Profile</Link>
            <br /><br />

            <button onClick={logout}>Logout</button>
        </div>
    );
}

export default Home;
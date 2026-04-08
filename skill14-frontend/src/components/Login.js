import { useState } from "react";
import axios from "axios";
import { useNavigate, Link } from "react-router-dom";
function Login() {
    const [user, setUser] = useState({});
    const navigate = useNavigate();
    const handleLogin = async (e) => {
        e.preventDefault();
        const res = await axios.post("http://localhost:8080/api/auth/login", user);
        if (res.data) {
            localStorage.setItem("username", res.data.username);
            navigate("/home");
        } else {
            alert("Invalid credentials");
        }
    };
    return (
        <div className="container">
            <h2>Login</h2>
            <form onSubmit={handleLogin}>
                <input placeholder="Username"
                    onChange={(e) => setUser({ ...user, username: e.target.value })}
                />
                <input type="password" placeholder="Password"
                    onChange={(e) => setUser({ ...user, password: e.target.value })}
                />
                <button>Login</button>
            </form>
            <p>New user? <Link to="/register">Register</Link></p>
        </div>
    );
}
export default Login;
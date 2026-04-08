import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
function Register() {
    const [user, setUser] = useState({});
    const navigate = useNavigate();

    const handleRegister = async (e) => {
        e.preventDefault();
        await axios.post("http://localhost:8080/api/auth/register", user);
        alert("Registered Successfully");
        navigate("/");
    };
    return (
        <div className="container">
            <h2>Register</h2>
            <form onSubmit={handleRegister}>
                <input placeholder="Username"
                    onChange={(e) => setUser({ ...user, username: e.target.value })}
                />
                <input placeholder="Email"
                    onChange={(e) => setUser({ ...user, email: e.target.value })}
                />
                <input type="password" placeholder="Password"
                    onChange={(e) => setUser({ ...user, password: e.target.value })}
                />
                <button>Register</button>
            </form>
        </div>
    );
}

export default Register;
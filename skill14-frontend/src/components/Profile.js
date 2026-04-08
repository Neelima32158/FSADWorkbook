import { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Profile() {
    const [data, setData] = useState({});
    const navigate = useNavigate();

    const username = localStorage.getItem("username");

    useEffect(() => {
        if (!username) {
            navigate("/");
        } else {
            axios.get(`http://localhost:8080/api/auth/profile/${username}`)
                .then(res => setData(res.data));
        }
    }, []);

    return (
        <div className="container">
            <h2>Profile</h2>

            <p><b>Username:</b> {data.username}</p>
            <p><b>Email:</b> {data.email}</p>
        </div>
    );
}

export default Profile;
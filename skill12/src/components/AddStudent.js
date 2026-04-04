import React, { useState, useEffect } from "react";
import axios from "axios";
function AddStudent({ editStudent }) {
    const [student, setStudent] = useState({
        name: "", email: "", course: ""
    });
    useEffect(() => {
        if (editStudent) setStudent(editStudent);
    }, [editStudent]);

    const handleChange = (e) => {
        setStudent({ ...student, [e.target.name]: e.target.value });
    };
    const handleSubmit = (e) => {
        e.preventDefault();
        if (student.id) {
            axios.put(`http://localhost:8080/students/${student.id}`, student);
        } else {
            axios.post("http://localhost:8080/students", student);
        }

        window.location.reload();
    };

    return (
        <form onSubmit={handleSubmit}>
            <input name="name" value={student.name} onChange={handleChange} placeholder="Name" />
            <input name="email" value={student.email} onChange={handleChange} placeholder="Email" />
            <input name="course" value={student.course} onChange={handleChange} placeholder="Course" />
            <button type="submit">Save</button>
        </form>
    );
}

export default AddStudent;
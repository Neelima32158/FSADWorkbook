import React, { useEffect, useState } from "react";
import axios from "axios";
function StudentList({ setEditStudent, refresh }) {
  const [students, setStudents] = useState([]);
  useEffect(() => {
    axios.get("http://localhost:8080/students")
      .then(res => setStudents(res.data));
  }, [refresh]);
  const deleteStudent = (id) => {
    axios.delete(`http://localhost:8080/students/${id}`)
      .then(() => window.location.reload());
  };
  return (
    <table border="1">
      <thead>
        <tr>
          <th>Name</th><th>Email</th><th>Course</th><th>Actions</th>
        </tr>
      </thead>
      <tbody>
        {students.map(s => (
          <tr key={s.id}>
            <td>{s.name}</td>
            <td>{s.email}</td>
            <td>{s.course}</td>
            <td>
              <button onClick={() => setEditStudent(s)}>Edit</button>
              <button onClick={() => deleteStudent(s.id)}>Delete</button>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}
export default StudentList;
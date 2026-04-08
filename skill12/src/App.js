import React, { useState } from "react";
import StudentList from "./components/StudentList";
import AddStudent from "./components/AddStudent";
function App() {

  const [editStudent, setEditStudent] = useState(null);

  return (
    <div>
      <h1>Student Management System</h1>

      <AddStudent editStudent={editStudent} />
      <StudentList setEditStudent={setEditStudent} />
    </div>
  );
}

export default App;
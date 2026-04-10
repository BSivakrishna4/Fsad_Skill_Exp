import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Register() {
  const [user, setUser] = useState({ username: "", password: "" });
  const nav = useNavigate();

  const submit = () => {
    fetch("http://localhost:8080/api/register", {
      method: "POST",
      headers: {"Content-Type": "application/json"},
      body: JSON.stringify(user)
    }).then(() => nav("/"));
  };

  return (
    <>
      <h2>Register</h2>
      <input placeholder="Username"
        onChange={e => setUser({...user, username:e.target.value})}/>
      <input placeholder="Password"
        onChange={e => setUser({...user, password:e.target.value})}/>
      <button onClick={submit}>Register</button>
    </>
  );
}
export default Register;